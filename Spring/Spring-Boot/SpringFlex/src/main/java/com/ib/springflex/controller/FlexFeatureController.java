package com.ib.springflex.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ib.springflex.model.Employee;

@RestController
@RequestMapping
public class FlexFeatureController {

	// creating a logger
	Logger logger = LoggerFactory.getLogger(FlexFeatureController.class);

	@GetMapping("")
	public String flexHome() {
		logger.warn("dude I'm warning you! You are at flex Home.");
		return "Hey not so stranger :) You are at right place!";
	}

	@GetMapping("/log")
	public String log() {
		logger.info("Logging various log level messages");
		logger.trace("Log level: TRACE");
		logger.info("Log level: INFO");
		logger.debug("Log level: DEBUG");
		logger.error("Log level: ERROR");
		logger.warn("Log level: WARN");
		logger.info("You wondering why didn't debug and trace showing in console?");
		return "Hey! You can check the output in the logs";
	}

	@GetMapping("/lombok")
	public Employee lombok() {
		Employee employee = new Employee(1L, "John Doe", "Engineering");
		System.out.println(employee.toString());
		logger.info(employee.toString());
		return employee;
	}

}
