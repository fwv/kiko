package com.kiko.tools.Concurrent.MultiConsumerExecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author fengwei
 * Created on 2016/10/11/0011.
 * ×ÓÖ´ÐÐÆ÷
 */
public class ConsumerExecutor {

    public AbstractMultiConsumerExecutor parentExecutor;

    public ThreadPoolExecutor executor;

    public BlockingQueue queue;

    public ConsumerExecutor(AbstractMultiConsumerExecutor parent) {

        parentExecutor = parent;

        queue = new LinkedBlockingQueue();

        executor = new ThreadPoolExecutor(5, 10, 3, TimeUnit.MINUTES,
                new LinkedBlockingQueue(), new ConsumerThreadFactory(),
                new ConsumerTaskRejectHandler(parentExecutor.messageQueue));
        onProcess();

    }

    public ConsumerExecutor(ThreadPoolExecutor executor) {
        this.executor = executor;
        queue = new LinkedBlockingQueue();
        onProcess();
    }

    public void onProcess() {
       new Thread(ConsumerTask.create(this), "consumer-dispatch-thread").start();
    }


}
