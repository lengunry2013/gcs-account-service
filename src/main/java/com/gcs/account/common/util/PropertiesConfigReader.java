package com.gcs.account.common.util;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

/**
 * MessageConfigReader.
 */
@Slf4j
public class PropertiesConfigReader {

    /**
     * the file name of configuration.
     */
    public static final String MESSAGE_CONFIG_FILENAME = "message.properties";

    public static final String SECURITY_CONFIG_FILENAME = "security.properties";

    public static final String SERVICE_CONFIG_FILENAME = "config.properties";

    /**
     * the SystemConfig's object.
     */
    private static HashMap<String, Properties> configs = new HashMap<>();


    /**
     * constructor.
     */
    private PropertiesConfigReader() {

    }


    public static Properties getInstance(String configName) {
        if (configs.get(configName) == null) {
            synchronized (PropertiesConfigReader.class) {
                Properties prop = new Properties();
                InputStream is = PropertiesConfigReader.class.getClassLoader()
                        .getResourceAsStream(configName);
                try {
                    prop.load(is);
                } catch (IOException e) {
                    log.error("", e);
                } finally {
                    try {
                        is.close();
                    } catch (IOException e) {
                        log.error("", e);
                    }
                }
                configs.put(configName, prop);
            }
        }
        return configs.get(configName);
    }

    /**
     * get value.
     *
     * @param key
     * @return
     */
    public static String getStringValue(String configName, String key) {
        Properties prop = getInstance(configName);
        String value = (String) prop.get(key);
        if (value == null) {
            value = "";
        }
        return value;
    }


}
