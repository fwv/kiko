package com.kiko.protocol.jboss;

import com.kiko.netty.impl.HandlersInitializer;
import com.kiko.protocol.RpcEventProtocol;
import io.netty.channel.socket.SocketChannel;

/**
 * @Author fengwei
 * Created on 2016/10/21/0021.
 * Marshalling编解码协议（未通过测试）
 */
public class MarshallingProtocol extends HandlersInitializer implements RpcEventProtocol{

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
        ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingEncoder());
        super.initChannel(ch);
    }

    @Override
    public HandlersInitializer applyProtocol() {
        return new MarshallingProtocol();
    }
}
