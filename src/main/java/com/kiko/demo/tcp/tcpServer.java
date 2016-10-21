package com.kiko.demo.tcp;

import com.kiko.demo.handler.ServerHandler;
import com.kiko.demo.handler.protobuf.ProtobufServerHandler;
import com.kiko.net.tcp.TcpServer;
import com.kiko.netty.impl.HandlersInitializer;
import com.kiko.protocol.SerializeFactory;

/**
 * @Author fengwei
 * Created on 2016/10/20/0020.
 */
public class tcpServer {

    public static void main(String[] args) {
        //serializableServer();
        //protobufServer();
        TcpServer server = new TcpServer();
        HandlersInitializer handlersInitializer = SerializeFactory.applyProtocol(SerializeFactory.SerializeType.JBOSS);
        handlersInitializer.addLastHandler(new ServerHandler());
        server.applyprotocol(handlersInitializer);
        server.start(9999);
    }

    /**
     * protobuf服务器
     */
    private static void protobufServer() {
        TcpServer server = new TcpServer();
        HandlersInitializer handlersInitializer = SerializeFactory.applyProtocol(SerializeFactory.SerializeType.PROTOBUF);
        handlersInitializer.addLastHandler(new ProtobufServerHandler());
        server.applyprotocol(handlersInitializer);
        server.start(9999);
    }

    /**
     * serializable服务器
     */
    private static void serializableServer() {
        TcpServer server = new TcpServer();
        HandlersInitializer handlersInitializer = SerializeFactory.applyProtocol(SerializeFactory.SerializeType.SERIALIZABLE);
        handlersInitializer.addLastHandler(new ServerHandler());
        server.applyprotocol(handlersInitializer);
        server.start(9999);
    }
}
