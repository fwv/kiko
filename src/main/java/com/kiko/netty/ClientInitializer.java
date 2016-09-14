package com.kiko.netty;

import com.kiko.demo.CleintHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.nio.channels.SocketChannel;

/**
 * @Author fengwei
 * Created on 2016/9/14/0014.
 */
public class ClientInitializer {

    private Bootstrap bootstrap;

    private EventLoopGroup workerGroup;

    private HandlerInitializer handlerInitializer;

    public ClientInitializer(EventLoopGroup workerGroup, HandlerInitializer handlerInitializer) {
        this.workerGroup = workerGroup;
        this.handlerInitializer = handlerInitializer;
    }

    public void init() {
        this.bootstrap = new Bootstrap();
        bootstrap.group(workerGroup);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.handler(handlerInitializer);
    }

    public <T> void setChannelOption(ChannelOption<T> key, T val) {bootstrap.option(key, val);}

    public EventLoopGroup getWorkerGroup() {
        return workerGroup;
    }

    public void setWorkerGroup(EventLoopGroup workerGroup) {
        this.workerGroup = workerGroup;
    }

    public HandlerInitializer getHandlerInitializer() {
        return handlerInitializer;
    }

    public void setHandlerInitializer(HandlerInitializer handlerInitializer) {
        this.handlerInitializer = handlerInitializer;
    }

    public Bootstrap getBootstrap() {
        return bootstrap;
    }

    public void setBootstrap(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }
}
