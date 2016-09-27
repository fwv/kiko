package com.kiko.rpc.event;

import java.io.Serializable;

/**
 * @Author fengwei
 * Created on 2016/9/27/0027.
 * 抽象Rpc消息类
 */
public abstract class AbstractRpcEvent implements Serializable{

    protected String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
