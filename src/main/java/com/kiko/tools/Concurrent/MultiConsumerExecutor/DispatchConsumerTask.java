package com.kiko.tools.Concurrent.MultiConsumerExecutor;

/**
 * @Author fengwei
 * Created on 2016/10/11/0011.
 * 消息分发任务，负责将主队列中消息分发到子队列中
 */
public class DispatchConsumerTask implements Runnable{

    public AbstractMultiConsumerExecutor executor;

    public static DispatchConsumerTask create(AbstractMultiConsumerExecutor executor) {
        DispatchConsumerTask task = new DispatchConsumerTask();
        task.executor = executor;
        return task;
    }

    private DispatchConsumerTask(){}

    @Override
    public void run() {
        for(;;) {
            Runnable message = null;
            if (null != executor.messageQueue)
            try {
                message = (Runnable) executor.messageQueue.take();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (null != executor.subQueues && 0 != executor.subQueues.size()) {
                int index = (int) (System.nanoTime() % executor.subQueues.size());
                try {
                    // 目前使用简单哈希，日后或选择一致性hash
                    executor.subQueues.get(index).queue.put(message);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
