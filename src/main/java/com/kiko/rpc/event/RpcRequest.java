package com.kiko.rpc.event;

/**
 * @Author fengwei
 * Created on 2016/9/27/0027.
 * Rpc请求消息
 */
public class RpcRequest extends AbstractRpcEvent{

    private String className;

    private String methodName;

    private Class[] paramTypes;

    private Object[] params;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
