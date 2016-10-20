package com.kiko.netty;

import com.kiko.netty.impl.HandlersInitializer;

/**
 * @Author fengwei
 * Created on 2016/9/18/0018.
 * network core unit(based on netty)
 */
public abstract class NetUnit {

    protected HandlersInitializer handlersInitializer;

    public abstract void init();

    public abstract void boot(Integer port);

    public abstract void boot(String host, Integer port);

    public void applyProtocol(HandlersInitializer protocol) {
        handlersInitializer = protocol;
    }
}
