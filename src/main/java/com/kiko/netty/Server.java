package com.kiko.netty;

import com.kiko.demo.ServerHandler;
import com.kiko.tools.LogUtils;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * @Author fengwei
 * Created on 2016/9/13/0013.
 */
public class Server {

    private ServerInitializer serverInitializer;

    private HandlerInitializer handlerInitializer;

    private EventLoopGroup bossGroup;

    private EventLoopGroup workerGroup;

    private Integer port;

    public Server(HandlerInitializer handlerInitializer) {
        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();
        this.handlerInitializer = handlerInitializer;
        this.serverInitializer = new ServerInitializer(bossGroup, workerGroup, handlerInitializer);
    }

    public void bind(Integer port) {
        try {
            LogUtils.log.info("server is bind on port : " + port);
            this.port = port;
            serverInitializer.init();
            serverInitializer.setChannelOption(ChannelOption.SO_BACKLOG, 1024);
            ChannelFuture future = serverInitializer.getBootstrap().bind(port).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        HandlerInitializer hi = new HandlerInitializer();
        ServerHandler handler = new ServerHandler();
        hi.addLastHandler(handler);
        Server s = new Server(hi);
        s.bind(6006);
    }

}
