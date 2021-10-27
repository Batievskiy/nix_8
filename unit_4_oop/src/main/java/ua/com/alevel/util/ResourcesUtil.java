package ua.com.alevel.util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static ua.com.alevel.config.PropertiesConfig.APPLICATION_PROPERTIES;

public final class ResourcesUtil {

    private ResourcesUtil() { }

    public static Map<String, String> getProperties(ClassLoader classLoader) {
        try {
            InputStream inputStream = classLoader.getResourceAsStream(APPLICATION_PROPERTIES.getProperties());
            Properties properties = new Properties();
            properties.load(inputStream);
            HashMap<String, String> propertiesHashMap = new HashMap<>();
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                propertiesHashMap.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
            }
            return propertiesHashMap;
        } catch (IOException e) {
            throw new RuntimeException("file -> " + APPLICATION_PROPERTIES.getProperties() + " NOT FOUND!");
        }
    }
}
