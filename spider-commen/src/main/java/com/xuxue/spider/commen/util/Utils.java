package com.xuxue.spider.commen.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 静态方法的集合
 *
 * @author xuxue
 * @time 2017-2-5
 */
public class Utils {
    public static final Logger LOG = LoggerFactory.getLogger(Utils.class);

    public static void _assert(boolean condition, String message) throws RuntimeException {
        if (!condition) throw new RuntimeException(message);
    }

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Interrupted when sleep");
            }
        }
    }
}
