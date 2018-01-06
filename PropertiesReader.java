package com.sa.props;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class PropertiesReader {

	private static Properties properties;

	public PropertiesReader(String propertiesFile) {
		properties = new Properties();
		try {
			InputStream input = new FileInputStream(propertiesFile);
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getSinglePropery(String propertyName) {
		return properties.getProperty(propertyName);
	}

	public static String getSinglePropery(String propertiesFile, String propertyName) {
		new PropertiesReader(propertiesFile);
		return properties.getProperty(propertyName);
	}

	public ArrayList<String> getRepeatingProperty(String propertyName) {
		String propertyLine = properties.getProperty(propertyName);
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(propertyLine.split(",")));
		return list;
	}

	public static ArrayList<String> getRepeatingProperty(String propertiesFile, String propertyName) {
		new PropertiesReader(propertiesFile);
		String propertyLine = properties.getProperty(propertyName);
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(propertyLine.split(",")));
		return list;
	}
}
