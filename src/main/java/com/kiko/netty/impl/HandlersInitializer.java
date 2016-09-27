package com.kiko.netty.impl;

import com.kiko.demo.object.message;
import com.kiko.tools.ConditionUtils;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * @Author fengwei
 * Created on 2016/9/13/0013.
 */
public class HandlersInitializer extends ChannelInitializer<SocketChannel>{

    ArrayList<ChannelHandler> handlers = new ArrayList<ChannelHandler>();

    private Integer handlerCnt = 0;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
       // addLastHandler(new LengthFieldBasedFrameDecoder(65535, 0, 2));
        //addLastHandler(new LengthFieldPrepender(65535));
        ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(65535, 0, 2));
        ch.pipeline().addLast(new ObjectDecoder(1024, ClassResolvers.weakCachingConcurrentResolver(message.class.getClassLoader())));
        ch.pipeline().addLast(new ObjectEncoder());
        if (!ConditionUtils.isEmpty(handlers)) {
            for (Iterator<ChannelHandler>it = handlers.iterator();it.hasNext(); ) {
                ch.pipeline().addLast(it.next());
            }
        }
    }

    public void addLastHandler(ChannelHandler handler) {
        handlers.add(handler);
        handlerCnt++;
    }

    public boolean hasHandler() {
        return 0 == handlerCnt;
    }

}
