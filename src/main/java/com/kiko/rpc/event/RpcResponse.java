package com.kiko.rpc.event;

/**
 * @Author fengwei
 * Created on 2016/9/27/0027.
 * Rpc响应消息
 */
public class RpcResponse extends AbstractRpcEvent{

    private String result;

    private Object attach;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Object getAttach() {
        return attach;
    }

    public void setAttach(Object attach) {
        this.attach = attach;
    }
}
