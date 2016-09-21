package com.kiko.netty.impl;

/**
 * @Author fengwei
 * Created on 2016/9/20/0020.
 */
public abstract class NetUnitOption<E> {
    protected E option;

    protected NetUnitOption(E e){
        this.option = e;
    };

    protected abstract Object getOption();

}
