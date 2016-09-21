package com.kiko.core.client.impl;

import com.kiko.core.client.AbstractClient;
import com.kiko.demo.handler.ClientHandler;
import com.kiko.module.manager.ModuleManager;
import com.kiko.module.service.ServiceModule;
import com.kiko.module.service.ServiceSector;
import com.kiko.netty.impl.client.TcpClientUnit;

/**
 * @Author fengwei
 * Created on 2016/9/19/0019.
 */
public class TcpClient extends AbstractClient{

    public TcpClient(String host, Integer port) {
        this.host = host;
        this.port = port;
        this.netUnit = new TcpClientUnit();
        this.moduleManager = new ModuleManager(this);
    }

    @Override
    public void start() {
        moduleManager.installAllModules();
        netUnit.init();
        netUnit.boot(host, port);
    }

}
