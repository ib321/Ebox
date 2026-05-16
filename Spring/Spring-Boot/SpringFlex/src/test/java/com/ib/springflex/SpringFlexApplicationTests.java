package com.ib.springflex;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SpringFlexApplicationTests {

	@Test
	public void contextLoads() {
		assertTrue(true);
	}

	@Test
	public void applicationStartsSuccessfully() {
		SpringFlexApplication.main(new String[]{});
	}
}
