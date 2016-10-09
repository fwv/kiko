package com.kiko.rpc.core.server;

import com.kiko.netty.impl.HandlersInitializer;
import com.kiko.netty.impl.server.TcpServerUnit;
import com.kiko.rpc.serialize.serializable.SerializableProtocol;

/**
 * @Author fengwei
 * Created on 2016/9/28/0028.
 * Rpc服务器
 */
public class RpcServer {

    public RpcServerExcutor rpcServerExcutor;

    public TcpServerUnit serverUnit;

    public RpcServer() {
        this(new SerializableProtocol());
    }

    public RpcServer(HandlersInitializer handlersInitializer) {
        rpcServerExcutor = new RpcServerExcutor();
        serverUnit = new TcpServerUnit();

        serverUnit.applyProtocol(handlersInitializer);

        handlersInitializer.addLastHandler(new RpcServerHandler());
    }

    public void init() {serverUnit.init();}

    public void start(int port) {serverUnit.boot(port);}
}
