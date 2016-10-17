package com.kiko.tools.Concurrent;

import com.kiko.tools.ConditionUtils;

import java.util.Stack;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author fengwei
 * Created on 2016/10/17/0017.
 * 格式化线程工厂构造类
 */
public class NamedThreadFactoryBuilder {

    private volatile NamedThreadFactory threadFactory;

    public AtomicInteger count= new AtomicInteger(1);

    public static NamedThreadFactoryBuilder create() {
        return new NamedThreadFactoryBuilder();
    }

    public static NamedThreadFactoryBuilder create(String ThreadGroupName) {
        return new NamedThreadFactoryBuilder(ThreadGroupName);
    }


    private NamedThreadFactoryBuilder() {
        threadFactory = new NamedThreadFactory();
    }

    private NamedThreadFactoryBuilder(String ThreadGroupName) {
        threadFactory = new NamedThreadFactory(ThreadGroupName);
    }

    public NamedThreadFactory getThreadFactory() {
        return threadFactory;
    }

    public void setThreadFactory(NamedThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
    }

    public ThreadFactory build() {
        return threadFactory;
    }

}
