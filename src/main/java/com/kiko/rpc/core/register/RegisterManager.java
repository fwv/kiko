package com.kiko.rpc.core.register;

import com.kiko.rpc.service.impl.upperCaseShowImpl;

/**
 * @Author fengwei
 * Created on 2016/9/27/0027.
 * 注册中心
 */
public class RegisterManager {

    public static Object getRegisterObj() {
        return new upperCaseShowImpl();
    }
}
