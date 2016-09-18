package com.kiko.netty.impl.client;

import com.kiko.netty.NetUnitInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Author fengwei
 * Created on 2016/9/14/0014.
 */
public class TcpClientInitializer extends NetUnitInitializer{

    private Bootstrap bootstrap;

    private EventLoopGroup workerGroup;

    // getter and setter
    public EventLoopGroup getWorkerGroup() {
        return workerGroup;
    }

    public void setWorkerGroup(EventLoopGroup workerGroup) {
        this.workerGroup = workerGroup;
    }

    public Bootstrap getBootstrap() {
        return bootstrap;
    }

    public void setBootstrap(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    /**
     * constructor
     * @param workerGroup
     * @param handlerInitializer
     */
    public TcpClientInitializer(EventLoopGroup workerGroup, com.kiko.netty.impl.HandlerInitializer handlerInitializer) {
        this.workerGroup = workerGroup;
        this.handlerInitializer = handlerInitializer;
    }

    @Override
    public void init() {
        this.bootstrap = new Bootstrap();
        bootstrap.group(workerGroup);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.handler(handlerInitializer);
    }

    public <T> void setChannelOption(ChannelOption<T> key, T val) {bootstrap.option(key, val);}

}
