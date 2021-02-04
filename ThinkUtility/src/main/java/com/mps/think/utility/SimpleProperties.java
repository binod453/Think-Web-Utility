package com.mps.think.utility;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
@ConfigurationProperties(prefix = "simple")
public class SimpleProperties {
	private String a;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}
}
