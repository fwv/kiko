package com.kiko.netty.impl.client;

import com.kiko.demo.CleintHandler;
import com.kiko.netty.NetUnit;
import com.kiko.netty.impl.HandlersInitializer;
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
public class TcpClientUnit extends NetUnit{

    private EventLoopGroup workerGroup;

    private TcpClientInitializer tcpClientInitializerl;

    public TcpClientUnit() {
        this.workerGroup = new NioEventLoopGroup();
        this.tcpClientInitializerl = new TcpClientInitializer(workerGroup);
    }

    @Override
    public void init(HandlersInitializer handlersInitializer) {
        tcpClientInitializerl.init(handlersInitializer);
        tcpClientInitializerl.setChannelOption(ChannelOption.TCP_NODELAY, true);
    }

    @Override
    public void boot(Integer port) {}

    @Override
    public void boot(String host, Integer port) {
        LogUtils.log.info("client is connecting server with ip : " + host + " on port : " + port);
        try {
            ChannelFuture future = tcpClientInitializerl.getBootstrap().connect(host, port).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        HandlersInitializer init = new HandlersInitializer();
        CleintHandler handler = new CleintHandler();
        init.addLastHandler(handler);
        TcpClientUnit tcpClientUnit = new TcpClientUnit();
        tcpClientUnit.init(init);
        tcpClientUnit.boot("127.0.0.1", 6006);
    }

}
