package com.kiko.tools;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @Author fengwei
 * Created on 2016/9/13/0013.
 */
public class SpringUtils {

    public static ApplicationContext context;

    private static SpringUtils springUtils;

    public static SpringUtils getInstance() {
        synchronized (SpringUtils.class) {
            // lazy load
            if (null == springUtils) {
                springUtils = new SpringUtils();
            }
        }
        return springUtils;
    }

    private SpringUtils() {
        context = new FileSystemXmlApplicationContext("kiko-beans.xml");
    }

    public Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    public <T> T getBean(String beanName, Class<T> clazz) {
        return context.getBean(beanName, clazz);
    }

}
