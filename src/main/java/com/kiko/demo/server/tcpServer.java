package com.kiko.demo.server;

import com.kiko.core.server.impl.TcpServer;
import com.kiko.demo.handler.ServerHandler;

/**
 * @Author fengwei
 * Created on 2016/9/21/0021.
 */
public class tcpServer {

    public static void main(String[] args) {
        TcpServer server = new TcpServer(6006);
//        ServiceModule module = new ServiceModule(server.moduleManager);
//        ServerHandler handler = new ServerHandler();
//        ServiceSector sector = new ServiceSector(module, handler);
//        module.loadSector(sector);
//        server.moduleManager.loadModule(module);
//        server.start();
    }

}
