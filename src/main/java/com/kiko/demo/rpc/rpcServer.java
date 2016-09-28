package com.kiko.demo.rpc;

import com.kiko.rpc.core.server.RpcServer;

/**
 * @Author fengwei
 * Created on 2016/9/28/0028.
 */
public class rpcServer {
    public static void main(String[] args) {
        RpcServer server = new RpcServer();
        server.init();
        server.start(8000);
    }
}
