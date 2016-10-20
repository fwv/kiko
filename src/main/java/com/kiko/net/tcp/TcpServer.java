package com.kiko.net.tcp;

import com.kiko.netty.impl.HandlersInitializer;
import com.kiko.netty.impl.server.TcpServerUnit;
import com.kiko.protocol.SerializeFactory;

/**
 * @Author fengwei
 * Created on 2016/10/20/0020.
 */
public class TcpServer {

    private TcpServerUnit serverUnit;

    public TcpServer() {
        serverUnit = new TcpServerUnit();
    }

    public void applyprotocol(HandlersInitializer handlersInitializer) {
        serverUnit.applyProtocol(handlersInitializer);
    }

    public void start(int port) {
        serverUnit.init();
        serverUnit.boot(port);
    }

    public static void main(String[] args) {
        TcpServer s = new TcpServer();
        s.applyprotocol(SerializeFactory.applyProtocol(SerializeFactory.SerializeType.SERIALIZABLE));
        s.start(5000);
    }

}
