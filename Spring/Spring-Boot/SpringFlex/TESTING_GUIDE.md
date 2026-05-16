Testing Guide — SpringFlex

Checklist (what I'll cover)
- Project and environment choices (Java, Spring Boot, Maven wrapper)
- Dependencies to add to `pom.xml` (test and runtime)
- Directory & package layout for tests
- Test types and where to use them (unit, slice, integration)
- Annotations and why (e.g. `@DataJpaTest`, `@SpringBootTest`, `@AutoConfigureMockMvc`)
- Test fixtures and isolation (H2 in-memory, `application-test.properties`, cleanup)
- Test utilities used (MockMvc, TestEntityManager, ObjectMapper)
- How to write each test type (models, repository, JDBC service, controllers)
- Running tests locally and CI tips
- Troubleshooting common errors and fixes

Purpose
This document explains, step-by-step, how I created the test suite for the SpringFlex project and how a developer would do the same manually. It includes commands, file names, annotation choices and the rationale for each decision.

1) Project and environment choices
- Java: 17 — chosen because the project `pom.xml` declares `<java.version>17</java.version>` and Spring Boot 3.x requires Java 17+.
- Spring Boot: 3.3.6 — used in this project. Newer Spring Boot versions bring changes; tests and libraries may differ across major versions.
- Build tool: Maven with wrapper (`mvnw.cmd`) — use the wrapper so other developers and CI run the same Maven version without installing Maven globally.

Why these choices?
- Java 17 is LTS and required by modern Spring Boot 3.x.
- Using the Maven wrapper ensures reproducible builds across machines.

Commands (PowerShell)
```powershell
# Run tests using Maven wrapper (Windows PowerShell)
.\mvnw.cmd clean test

# Run a single test class
.\mvnw.cmd -Dtest=BookControllerTest test
```

2) Dependencies to add to `pom.xml`
Minimum dependencies for tests we used (already present in project):
- `spring-boot-starter-test` (scope `test`) — brings JUnit 5 (Jupiter), Mockito, AssertJ, Spring Test, MockMvc, etc.
- `h2` (scope `runtime`) — in-memory database for repository and integration tests
- `spring-boot-starter-data-jpa` — to test JPA repositories
- `spring-boot-starter-jdbc` — for JDBC template based service tests
- `lombok` (optional at compile time) — project uses Lombok for `Employee`

Rationale
- `spring-boot-starter-test` is the standard testing bundle for Spring Boot — it avoids adding each test dependency manually.
- H2 is fast, in-memory and suitable for tests where you don't need an external DB.

3) Test directory and package layout
Follow the same package hierarchy as `src/main/java` but under `src/test/java`. Example used in the project:
- `src/test/java/com/ib/springflex/model/BookTest.java`
- `src/test/java/com/ib/springflex/repository/BookRepositoryTest.java`
- `src/test/java/com/ib/springflex/controller/BookControllerTest.java`

Why this matters
- Spring Boot test auto-configuration discovers `@SpringBootConfiguration` from tests when tests live under the same base package. If tests are placed outside that tree, you must explicitly provide configuration (e.g. `@SpringBootTest(classes = SpringFlexApplication.class)`).

4) Test types and when to use them
- Unit tests (plain JUnit): test small, isolated pieces of logic without Spring context. Use for POJOs and logic-only classes.
  - Example: `BookTest`, `EmployeeTest` — test getters/setters, constructors, toString(), equals/hashCode, basic behavior.
- Slice tests:
  - `@DataJpaTest` — for testing JPA repositories. Loads only JPA-related beans, configures an in-memory database by default; fast and focused.
  - `@WebMvcTest` — for controller slice tests (loads controller and MVC infra) — useful when you want to mock service/repository dependencies. We used full-context tests (`@SpringBootTest` + `@AutoConfigureMockMvc`) instead to reuse real repositories for integration-style controller tests.
- Integration tests (`@SpringBootTest`): loads the full Spring context. Use for services that need many beans (e.g. `BookJdbcService` uses `JdbcTemplate`) or when the interaction between layers must be validated end-to-end.

Why each annotation was chosen in this project
- `@DataJpaTest` for `BookRepositoryTest` — it's faster and isolates the JPA layer; we used `TestEntityManager` for setup.
- `@SpringBootTest` for `BookJdbcServiceTest` — `JdbcTemplate` and related beans are available through full context. You could also use `@JdbcTest` but that is narrower and requires extra wiring for custom beans.
- `@SpringBootTest` + `@AutoConfigureMockMvc` for controller tests — this loads the full context and allows testing controllers with real repositories and services using `MockMvc` without starting a server. Alternatively `@WebMvcTest` + mocked dependencies can be used for pure controller unit tests.

5) Test configuration and isolation (application-test.properties)
Create `src/test/resources/application-test.properties` and override runtime properties for tests. Example values (used in the test suite):
```
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

logging.level.root=WARN
logging.level.com.ib.springflex=DEBUG
```
Why:
- `jdbc:h2:mem:testdb` creates a fast, in-memory DB that is unique to the test JVM.
- `ddl-auto=create-drop` makes the schema created at startup and dropped at end, guaranteeing a clean state.
- Setting logging to DEBUG for your package helps when debugging tests but keeping root WARN prevents noisy logs.

6) Utilities used in tests
- `MockMvc` — perform HTTP requests against the application context without starting a server.
- `ObjectMapper` — serialize/deserialize JSON for request/response bodies.
- `TestEntityManager` — simplified entity manager used in `@DataJpaTest` for seeding the DB.
- `JdbcTemplate` — used in the application `BookJdbcService`; tests call the service methods directly.

7) Writing tests — file-by-file approach (what I created and why)
- Model tests (`BookTest`, `EmployeeTest`):
  - Keep these as plain JUnit tests (no Spring context) because they validate constructor, getters/setters, and Lombok behavior.
  - Why: fastest to run and don't require wiring.

- Repository tests (`BookRepositoryTest`):
  - Annotate with `@DataJpaTest` and inject `TestEntityManager` and `BookRepository`.
  - Use `entityManager.persistAndFlush()` to seed data when needed.
  - Test `save`, `findById`, `findAll`, `delete`, `count`, `existsById`.
  - Why: `@DataJpaTest` limits loaded beans to only what's necessary for JPA — faster and less brittle.

- JDBC service tests (`BookJdbcServiceTest`):
  - Use `@SpringBootTest` (full context) because the service uses `JdbcTemplate` and the SQL operations + `PreparedStatement` with generated keys need real JDBC wiring.
  - Ensure test DB (`application-test.properties`) is active so SQL runs against H2.
  - Clean up before each test: fetch and delete existing rows so tests are isolated.
  - Test create with/without id, fetch all, update, delete.
  - Why not `@DataJpaTest`? Because BookJdbcService uses raw JDBC, not JPA; a JPA slice wouldn't provide what JdbcTemplate expects.

- Controller tests (`BookControllerTest`, `BookJdbcControllerTest`, `FlexFeatureControllerTest`):
  - Use `@SpringBootTest` + `@AutoConfigureMockMvc` so controllers, services, repositories, and JDBC beans are available and HTTP interaction is simulated via MockMvc.
  - For pure controller unit tests you could use `@WebMvcTest(controllers = BookController.class)` and mock `BookRepository` with Mockito — that's faster but tests controllers in isolation.
  - Test endpoints: POST, GET, PUT, DELETE, and special endpoints (like `/gen`). Validate JSON response fields using `jsonPath` and assert repository state where appropriate.
  - For error conditions (e.g. updating a non-existing book) either assert the expected HTTP status (5xx or 404 depending on how you design your controller advice) or catch and assert the thrown exception in tests.

8) Test isolation and cleanup
- Use `@BeforeEach` to prepare state and remove leftover data (e.g., delete all rows in H2 for JDBC tests).
- For `@DataJpaTest`, transactions are rolled back by default, which isolates each test method.
- For `@SpringBootTest` tests, ensure you clean up manually if the context doesn't rollback changes automatically.

9) Common pitfalls and fixes
- "Unable to find a @SpringBootConfiguration" — happens when test class package is not in the same or a child package of the main `@SpringBootApplication` annotated class. Fix: move test under same base package or annotate test with `@SpringBootTest(classes = SpringFlexApplication.class)`.
- Tests failing due to missing dependencies — confirm `spring-boot-starter-test` is in `pom.xml` with scope `test`.
- Tests that interact with DB require H2 on the classpath or a configured test database.
- Controller tests throwing uncaught exceptions — either expect the error (with `andExpect(status().is5xxServerError())`) or catch the exception in the test if you're testing thrown behavior.

10) Running tests
- Run all tests:
```powershell
.\mvnw.cmd clean test
```
- Run a single test class:
```powershell
.\mvnw.cmd -Dtest=BookControllerTest test
```
- Run tests and generate coverage (if using Jacoco plugin in `pom.xml`):
```powershell
.\mvnw.cmd clean test jacoco:report
```

11) Continuous Integration tips
- Use the same JDK version in CI as locally (Java 17 here).
- Use the Maven wrapper `mvnw` in CI pipelines for reproducible Maven.
- Run tests in parallel cautiously — database-backed tests may interfere; use separate in-memory DB instances or configure uniquely per thread if required.

12) Advanced suggestions
- Use `@WebMvcTest` for fast controller slice tests and mock service/repo dependencies with Mockito.
- Add `@TestConfiguration` inner classes when you need to provide test-only beans.
- Use `@Sql` or `data.sql` placed under `src/test/resources` for controlled DB fixtures when tests need complex data.
- Consider `Testcontainers` when you want to run tests against a real database engine (Postgres, MySQL) in CI.

13) Why I organized the test suite the way I did (rationale recap)
- Keep unit tests fast and independent of Spring context.
- Use `@DataJpaTest` for repository layer to speed up JPA tests and limit scope.
- Use `@SpringBootTest` for components that need full wiring (JdbcTemplate, end-to-end controller tests with real repositories).
- Use H2 in-memory DB to avoid external dependencies and ensure deterministic tests.
- Use `MockMvc` for accurate HTTP-level testing without starting a server.

14) Files I created in this project (for quick reference)
- `src/test/java/com/ib/springflex/model/BookTest.java`
- `src/test/java/com/ib/springflex/model/EmployeeTest.java`
- `src/test/java/com/ib/springflex/repository/BookRepositoryTest.java`
- `src/test/java/com/ib/springflex/repository/BookJdbcServiceTest.java`
- `src/test/java/com/ib/springflex/controller/BookControllerTest.java`
- `src/test/java/com/ib/springflex/controller/BookJdbcControllerTest.java`
- `src/test/java/com/ib/springflex/controller/FlexFeatureControllerTest.java`
- `src/test/resources/application-test.properties`

15) Troubleshooting checklist (if tests fail)
- Is `spring-boot-starter-test` present in `pom.xml`?
- Are tests under the same package tree as `@SpringBootApplication`? (fix package or specify classes in `@SpringBootTest`)
- Is H2 available and test DB configured (`application-test.properties`)?
- Inspect `target/surefire-reports` test output files when Maven reports failures.

16) Next steps and recommendations
- Add more negative and edge case tests (null fields, very large payloads, SQL injection attempts for JDBC service inputs).
- Add contract tests (for REST API) if other services depend on these endpoints.
- Integrate Jacoco or other coverage tool to measure coverage and set thresholds in CI.

---
If you'd like, I can also:
- Add `@WebMvcTest`-style slice tests for `BookController` that mock `BookRepository` (faster controller-only tests).
- Add Jacoco configuration to `pom.xml` and produce a coverage badge.
- Add sample CI pipeline YAML (GitHub Actions) that runs the tests with the Maven wrapper and publishes the report.



