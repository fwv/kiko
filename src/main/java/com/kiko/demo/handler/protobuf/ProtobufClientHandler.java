package com.kiko.demo.handler.protobuf;

import com.kiko.event.protobuf.MsgProtobuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @Author fengwei
 * Created on 2016/10/20/0020.
 */
public class ProtobufClientHandler extends ChannelHandlerAdapter{

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MsgProtobuf.KikoMsg.Builder msgbuilder = MsgProtobuf.KikoMsg.newBuilder();
        msgbuilder.setCode(1);
        msgbuilder.setDesc("protobuf");
        ctx.writeAndFlush(msgbuilder.build());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
    }

}
