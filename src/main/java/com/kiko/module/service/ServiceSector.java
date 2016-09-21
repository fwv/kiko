package com.kiko.module.service;

import com.kiko.module.Module;
import com.kiko.module.Producer;
import com.kiko.module.Sector;
import com.kiko.netty.impl.NetUnitOption;
import io.netty.channel.ChannelHandlerAdapter;

/**
 * @Author fengwei
 * Created on 2016/9/19/0019.
 */
public class ServiceSector extends Sector<ChannelHandlerAdapter>{

    private ChannelHandlerAdapter handlerAdapter;

    public ServiceSector(Module owner, ChannelHandlerAdapter handlerAdapter) {
        super(owner, handlerAdapter);
        this.handlerAdapter = handlerAdapter;
    }

    @Override
    public void init() {
    }

    @Override
    public ServiceProduct produce() {
        return new ServiceProduct(handlerAdapter);
    }

}
