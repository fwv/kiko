package com.kiko.rpc.core.server;

import com.kiko.rpc.core.register.RegisterManager;
import com.kiko.rpc.event.RpcRequest;
import com.kiko.rpc.event.RpcResponse;
import com.kiko.tools.LogUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * @Author fengwei
 * Created on 2016/9/28/0028.
 */
public class RpcServerExecutorTask implements Callable<RpcResponse>{

    public RpcRequest request;

    public RpcResponse response;

    public RpcServerExecutorTask(RpcRequest req) {
        request = req;
        response = new RpcResponse();
        response.setId(req.getId());
    }

    @Override
    public RpcResponse call() {
        try {
            Object result = onProcess();
            response.setAttach(result);
            response.setResult("kiko Rpc Successful");

        } catch (NoSuchMethodException e) {

            LogUtils.log.error("kiko Rpc Failed : no such metho --> " + request.getMethodName());
            response.setResult("kiko Rpc Failed : no such metho --> " + request.getMethodName());
            return response;

        } catch (InvocationTargetException e) {

            LogUtils.log.error("kiko Rpc Failed : invoke method error --> " + request.getMethodName());
            response.setResult("kiko Rpc Failed : invoke method error --> " + request.getMethodName());
            return response;

        } catch (IllegalAccessException e) {
            LogUtils.log.error("kiko Rpc Failed : illegal access --> " + request.getMethodName());
            response.setResult("kiko Rpc Failed : illegal access --> " + request.getMethodName());
            return response;
        }

        return response;
    }

    public Object onProcess() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object service = RegisterManager.getRegisterObj();
        Method method = service.getClass().getMethod(request.getMethodName(), request.getParamTypes());
        Object result =  method.invoke(service, request.getParams());
        return result;
    }
}
