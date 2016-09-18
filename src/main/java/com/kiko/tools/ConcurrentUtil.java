package com.kiko.tools;

import jdk.nashorn.internal.codegen.CompilerConstants;

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
       future =  scheduledExecutorService.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //future.cancel(true);
    }

    public static void callableRun(Callable c) {
        FutureTask ft = new FutureTask(c);
        Future f =  scheduledExecutorService.scheduleAtFixedRate(ft, 0, 1, TimeUnit.SECONDS);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // f.cancel(true);
    }


    public static void main(String[] args) {

//        Callable c = new Callable() {
//            public Integer call() {
//                int i = 0;
//                    if (!Thread.currentThread().isInterrupted()) {
//                        LogUtils.log.info("running : i = " + ++i);
//                    }
//                return i;
//            }
//        };
        Runnable r = new Runnable() {
            volatile int i = 0;
            public void run() {
                LogUtils.log.info("running : i = " + ++i);
                if (i > 5) {
                    try {
                        throw new Exception("my exception");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        ConcurrentUtil.run(r);
        try {
            ConcurrentUtil.future.get();
        } catch (Exception e) {
            e.printStackTrace();
            ConcurrentUtil.future.cancel(true);
        }
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        ConcurrentUtil.future.cancel(true);

//        Runnable r1 = new Runnable() {
//            public void run() {
//                LogUtils.log.info("new task is running");
//            }
//        };
//        ConcurrentUtil.run(r1);

    }


}
