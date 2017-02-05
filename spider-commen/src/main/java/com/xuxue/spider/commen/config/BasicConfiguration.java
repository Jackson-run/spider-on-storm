package com.xuxue.spider.commen.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * @author xuxue
 * @time 2017-2-5
 */
public class BasicConfiguration implements Configuration {
    public static final Logger LOG = LoggerFactory.getLogger(BasicConfiguration.class);

    private Properties properties = new Properties();

    public BasicConfiguration(String filePath) throws IOException {
        try (InputStream in = new FileInputStream(filePath)) {
            properties.load(in);
        }
    }

    public BasicConfiguration(Map<String, String> data) {
        data.forEach((String key, String value) -> properties.put(key, value));
    }

    @Override
    public int getInt(String key, int defaultValue) {
        try {
            return Integer.parseInt(properties.getProperty(key));
        } catch (Exception e) {
            return defaultValue;
        }
    }

    @Override
    public String getString(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    @Override
    public long getLong(String key, long defaultValue) {
        try {
            return Long.parseLong(properties.getProperty(key));
        } catch (Exception e) {
            return defaultValue;
        }
    }

    @Override
    public boolean getBoolean(String key, boolean defaultValue) {
        try {
            return Boolean.parseBoolean(properties.getProperty(key));
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
