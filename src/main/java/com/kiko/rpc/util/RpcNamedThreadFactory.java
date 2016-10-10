package com.kiko.rpc.util;

import com.kiko.tools.LogUtils;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author fengwei
 * Created on 2016/10/10/0010.
 */
public class RpcNamedThreadFactory implements ThreadFactory {

    public AtomicInteger count = new AtomicInteger(1);

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, "rpc-server-handler-thread-no." + count.getAndIncrement());
        return thread;
    }

    //test
    public static void main(String[] args) {
        RpcNamedThreadFactory factory = new RpcNamedThreadFactory();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 30, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(), factory);
        for (int i = 0; i < 5; i++) {
            threadPool.submit(()->{
                LogUtils.log.info("i am running..");
            });
        }
    }

}
