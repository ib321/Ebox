package com.ib.springflex.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    private Employee employee;

    @BeforeEach
    public void setUp() {
        employee = new Employee();
    }

    @Test
    public void testEmployeeNoArgsConstructor() {
        assertNotNull(employee);
        assertNull(employee.getId());
        assertNull(employee.getName());
        assertNull(employee.getDepartment());
    }

    @Test
    public void testEmployeeAllArgsConstructor() {
        Employee emp = new Employee(1L, "John Doe", "Engineering");
        assertEquals(1L, emp.getId());
        assertEquals("John Doe", emp.getName());
        assertEquals("Engineering", emp.getDepartment());
    }

    @Test
    public void testSetAndGetId() {
        employee.setId(5L);
        assertEquals(5L, employee.getId());
    }

    @Test
    public void testSetAndGetName() {
        employee.setName("Jane Smith");
        assertEquals("Jane Smith", employee.getName());
    }

    @Test
    public void testSetAndGetDepartment() {
        employee.setDepartment("Sales");
        assertEquals("Sales", employee.getDepartment());
    }

    @Test
    public void testEmployeeWithAllFields() {
        employee.setId(10L);
        employee.setName("Alice Johnson");
        employee.setDepartment("Marketing");

        assertEquals(10L, employee.getId());
        assertEquals("Alice Johnson", employee.getName());
        assertEquals("Marketing", employee.getDepartment());
    }

    @Test
    public void testEmployeeEquality() {
        Employee emp1 = new Employee(1L, "Employee1", "Department1");
        Employee emp2 = new Employee(1L, "Employee1", "Department1");

        assertEquals(emp1.getId(), emp2.getId());
        assertEquals(emp1.getName(), emp2.getName());
        assertEquals(emp1.getDepartment(), emp2.getDepartment());
    }

    @Test
    public void testEmployeeToString() {
        employee.setId(1L);
        employee.setName("Test Employee");
        employee.setDepartment("IT");

        String toString = employee.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("1") || toString.contains("Test Employee") || toString.contains("IT"));
    }

    @Test
    public void testEmployeeModification() {
        employee.setId(1L);
        employee.setName("Original Name");
        employee.setDepartment("Original Dept");

        employee.setName("Modified Name");
        employee.setDepartment("Modified Dept");

        assertEquals("Modified Name", employee.getName());
        assertEquals("Modified Dept", employee.getDepartment());
    }

    @Test
    public void testMultipleEmployees() {
        Employee emp1 = new Employee(1L, "Employee1", "Dept1");
        Employee emp2 = new Employee(2L, "Employee2", "Dept2");
        Employee emp3 = new Employee(3L, "Employee3", "Dept3");

        assertEquals(1L, emp1.getId());
        assertEquals(2L, emp2.getId());
        assertEquals(3L, emp3.getId());
    }
}

