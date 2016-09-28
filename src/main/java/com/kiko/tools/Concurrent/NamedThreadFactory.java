package com.kiko.tools.Concurrent;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author fengwei
 * Created on 2016/9/28/0028.
 */
public class NamedThreadFactory implements ThreadFactory{

    public AtomicInteger count = new AtomicInteger(1);

    public String threadDesc;

    public NamedThreadFactory(String desc) {
        threadDesc = desc;
    }

    public NamedThreadFactory() {
    }

    @Override
    public Thread newThread(Runnable r) {
        return (null == threadDesc) ? new Thread() : new Thread(threadDesc + count.getAndIncrement());
    }
}
