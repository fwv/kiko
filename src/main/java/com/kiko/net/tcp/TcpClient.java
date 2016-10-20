package com.kiko.net.tcp;

import com.kiko.netty.impl.HandlersInitializer;
import com.kiko.netty.impl.client.TcpClientUnit;

/**
 * @Author fengwei
 * Created on 2016/10/20/0020.
 */
public class TcpClient {

    private TcpClientUnit clientUnit;

    public TcpClient() {
        clientUnit = new TcpClientUnit();
    }

    public void applyProtocol(HandlersInitializer handlersInitializer) {
        clientUnit.applyProtocol(handlersInitializer);
    }

    public void connect(String host, Integer port) {
        clientUnit.init();
        clientUnit.boot(host, port);
    }

    public static void main(String[] args) {
        TcpClient client = new TcpClient();
        client.connect("127.0.0.1", 5000);
    }
}
