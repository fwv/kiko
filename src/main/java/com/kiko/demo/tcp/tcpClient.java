package com.kiko.demo.tcp;

import com.kiko.demo.handler.ClientHandler;
import com.kiko.net.tcp.TcpClient;
import com.kiko.netty.impl.HandlersInitializer;
import com.kiko.protocol.SerializeFactory;

/**
 * @Author fengwei
 * Created on 2016/10/20/0020.
 */
public class tcpClient {
    public static void main(String[] args) {
        TcpClient client = new TcpClient();
        HandlersInitializer handlersInitializer = SerializeFactory.applyProtocol(SerializeFactory.SerializeType.SERIALIZABLE);
        handlersInitializer.addLastHandler(new ClientHandler());
        client.applyProtocol(handlersInitializer);
        client.connect("127.0.0.1", 6000);
    }
}
