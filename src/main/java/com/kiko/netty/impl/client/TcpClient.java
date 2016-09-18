package com.kiko.netty.impl.client;

import com.kiko.demo.CleintHandler;
import com.kiko.netty.NetUnit;
import com.kiko.netty.impl.HandlerInitializer;
import com.kiko.tools.LogUtils;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * @Author fengwei
 * Created on 2016/9/14/0014.
 */
public class TcpClient extends NetUnit{

    private EventLoopGroup workerGroup;

    private HandlerInitializer handlerInitializer;

    private TcpClientInitializer tcpClientInitializerl;

    public TcpClient(HandlerInitializer handlerInitializer) {
        this.handlerInitializer = handlerInitializer;
        this.workerGroup = new NioEventLoopGroup();
        this.tcpClientInitializerl = new TcpClientInitializer(workerGroup, handlerInitializer);
    }

    @Override
    public void boot(Integer port) {}

    @Override
    public void boot(String host, Integer port) {
        LogUtils.log.info("client is connecting server with ip : " + host + " on port : " + port);
        try {
            tcpClientInitializerl.init();
            tcpClientInitializerl.setChannelOption(ChannelOption.TCP_NODELAY, true);
            Bootstrap b = tcpClientInitializerl.getBootstrap();
            ChannelFuture future = b.connect(host, port).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        HandlerInitializer init = new HandlerInitializer();
        CleintHandler handler = new CleintHandler();
        init.addLastHandler(handler);
        TcpClient tcpClient = new TcpClient(init);
        tcpClient.boot("127.0.0.1", 6006);
    }

}
