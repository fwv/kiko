package com.kiko.protocol.handler;

import com.kiko.tools.LogUtils;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @Author fengwei
 * Created on 2016/10/20/0020.
 * 心跳连接处理器
 * 暂时弃用，尽量将心跳下移到逻辑handler层面处理，提高并发性能
 */
public class HeartableHandler extends ChannelHandlerAdapter{
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        LogUtils.log.info("channel is active! {}(remote) to-> {}(local)"
                ,String.valueOf(ctx.channel().remoteAddress())
                ,String.valueOf(ctx.channel().localAddress()));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
    }
}
