package com.kiko.netty;

/**
 * @Author fengwei
 * Created on 2016/9/18/0018.
 * network core unit(based on netty)
 */
public abstract class NetUnit {

    public abstract void boot(Integer port);

    public abstract void boot(String host, Integer port);
}
