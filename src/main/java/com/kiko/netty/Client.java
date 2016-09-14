package com.kiko.netty;

import com.kiko.demo.CleintHandler;
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
public class Client {

    private HandlerInitializer handlerInitializer;

    private ClientInitializer clientInitializerl;

    private EventLoopGroup workerGroup;

    public Client(HandlerInitializer handlerInitializer) {
        this.handlerInitializer = handlerInitializer;
        this.workerGroup = new NioEventLoopGroup();
        this.clientInitializerl = new ClientInitializer(workerGroup, handlerInitializer);
    }

    public void connect(String host, Integer port) {
        LogUtils.log.info("client is connecting server with ip : " + host + " on port : " + port);
        try {
            clientInitializerl.init();
            clientInitializerl.setChannelOption(ChannelOption.TCP_NODELAY, true);
            Bootstrap b = clientInitializerl.getBootstrap();
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
        Client client = new Client(init);
        client.connect("127.0.0.1", 6006);
    }
}
