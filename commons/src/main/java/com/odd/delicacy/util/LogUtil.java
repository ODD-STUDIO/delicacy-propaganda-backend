package com.odd.delicacy.util;

import org.slf4j.Logger;

/**
 * 日志工具类
 *
 * @author Tanglinfeng
 * @date 2021/7/6 10:05
 */
public class LogUtil {

    public static void debug(final Logger logger, final String msg, final Object... values) {
        if (logger.isDebugEnabled()) {
            logger.debug(msg, values);
        }
    }

    public static void info(final Logger logger, final String msg, final Object... values) {
        if (logger.isInfoEnabled()) {
            logger.info(msg, values);
        }
    }

    public static void error(final Logger logger, final String msg, final Object... values) {
        if (logger.isErrorEnabled()) {
            logger.error(msg, values);
        }
    }

    public static void warn(final Logger logger, final String msg, final Object... values) {
        if (logger.isWarnEnabled()) {
            logger.warn(msg, values);
        }
    }
}
