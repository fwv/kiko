package com.kiko.module;

import com.kiko.netty.impl.NetUnitOption;

/**
 * @Author fengwei
 * Created on 2016/9/19/0019.
 */
public abstract class Sector<T> {

    public Module leaderModule;

    public T output;

    public Sector(Module owner, T out) {
        leaderModule = owner;
        output = out;
    }

    public abstract void init();

    public abstract NetUnitOption produce();

}
