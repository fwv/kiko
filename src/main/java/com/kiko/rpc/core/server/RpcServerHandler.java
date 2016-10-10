package com.kiko.rpc.core.server;

import com.kiko.rpc.event.RpcRequest;
import com.kiko.rpc.event.RpcResponse;
import com.kiko.rpc.util.RpcNamedThreadFactory;
import com.kiko.tools.Concurrent.AsynFuture;
import com.kiko.tools.Concurrent.FutureListener;
import com.kiko.tools.LogUtils;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author fengwei
 * Created on 2016/9/28/0028.
 */
@ChannelHandler.Sharable
public class RpcServerHandler extends ChannelHandlerAdapter{

    // 自定义线程池处理rpc逻辑
    public ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 5, TimeUnit.MINUTES,
            new LinkedBlockingQueue<>(), new RpcNamedThreadFactory());

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        RpcRequest request  = (RpcRequest)msg;
        RpcServerExecutorTask task = new RpcServerExecutorTask(request);
        Future<RpcResponse> future = executor.submit(task);
        // 异步处理rpc请求，使io线程不阻塞，提高响应性与并发性能
        AsynFuture.create(future).addListener(new FutureListener<RpcResponse>() {
            @Override
            public void onSuccess(RpcResponse o) {
                ctx.writeAndFlush(o);
                LogUtils.log.info("kiko Rpc Success : send RpcResponse completely!");
            }

            @Override
            public void onFailed() {
                LogUtils.log.error("kiko Rpc Failed : AsynFuture error!");
            }
        });
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
