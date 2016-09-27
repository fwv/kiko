package com.kiko.rpc.util;

import com.kiko.rpc.event.RpcRequest;
import com.kiko.rpc.event.RpcResponse;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author fengwei
 * Created on 2016/9/27/0027.
 */
public class RpcCallback {

    private RpcRequest request;

    private RpcResponse response;

    private ReentrantLock lock;


}
