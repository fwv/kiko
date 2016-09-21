package com.kiko.module.service;

import com.kiko.netty.impl.NetUnitOption;
import io.netty.channel.ChannelHandlerAdapter;

/**
 * @Author fengwei
 * Created on 2016/9/21/0021.
 */
public class ServiceProduct extends NetUnitOption<ChannelHandlerAdapter>{

    protected ServiceProduct(ChannelHandlerAdapter handlerAdapter) {
        super(handlerAdapter);
    }

    @Override
    protected Object getOption() {
        return option;
    }

}
