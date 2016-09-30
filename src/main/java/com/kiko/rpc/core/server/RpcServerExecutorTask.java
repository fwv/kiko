package com.kiko.rpc.core.server;

import com.kiko.rpc.core.register.RegisterManager;
import com.kiko.rpc.event.RpcRequest;
import com.kiko.rpc.event.RpcResponse;
import com.kiko.rpc.util.RpcState;
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
            response.setResult(RpcState.create(true, null, null));

        } catch (NoSuchMethodException e) {
            String state = RpcState.create(false, "no such method", request.getSimpleClassName()+request.getMethodName());
            LogUtils.log.error(state);
            response.setResult(state);
            response.setException(e);
            return response;

        } catch (InvocationTargetException e) {
            String state = RpcState.create(false, "invoke method error", request.getSimpleClassName()+request.getMethodName());
            LogUtils.log.error(state);
            response.setResult(state);
            response.setException(e);
            return response;

        } catch (IllegalAccessException e) {
            String state = RpcState.create(false, "illegal access", request.getSimpleClassName()+request.getMethodName());
            LogUtils.log.error(state);
            response.setResult(state);
            response.setException(e);
            return response;
        }
        return response;
    }

    public Object onProcess() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object service = RegisterManager.getRegisterObj(request);
        Method method = service.getClass().getMethod(request.getMethodName(), request.getParamTypes());
        Object result =  method.invoke(service, request.getParams());
        return result;
    }
}
