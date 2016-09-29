package com.kiko.rpc.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author fengwei
 * Created on 2016/9/29/0029.
 */
public class InterfaceProxy implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String s = (String)args[0];
        return s.toUpperCase();
    }
}
