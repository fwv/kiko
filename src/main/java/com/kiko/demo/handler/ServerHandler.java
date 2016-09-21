package com.kiko.demo.handler;

import com.kiko.tools.LogUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import sun.rmi.runtime.Log;

import java.net.SocketAddress;
import java.nio.ByteBuffer;

/**
 * @Author fengwei
 * Created on 2016/9/14/0014.
 */
public class ServerHandler extends ChannelHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (null != msg) {
            ByteBuf buff = (ByteBuf) msg;
            byte[] bytes = new byte[buff.readableBytes()];
            buff.readBytes(bytes);
            String str = new String(bytes);
            LogUtils.log.info("server received : {}", str);

            String resp = "echo : " + str;
            byte[] respBytes = resp.getBytes();
            ByteBuf respBuf = Unpooled.buffer(respBytes.length);
            respBuf.writeBytes(respBytes);
            ctx.writeAndFlush(respBuf);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        LogUtils.log.info("server handler is active!");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
    }
}
