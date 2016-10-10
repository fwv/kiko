package com.kiko.rpc.serialize.serializable;

import com.kiko.netty.impl.HandlersInitializer;
import com.kiko.rpc.core.client.RpcClientHandler;
import com.kiko.rpc.serialize.RpcEventProtocol;
import com.kiko.tools.LogUtils;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * @Author fengwei
 * Created on 2016/9/27/0027.
 */
public class SerializableProtocol extends HandlersInitializer implements RpcEventProtocol{

    public SerializableProtocol() {

    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(65535, 0, 2));
        ch.pipeline().addLast(new ObjectDecoder(1024, ClassResolvers.weakCachingConcurrentResolver(this.getClass().getClassLoader())));
        ch.pipeline().addLast(new ObjectEncoder());
        super.initChannel(ch);
    }

    @Override
    public  HandlersInitializer applyProtocol() {
        return new SerializableProtocol();
    }

}
