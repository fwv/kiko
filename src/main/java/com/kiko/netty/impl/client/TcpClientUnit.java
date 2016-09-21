package com.kiko.netty.impl.client;

import com.kiko.demo.CleintHandler;
import com.kiko.netty.NetUnit;
import com.kiko.netty.impl.HandlersInitializer;
import com.kiko.netty.impl.NetUnitOption;
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
        workerGroup = new NioEventLoopGroup();
        tcpClientInitializerl = new TcpClientInitializer(workerGroup);
        handlersInitializer = new HandlersInitializer();
    }

    @Override
    public void init() {
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

    @Override
    protected void setOption(NetUnitOption option) {

    }

    public static void main(String[] args) {
        TcpClientUnit tcpClientUnit = new TcpClientUnit();
        CleintHandler handler = new CleintHandler();
        tcpClientUnit.handlersInitializer.addLastHandler(handler);
        tcpClientUnit.init();
        tcpClientUnit.boot("127.0.0.1", 6006);
    }

}
