package com.kiko.rpc.core.server;

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
        rpcServerExcutor = new RpcServerExcutor();
        SerializableProtocol protocol = new SerializableProtocol();
        protocol.addLastHandler(new RpcServerHandler());
        serverUnit = new TcpServerUnit();
        serverUnit.applyProtocol(protocol);
    }

    public void init() {serverUnit.init();}

    public void start(int port) {serverUnit.boot(port);}
}
