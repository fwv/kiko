package com.kiko.netty.impl;

import com.kiko.tools.ConditionUtils;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * @Author fengwei
 * Created on 2016/9/13/0013.
 */
public class HandlerInitializer extends ChannelInitializer<SocketChannel>{

    ArrayList<ChannelHandler> handlers = new ArrayList<ChannelHandler>();

    private Integer handlerCnt = 0;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
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
