package com.kiko.demo.client;
import com.kiko.core.client.impl.TcpClient;
import com.kiko.demo.handler.ClientHandler;

/**
 * @Author fengwei
 * Created on 2016/9/21/0021.
 */
public class tcpClient {

    public static void main(String[] args) {
        TcpClient client = new TcpClient("127.0.0.1", 6006);
//        ServiceModule module = new ServiceModule(client.moduleManager);
//        ClientHandler handler = new ClientHandler();
//        ServiceSector sector = new ServiceSector(module, handler);
//        module.loadSector(sector);
//        client.moduleManager.loadModule(module);
//        client.start();
    }
}
