package com.kiko.tools.Concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Author fengwei
 * Created on 2016/9/28/0028.
 * 异步Future，通过添加监听器实现
 */
public class AsynFuture {

    public ExecutorService executorService = Executors.newSingleThreadExecutor();

    public Future future;

    private AsynFuture(Future f) {
        future = f;
    }

    public static AsynFuture create(Future future) {
        return new AsynFuture(future);
    }

    // 添加监听器
    public void addListener(FutureListener listener) {
        Runnable task = ()->{
            try {
                Object result =  future.get();
                listener.onSuccess(result);
            } catch (Exception e) {
                listener.onFailed();
            }finally {
                shutdown();
            }
        };

        executorService.submit(task);
    }

    // 添加监听器（带有超时机制）
    public void addListener(FutureListener listener, long timeout, TimeUnit unit) {
        Runnable task = ()->{
            try {
                Object result =  future.get(timeout, unit);
                listener.onSuccess(result);
            } catch (Exception e) {
                listener.onFailed();
            }finally {
                shutdown();
            }
        };
        executorService.submit(task);
    }

    public void shutdown() {
        executorService.shutdown();
    }

}
