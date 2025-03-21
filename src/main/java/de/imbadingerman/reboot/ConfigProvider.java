package de.imbadingerman.reboot;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProvider {
    private final Properties properties;

    private ConfigProvider() {
        properties = new Properties();
        loadProperties();
    }

    private static final class InstanceHolder {
        static final ConfigProvider instance = new ConfigProvider();
    }

    public static ConfigProvider getInstance() {
        return InstanceHolder.instance;
    }

    private void loadProperties() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}