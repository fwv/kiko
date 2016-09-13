package com.kiko.tools;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @Author fengwei
 * Created on 2016/9/13/0013.
 */
public class LogUtils {

    private static PropertyConfigurator property;

    public static Logger log = null;

    static {
        property.configure("log4j.properties");
        log = Logger.getLogger(LogUtils.class.getName());
    }

    public static void main(String[] args) {
        LogUtils.log.info("hello, kiko!");
    }
}
