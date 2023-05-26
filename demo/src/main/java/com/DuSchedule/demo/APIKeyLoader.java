package com.DuSchedule.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class APIKeyLoader {
    public static String getAPIKey() {
        Properties properties = new Properties();
        try {
            String homeDirectory = System.getProperty("user.home");
            FileInputStream file = new FileInputStream(homeDirectory + "/Documents/Dev/config.properties");
            properties.load(file);
            file.close();
            return properties.getProperty("api.key");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}