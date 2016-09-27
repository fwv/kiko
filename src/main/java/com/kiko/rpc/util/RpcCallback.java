package com.kiko.rpc.util;

import com.kiko.rpc.event.RpcRequest;
import com.kiko.rpc.event.RpcResponse;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author fengwei
 * Created on 2016/9/27/0027.
 * Rpc回调
 */
public class RpcCallback {

    private RpcRequest request;

    private RpcResponse response;

    private ReentrantLock lock;

    public CountDownLatch latch = new CountDownLatch(1);

    public int TIME_OUT_SECOND = 5;

    public RpcCallback(RpcRequest request, int timeout) {
        this.request = request;
        this.TIME_OUT_SECOND = timeout;
    }

    public RpcCallback(RpcRequest request) {
        this.request = request;
    }

    public RpcResponse onProcess() throws InterruptedException {
        lock.lock();
        if (null == response) {
            new Thread(()->{
                try {
                    Thread.sleep(1000 * TIME_OUT_SECOND);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            }).start();
            latch.await();
        }
        lock.unlock();
        return response;
    }

    public void onWrite(RpcResponse response) {
        this.response = response;
        latch.countDown();
    }

}
