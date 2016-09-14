package com.kiko.tools;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author fengwei
 * Created on 2016/9/13/0013.
 */
public class LogUtils {

    private static PropertyConfigurator property;

    public static Logger log = null;

    static {
        //System.setProperty("log4j.configuration", "log4j.properties");
        //property.configure("log4j.properties");
        log = LoggerFactory.getLogger(LogUtils.class.getName());
    }

    public static void main(String[] args) {
        LogUtils.log.info("hello, kiko!");
    }
}
