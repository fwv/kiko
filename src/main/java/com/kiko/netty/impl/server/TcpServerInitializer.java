package com.kiko.netty.impl.server;

import com.kiko.netty.NetUnitInitializer;
import com.kiko.netty.impl.HandlersInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author fengwei
 * Created on 2016/9/13/0013.
 */
public class TcpServerInitializer extends NetUnitInitializer {

    private ServerBootstrap bootstrap;

    private EventLoopGroup bossGroup;

    private EventLoopGroup wokerGroup;

    // getter and setter
    public ServerBootstrap getBootstrap() {
        return bootstrap;
    }

    public void setBootstrap(ServerBootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    /**
     * constructor
     * @param bossGroup
     * @param wokerGroup
     */
    public TcpServerInitializer(EventLoopGroup bossGroup, EventLoopGroup wokerGroup) {
        this.bossGroup = bossGroup;
        this.wokerGroup = wokerGroup;
    }

    @Override
    public void init(HandlersInitializer handlersInitializer) {
        bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, wokerGroup);
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.childHandler(null != handlersInitializer ? handlersInitializer : new HandlersInitializer());
    }

    public <T> void setChannelOption(ChannelOption<T> key, T val) {
        bootstrap.option(key, val);
    }

}
