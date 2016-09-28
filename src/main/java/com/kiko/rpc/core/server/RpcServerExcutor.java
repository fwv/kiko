package com.kiko.rpc.core.server;

import com.kiko.tools.Concurrent.NamedThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author fengwei
 * Created on 2016/9/28/0028.
 */
public class RpcServerExcutor {

    public static ExecutorService rpcExecutor = Executors.newFixedThreadPool(8, new NamedThreadFactory());

    public static Future submit(RpcServerExecutorTask task) {
        return rpcExecutor.submit(task);
    }

}
