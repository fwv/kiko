package com.kiko.netty.impl.server;

import com.kiko.demo.ServerHandler;
import com.kiko.netty.NetUnit;
import com.kiko.netty.impl.HandlersInitializer;
import com.kiko.tools.LogUtils;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * @Author fengwei
 * Created on 2016/9/13/0013.
 */
public class TcpServerUnit extends NetUnit{

    private EventLoopGroup bossGroup;

    private EventLoopGroup workerGroup;

    private TcpServerInitializer tcpServerInitializer;

    public TcpServerUnit() {
        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();
        this.tcpServerInitializer = new TcpServerInitializer(bossGroup, workerGroup);
    }

    @Override
    public void init(HandlersInitializer handlersInitializer) {
        tcpServerInitializer.init(handlersInitializer);
        tcpServerInitializer.setChannelOption(ChannelOption.SO_BACKLOG, 1024);
    }

    @Override
    public void boot(Integer port) {
        try {
            LogUtils.log.info("server is bind on port : " + port);
            ChannelFuture future = tcpServerInitializer.getBootstrap().bind(port).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    @Override
    public void boot(String host, Integer port) {
        boot(port);
    }

    public static void main(String[] args) {
        HandlersInitializer hi = new HandlersInitializer();
        ServerHandler handler = new ServerHandler();
        hi.addLastHandler(handler);
        TcpServerUnit s = new TcpServerUnit();
        s.init(hi);
        s.boot(6006);
    }
}
