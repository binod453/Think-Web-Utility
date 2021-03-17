package com.mps.think.utility.model;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

@Data
public class DynamicRenewalCodeModel implements Serializable{
	private static final long serialVersionUID = 6013469898664449783L;
	
	private int slNo;
	private String dynamicCode;
	private String offerType;
	private String description;
	private int activeFrom;
	private int activeTo;
	private RenewalCodeDataDetails renewalCodeDataDetails;
	private LoginModel loginModel;
}
