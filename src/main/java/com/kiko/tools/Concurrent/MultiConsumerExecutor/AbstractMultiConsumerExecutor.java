package com.kiko.tools.Concurrent.MultiConsumerExecutor;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;

/**
 * @Author fengwei
 * Created on 2016/10/11/0011.
 */
public abstract class AbstractMultiConsumerExecutor {

    protected BlockingQueue messageQueue;

    protected ArrayList<ConsumerExecutor> subQueues;

    protected Integer SUB_QUEUE_COUNT;

    public abstract Future executor(Runnable message);

    public abstract void registerConsumer();

    public abstract void registerConsumer(ConsumerExecutor subExecutor);

    public abstract void unstallConsumer(int index);

}
