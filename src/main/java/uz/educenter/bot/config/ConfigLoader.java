package uz.educenter.bot.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private static final String CONFIG_FILE = "config.properties";
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                throw new RuntimeException("Config file not found: " + CONFIG_FILE);
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file: " + CONFIG_FILE, e);
        }
    }

    private ConfigLoader() {
    }

    public static String get(String key) {
        String value = properties.getProperty(key);
        if (value == null || value.isBlank()) {
            throw new RuntimeException("Missing config value for key: " + key);
        }
        return value.trim();
    }
}