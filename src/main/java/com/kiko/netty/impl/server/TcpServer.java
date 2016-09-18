package com.kiko.netty.impl.server;

import com.kiko.demo.ServerHandler;
import com.kiko.netty.NetUnit;
import com.kiko.netty.impl.HandlerInitializer;
import com.kiko.tools.LogUtils;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * @Author fengwei
 * Created on 2016/9/13/0013.
 */
public class TcpServer extends NetUnit{

    private Integer port;

    private EventLoopGroup bossGroup;

    private EventLoopGroup workerGroup;

    private HandlerInitializer handlerInitializer;

    private TcpServerInitializer tcpServerInitializer;

    public TcpServer(HandlerInitializer handlerInitializer) {
        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();
        this.handlerInitializer = handlerInitializer;
        this.tcpServerInitializer = new TcpServerInitializer(bossGroup, workerGroup, handlerInitializer);
    }

    @Override
    public void boot(Integer port) {
        try {
            LogUtils.log.info("server is bind on port : " + port);
            this.port = port;
            tcpServerInitializer.init();
            tcpServerInitializer.setChannelOption(ChannelOption.SO_BACKLOG, 1024);
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
        HandlerInitializer hi = new HandlerInitializer();
        ServerHandler handler = new ServerHandler();
        hi.addLastHandler(handler);
        TcpServer s = new TcpServer(hi);
        s.boot(6006);
    }
}
