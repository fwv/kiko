package com.kiko.rpc.core.register;

import com.kiko.rpc.event.RpcRequest;

/**
 * @Author fengwei
 * Created on 2016/9/27/0027.
 * 注册中心
 */
public class RegisterManager {

    public static Object getRegisterObj(RpcRequest request) {
        // 使用反射实现
        String clazzName = "com.kiko.rpc.service.impl.";
        clazzName += request.getSimpleClassName();
        try {
             return Class.forName(clazzName).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //return new upperCaseShow();
        return null;
    }

}
