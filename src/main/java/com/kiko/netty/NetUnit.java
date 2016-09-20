package com.kiko.netty;

import com.kiko.netty.impl.HandlersInitializer;
import com.kiko.netty.impl.NetUnitOption;

/**
 * @Author fengwei
 * Created on 2016/9/18/0018.
 * network core unit(based on netty)
 */
public abstract class NetUnit {

    public abstract void init(HandlersInitializer handlersInitializer);

    public abstract void boot(Integer port);

    public abstract void boot(String host, Integer port);

    public abstract void setOption(NetUnitOption option);
}
