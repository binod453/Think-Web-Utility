package com.mps.think.utility.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class LoginModel implements Serializable{

	private static final long serialVersionUID = 4437280622506891435L;
	
	private String username;
	private String password;
	private String dsn;
	private String userCode;
	private String publisher;
	private String token;
	private String status;
}
