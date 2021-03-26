package com.mps.think.utility.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class LoginModel implements Serializable{

	private static final long serialVersionUID = 4437280622506891435L;
	
	//@NotEmpty(message = "Username should not be Empty")
	private String username;
	
	//@NotEmpty(message = "Password should not be Empty")
	private String password;
	
	//@NotEmpty(message = "Please select a value from dropdown")
	private String dsn;
	
	private String userCode;
	private String publisher;
	private String token;
	private String status;
}
