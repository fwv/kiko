package com.kiko.demo.rpc;

import com.kiko.rpc.core.client.RpcClient;
import com.kiko.rpc.service.upperCaseShow;
import com.kiko.tools.LogUtils;

/**
 * @Author fengwei
 * Created on 2016/9/28/0028.
 */
public class rpcClient {
    public static RpcClient client;

    public static void main(String[] args) {
        RpcClient client = new RpcClient();
        client.init();

        Runnable task = () ->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            upperCaseShow us =  client.rpcClientExcutor.execute(upperCaseShow.class);
            String result = us.doUpperCase("kiko, you have rpc!");
            LogUtils.log.info(result);
        };
        for (int i = 0; i < 1000; i++) {
            new Thread(task).start();
        }

        client.start("www.94fw.cn", 8000);
    }
}
