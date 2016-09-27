package com.kiko.rpc.core.client;

import java.lang.reflect.Proxy;

/**
 * @Author fengwei
 * Created on 2016/9/27/0027.
 * Rpc客户端执行器
 */
public class RpcClientExcutor {


    public <T> T execute(Class<T> rpcInterface) {
        return (T) Proxy.newProxyInstance(rpcInterface.getClassLoader(),
                rpcInterface.getInterfaces(), new RpcClientProxy());
    }


}
