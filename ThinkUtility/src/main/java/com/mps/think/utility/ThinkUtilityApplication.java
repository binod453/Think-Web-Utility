package com.mps.think.utility;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ThinkUtilityApplication extends SpringBootServletInitializer{
	Logger log = LoggerFactory.getLogger(ThinkUtilityApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ThinkUtilityApplication.class, args);
	}
}
