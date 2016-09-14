package com.kiko.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author fengwei
 * Created on 2016/9/13/0013.
 */
public class ServerInitializer {

    private ServerBootstrap bootstrap;

    private EventLoopGroup bossGroup;

    private EventLoopGroup wokerGroup;

    private HandlerInitializer handlerInitializer;

    public ServerInitializer(EventLoopGroup bossGroup, EventLoopGroup wokerGroup,
                             HandlerInitializer initializer) {
        this.bossGroup = bossGroup;
        this.wokerGroup = wokerGroup;
        this.handlerInitializer = initializer;
    }

    public void init() {
        bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, wokerGroup);
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.childHandler(handlerInitializer);
    }

    public <T> void setChannelOption(ChannelOption<T> key, T val) {
        bootstrap.option(key, val);
    }

    public HandlerInitializer getHandlerInitializer() {
        return handlerInitializer;
    }

    public void setHandlerInitializer(HandlerInitializer handlerInitializer) {
        this.handlerInitializer = handlerInitializer;
    }

    public ServerBootstrap getBootstrap() {
        return bootstrap;
    }

    public void setBootstrap(ServerBootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

}
