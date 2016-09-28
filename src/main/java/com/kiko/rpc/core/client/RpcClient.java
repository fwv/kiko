package com.kiko.rpc.core.client;

import com.kiko.netty.impl.client.TcpClientUnit;
import com.kiko.rpc.serialize.serializable.SerializableProtocol;

/**
 * @Author fengwei
 * Created on 2016/9/27/0027.
 * Rpc客户端
 */
public class RpcClient {

    public RpcClientExcutor rpcClientExcutor;

    public TcpClientUnit clientUnit;

    public RpcClientHandler handler;

    public RpcClient() {
        rpcClientExcutor = new RpcClientExcutor();
        SerializableProtocol protocol = new SerializableProtocol();

        handler = new RpcClientHandler();
        protocol.addLastHandler(handler);

        clientUnit = new TcpClientUnit();
        clientUnit.applyProtocol(protocol);
    }

    public void init() {
        clientUnit.init();
        rpcClientExcutor.proxy.sendHandler = handler;
    }

    public void start(String address, int port) {clientUnit.boot(address, port);}
}
