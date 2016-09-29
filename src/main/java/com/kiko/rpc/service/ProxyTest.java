package com.kiko.rpc.service;

import com.kiko.tools.LogUtils;

import java.lang.reflect.Proxy;

/**
 * @Author fengwei
 * Created on 2016/9/29/0029.
 */
public class ProxyTest {

    public static void main(String[] args) {
        InterfaceProxy proxy = new InterfaceProxy();
        upperCaseShow upper = (upperCaseShow)Proxy.newProxyInstance(upperCaseShow.class.getClassLoader(), new Class[]{upperCaseShow.class}, proxy);
        String result = upper.doUpperCase("kiko");
        LogUtils.log.info(result);
    }

}
