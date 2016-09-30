package com.kiko.rpc.util;

/**
 * @Author fengwei
 * Created on 2016/9/30/0030.
 */
public class RpcState {
    public static String create(boolean result, String desc, String path) {
        return result ? "Rpc Successfully!" :
                (path != null ? "Rpc Failed : " + desc + ", source path : " + path : "Rpc Failed : " + desc);
    }
}
