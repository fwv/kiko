package com.kiko.core;

import com.kiko.module.AbstractModuleManager;
import com.kiko.netty.NetUnit;

/**
 * @Author fengwei
 * Created on 2016/9/19/0019.
 */
public abstract class NetObject {

    public long id;

    public String name;

    public long lastBootTime;
    // module part
    public AbstractModuleManager moduleManager;
    // netty part
    public NetUnit netUnit;
    // boot method
    public abstract void start();

}
