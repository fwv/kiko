package com.kiko.tools.Concurrent.MultiConsumerExecutor;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author fengwei
 * Created on 2016/10/11/0011.
 */
public class ConsumerThreadFactory implements ThreadFactory{

    public AtomicInteger threadCnt = new AtomicInteger(1);

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "consumer-thread-" + threadCnt.getAndIncrement());
    }
}
