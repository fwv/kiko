package com.kiko.netty;

import io.netty.bootstrap.AbstractBootstrap;

/**
 * @Author fengwei
 * Created on 2016/9/18/0018.
 */
public abstract class NetUnitInitializer {

    public AbstractBootstrap bootstrap;

    public com.kiko.netty.impl.HandlerInitializer handlerInitializer;

    public abstract void init();

    public com.kiko.netty.impl.HandlerInitializer getHandlerInitializer() {
        return handlerInitializer;
    }

    public void setHandlerInitializer(com.kiko.netty.impl.HandlerInitializer handlerInitializer) {
        this.handlerInitializer = handlerInitializer;
    }
}
