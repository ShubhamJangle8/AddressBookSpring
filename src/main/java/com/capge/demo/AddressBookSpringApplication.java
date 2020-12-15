package com.capge.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class AddressBookSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AddressBookSpringApplication.class, args);
		log.info("AddressBook app App started in {} environment", context.getEnvironment().getProperty("environment"));
		log.info("Address book DB user is {} ", context.getEnvironment().getProperty("spring.datasource.username"));
	}

}
