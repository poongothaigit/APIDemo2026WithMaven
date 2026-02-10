package com.DemoAPI2026.Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	static Properties prop;
	public static String getProperty(String key) {

        try {
            prop = new Properties();
            FileInputStream file =
                    new FileInputStream("src/test/resources/config.properties");

            prop.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return prop.getProperty(key);
    }
}
