package com.kiko.core.server;

import com.kiko.module.AbstractModuleManager;
import com.kiko.netty.NetUnit;

/**
 * @Author fengwei
 * Created on 2016/9/18/0018.
 */
public abstract class abstractServer {

    private int port;

    private long id;

    private String name;

    private long lastBootTime;

    private AbstractModuleManager moduleManager;

    private NetUnit netUnit;

    public abstract void start();

}