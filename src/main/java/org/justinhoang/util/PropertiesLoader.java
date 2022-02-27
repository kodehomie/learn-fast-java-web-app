package org.justinhoang.util;

import java.io.IOException;
import java.util.Properties;

/**
 * The interface Properties loader.
 */
public interface PropertiesLoader {


    /**
     * Load properties properties.
     *
     * @param propertiesFilePath the properties file path
     * @return the properties
     */
    default Properties loadProperties(String propertiesFilePath) {
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return properties;
    }
}
