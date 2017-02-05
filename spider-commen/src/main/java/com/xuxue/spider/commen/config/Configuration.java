package com.xuxue.spider.commen.config;

/**
 * @author xuxue
 * @time 2017-2-5
 */
public interface Configuration {
    int getInt(String key, int defaultValue);

    String getString(String key, String defaultValue);

    long getLong(String key, long defaultValue);

    boolean getBoolean(String key, boolean defaultValue);
}
