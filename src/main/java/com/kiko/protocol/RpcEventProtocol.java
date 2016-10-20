package com.kiko.protocol;

import com.kiko.netty.impl.HandlersInitializer;

/**
 * @Author fengwei
 * Created on 2016/9/27/0027.
 */
public interface RpcEventProtocol {
    public HandlersInitializer applyProtocol();
}
