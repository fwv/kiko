package com.kiko.netty;

import com.kiko.netty.impl.HandlersInitializer;
import io.netty.bootstrap.AbstractBootstrap;

/**
 * @Author fengwei
 * Created on 2016/9/18/0018.
 */
public abstract class NetUnitInitializer {

    public AbstractBootstrap bootstrap;

    public abstract void init(HandlersInitializer handlersInitializer);

}
