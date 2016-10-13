package com.kiko.tools.Concurrent.MultiConsumerExecutor.demo;


import com.kiko.tools.Concurrent.MultiConsumerExecutor.MultiConsumerExecutor;
import com.kiko.tools.LogUtils;

/**
 * @Author fengwei
 * Created on 2016/10/11/0011.
 */
public class ConsumerDemo {

    public static void main(String[] args) {
        MultiConsumerExecutor multiConsumerExecutor = new MultiConsumerExecutor();
        Runnable runnable = ()->{
            for (;;) {
            LogUtils.log.info("test MultiConsumerExecutor");
            }
        };
        for (int i = 1; i < 5; i++) {
            new Thread(()->{
                    multiConsumerExecutor.executor(runnable);
            }, "consumer-test-thread-"+i).start();
        }
    }

}
