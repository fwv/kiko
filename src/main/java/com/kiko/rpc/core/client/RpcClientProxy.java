package com.kiko.rpc.core.client;

import com.kiko.rpc.event.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * @Author fengwei
 * Created on 2016/9/27/0027.
 * Rpc客户端代理类
 */
public class RpcClientProxy implements InvocationHandler{

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 组装请求
        RpcRequest request = new RpcRequest();
        request.setId(UUID.randomUUID().toString());
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParamTypes(method.getParameterTypes());
        request.setParams(args);

        // 发送请求
        // ....

        return null;
    }

}
