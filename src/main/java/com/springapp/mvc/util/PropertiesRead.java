package com.springapp.mvc.util;

import org.apache.poi.util.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @auther f4o823hv9
 * @since  2017/7/11.
 */
public class PropertiesRead {
    private static Properties properties = new Properties();


     static {
        InputStream resourceAsStream = PropertiesRead.class.getClassLoader().getResourceAsStream("system.properties");
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(resourceAsStream);
        }
    }

    public static String getString(String key) {
        return properties.getProperty(key);
    }


}
