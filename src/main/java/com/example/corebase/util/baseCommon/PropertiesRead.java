package com.example.corebase.util.baseCommon;

import com.example.corebase.infrastructure.constant.Constants;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

@Slf4j
public class PropertiesRead {

    public PropertiesRead() {
    }

    private static Properties applicationProperties = new Properties();
    private static Properties messageVnProperties = new Properties();
    private static Properties messageEnProperties = new Properties();


    static {
        // Load application properties file
        try (
                InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(Constants.FileProperties.PROPERTIES_APPLICATION);
                InputStreamReader reader = new InputStreamReader(is, Constants.ENCODING_UTF8);) {
            applicationProperties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Load message vietnamese properties file
        try (
                InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(Constants.FileProperties.PROPERTIES_MESSAGE_VN);
                InputStreamReader reader = new InputStreamReader(is, Constants.ENCODING_UTF8);
        ) {
            messageVnProperties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Load message english properties file
        try (
                InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(Constants.FileProperties.PROPERTIES_MESSAGE_EN);
                InputStreamReader reader = new InputStreamReader(is, Constants.ENCODING_UTF8);
        ) {
            messageEnProperties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param propertyName
     * @return Property values in {@code messages.properties} file. If you want to
     * get property values in {@code application.properties}, use
     * {@code getProperty(propertyName, Constants.PROPERTIES_APPLICATION)}
     * instead.
     */

    public static String getProperty(String propertyName, String propertiesType) {
        try {
            switch (propertiesType) {
                case Constants.FileProperties.PROPERTIES_APPLICATION:
                    return applicationProperties.getProperty(propertyName);
                case Constants.FileProperties.PROPERTIES_MESSAGE_VN:
                    return messageVnProperties.getProperty(propertyName);
                case Constants.FileProperties.PROPERTIES_MESSAGE_EN:
                    return messageEnProperties.getProperty(propertyName);
                default:
                    return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
