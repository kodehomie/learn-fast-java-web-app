package org.justinhoang.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public interface PropertiesLoader
{
    default Properties load(String filePath)
    {
        Properties  properties  = new Properties();
        try (InputStream inputStream = findFile(filePath))
        {
            properties.load(inputStream);
        }
        catch (IOException ignore)
        {
        }
        return properties;
    }

    private InputStream findFile(String fileName) throws FileNotFoundException
    {
        InputStream inputStream = findInWorkingDirectory(fileName);
        if (inputStream == null)
            inputStream = findInClasspath(fileName);
        if (inputStream == null)
            inputStream = findInSourceDirectory(fileName);
        return inputStream;
    }

    private InputStream findInSourceDirectory(String fileName) throws
                                                               FileNotFoundException
    {
        return new FileInputStream("src/main/resources/" + fileName);
    }

    private InputStream findInClasspath(String fileName)
    {
        return Thread.currentThread().getContextClassLoader()
                     .getResourceAsStream(fileName);
    }

    private InputStream findInWorkingDirectory(String fileName)
    {
        try
        {
            return new FileInputStream(
                    System.getProperty("user.dir") + fileName);
        }
        catch (FileNotFoundException e)
        {
            return null;
        }
    }
}
