package com.mps.think.utility;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties(SimpleProperties.class)
//@ComponentScan(basePackages = "com.mps.think")
public class ThinkUtilityApplication {
	Logger log = LoggerFactory.getLogger(ThinkUtilityApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ThinkUtilityApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner runner(SimpleProperties simpleProperties) {
        return r -> {
            log.info("hello:{}",simpleProperties.getA());
           // log.info(nestedProperties.getA().getB());
        };
    }
}
