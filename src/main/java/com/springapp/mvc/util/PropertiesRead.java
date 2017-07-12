package com.springapp.mvc.util;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.poi.util.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @auther f4o823hv9
 * @since  2017/7/11.
 */
public class PropertiesRead {
    private static PropertiesConfiguration properties = null;

     static {
         try {
             properties = new PropertiesConfiguration(PropertiesRead.class.getResource("/system.properties"));
             properties.setReloadingStrategy(new FileChangedReloadingStrategy());
         } catch (ConfigurationException e) {
             e.printStackTrace();
         }
     }

    public static String getString(String key) {
        return properties.getString(key);
    }

    public static List<Object> getList(String key){
        return properties.getList(key);
    }


}
