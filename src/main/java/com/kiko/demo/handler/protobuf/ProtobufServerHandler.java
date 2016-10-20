package com.kiko.demo.handler.protobuf;

import com.kiko.event.protobuf.MsgProtobuf;
import com.kiko.tools.LogUtils;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @Author fengwei
 * Created on 2016/10/20/0020.
 */
public class ProtobufServerHandler extends ChannelHandlerAdapter{
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        LogUtils.log.info("active");
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        MsgProtobuf.KikoMsg kikoMsg = (MsgProtobuf.KikoMsg) msg;
        LogUtils.log.info(kikoMsg.getDesc());
    }
}
