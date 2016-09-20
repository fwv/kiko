package com.kiko.core.server.impl;

import com.kiko.core.server.AbstractServer;
import com.kiko.netty.impl.server.TcpServerUnit;

/**
 * @Author fengwei
 * Created on 2016/9/19/0019.
 */
public class TcpServer extends AbstractServer{

    public TcpServer(int port) {
        this.port = port;
        this.netUnit = new TcpServerUnit();
    }

    @Override
    public void start() {
        netUnit.boot(port);
    }

}