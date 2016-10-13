package com.kiko.tools.Concurrent.MultiConsumerExecutor;


import com.kiko.tools.LogUtils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author fengwei
 * Created on 2016/10/11/0011.
 * 子执行器任务失败策略：将失败任务丢弃到一级阻塞队列中缓存
 */
public class ConsumerTaskRejectHandler implements RejectedExecutionHandler{

    public BlockingQueue messageQueue;

    public ConsumerTaskRejectHandler(BlockingQueue queue) {
        messageQueue = queue;
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        if (null != messageQueue)
        try {
            messageQueue.put(r);
            LogUtils.log.info("Consumer rejected! put message into messageQueue");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
