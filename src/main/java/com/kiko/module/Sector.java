package com.kiko.module;

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

}
