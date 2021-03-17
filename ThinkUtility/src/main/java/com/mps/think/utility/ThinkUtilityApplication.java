package com.mps.think.utility;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThinkUtilityApplication {
	Logger log = LoggerFactory.getLogger(ThinkUtilityApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ThinkUtilityApplication.class, args);
	}
}
