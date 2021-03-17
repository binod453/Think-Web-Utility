package com.mps.think.utility.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class RenewalCodeDataDetails implements Serializable{

	private static final long serialVersionUID = -4431069449762574126L;
	
	private int fromCycle;
	private int toCycle;
	private int value;
	private String type;
	private String currency;
}
