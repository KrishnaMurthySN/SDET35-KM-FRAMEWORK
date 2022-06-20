package com.crm.comcast.generic_utilities;

import java.io.FileInputStream;

import java.util.Properties;

public class File_Utilities {
//flib updated
	public String getPropertyFile(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./data/Data.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	}

}
