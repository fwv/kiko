package com.kiko.tools;

import java.util.concurrent.*;

/**
 * @Author fengwei
 * Created on 2016/9/18/0018.
 */
public class ConcurrentUtil {

    public static ScheduledExecutorService scheduledExecutorService =
            Executors.newScheduledThreadPool(1);

    public static Future future;

    public static void cancelTask() {
        future.cancel(true);
    }

    public static void cancelTaskByCount(int count) {

    }

    public static void run(Runnable runnable) {
       Future f =  scheduledExecutorService.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        f.cancel(true);
    }

    public static void main(String[] args) {
        ScheduledExecutorService es = Executors.newScheduledThreadPool(1);
        Runnable runnable = new Runnable() {
            /**
             *
             */
            public void run() {
                int i = 0;
                while (true) {
                    if (!Thread.currentThread().isInterrupted()) {
                        LogUtils.log.info("running : i = " + ++i);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        //Thread.currentThread().interrupt();
                    }
                }
            }
        };
        ScheduledFuture f = es.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        f.cancel(true);
    }


}
