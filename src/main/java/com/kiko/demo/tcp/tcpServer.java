package com.kiko.demo.tcp;

import com.kiko.demo.handler.ServerHandler;
import com.kiko.net.tcp.TcpServer;
import com.kiko.netty.impl.HandlersInitializer;
import com.kiko.protocol.SerializeFactory;

/**
 * @Author fengwei
 * Created on 2016/10/20/0020.
 */
public class tcpServer {

    public static void main(String[] args) {
        TcpServer server = new TcpServer();
        HandlersInitializer handlersInitializer = SerializeFactory.applyProtocol(SerializeFactory.SerializeType.SERIALIZABLE);
        handlersInitializer.addLastHandler(new ServerHandler());
        server.applyprotocol(handlersInitializer);
        server.start(6000);
    }
}
