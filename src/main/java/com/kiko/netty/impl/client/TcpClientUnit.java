package com.kiko.netty.impl.client;

import com.kiko.demo.handler.ClientHandler;
import com.kiko.netty.NetUnit;
import com.kiko.netty.impl.HandlersInitializer;
import com.kiko.netty.impl.NetUnitOption;
import com.kiko.tools.LogUtils;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Author fengwei
 * Created on 2016/9/14/0014.
 */
public class TcpClientUnit extends NetUnit{

    private EventLoopGroup workerGroup;

    private TcpClientInitializer tcpClientInitializerl;

    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

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
    public void boot(String host, final Integer port) {
        LogUtils.log.info("client is connecting server with ip : " + host + " on port : " + port);
        try {
            ChannelFuture future = tcpClientInitializerl.getBootstrap().connect(host, port).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
             //workerGroup.shutdownGracefully();
            // 处理断线重连
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LogUtils.log.info("server disconnect, begin reconnect!");
            Runnable reChatTask = ()->{
                //init();
                boot(host, port);
            };
            executor.execute(reChatTask);
        }
    }

    @Override
    public void setOption(NetUnitOption option) {
    }

    public static void main(String[] args) {
        TcpClientUnit tcpClientUnit = new TcpClientUnit();
        ClientHandler handler = new ClientHandler();
        tcpClientUnit.handlersInitializer.addLastHandler(handler);
        tcpClientUnit.init();
        tcpClientUnit.boot("127.0.0.1", 6006);
    }

}
