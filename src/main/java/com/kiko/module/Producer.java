package com.kiko.module;

import com.kiko.netty.impl.NetUnitOption;

/**
 * @Author fengwei
 * Created on 2016/9/20/0020.
 */
public interface Producer<E> {

    public NetUnitOption produce(E e);

}
