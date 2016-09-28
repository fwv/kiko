package com.kiko.rpc.core.client;

import com.kiko.rpc.event.RpcRequest;
import com.kiko.rpc.event.RpcResponse;
import com.kiko.rpc.util.RpcCallback;
import com.kiko.tools.LogUtils;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import javax.security.auth.callback.Callback;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author fengwei
 * Created on 2016/9/27/0027.
 * Rpc客户端Handler，负责收发消息
 */
@ChannelHandler.Sharable
public class RpcClientHandler extends ChannelHandlerAdapter{

    public static ChannelHandlerContext ctx;

    public ConcurrentHashMap<String, RpcCallback> rpcCallbackCache = new ConcurrentHashMap<String, RpcCallback>();

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        LogUtils.log.info("connect completely");
        this.ctx = ctx;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        RpcResponse response = (RpcResponse)msg;
        RpcCallback callback = rpcCallbackCache.get(response.getId());
        callback.onWrite(response);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
    }

    public RpcCallback sendRpcRequest(RpcRequest request) {
        RpcCallback callback = new RpcCallback(request);
        rpcCallbackCache.put(request.getId(), callback);
        ctx.writeAndFlush(request);
        return callback;
    }

}
