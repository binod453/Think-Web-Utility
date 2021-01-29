package com.mps.think.utility.utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

	public String getQuery(String query)
	{			
		Properties properties=new Properties();
		try {
			properties.load(this.getClass().getResourceAsStream("/jdbc.properties"));
		} 
		catch (IOException e) {
		}
		return properties.getProperty(query);
	}
}
