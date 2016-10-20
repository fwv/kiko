package com.kiko.rpc.core.client;

import com.kiko.netty.impl.HandlersInitializer;
import com.kiko.netty.impl.client.TcpClientUnit;
import com.kiko.protocol.serializable.SerializableProtocol;

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
        // 默认使用java提供的原生serializable编解码框架
        this(new SerializableProtocol());
    }

    public RpcClient(HandlersInitializer handlersInitializer) {
        rpcClientExcutor = new RpcClientExcutor();
        clientUnit = new TcpClientUnit();

        // 选择使用何种rpc编解码框架
        clientUnit.applyProtocol(handlersInitializer);

        // 添加rpc客户端处理器
        handler = new RpcClientHandler();
        handlersInitializer.addLastHandler(handler);
    }

    public void init() {
        clientUnit.init();
        rpcClientExcutor.proxy.sendHandler = handler;
    }

    public void start(String address, int port) {clientUnit.boot(address, port);}
}
