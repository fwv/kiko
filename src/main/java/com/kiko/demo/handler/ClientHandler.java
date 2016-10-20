package com.kiko.demo.handler;

import com.kiko.demo.object.message;
import com.kiko.demo.object.person;
import com.kiko.tools.LogUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;


/**
 * @Author fengwei
 * Created on 2016/9/14/0014.
 */
@ChannelHandler.Sharable
public class ClientHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buff = (ByteBuf) msg;
        byte[] bytes = new byte[buff.readableBytes()];
        buff.readBytes(bytes);
        String str = new String (bytes);
        LogUtils.log.info(str);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        LogUtils.log.info("client handler is active !");
       /* String str = new String("Hello, kiko!");
        byte[] bytes = str.getBytes();
        ByteBuf buffer = Unpooled.buffer(bytes.length);
        buffer.writeBytes(bytes);
        ctx.writeAndFlush(buffer);*/
        message msg = new message();
        person p = new person();
        p.name = "fw";
        msg.p = p;
        ctx.writeAndFlush(msg);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
    }
}
