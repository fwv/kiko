package com.kiko.rpc.serialize.serializable;

import com.kiko.netty.impl.HandlersInitializer;
import com.kiko.rpc.serialize.RpcEventProtocol;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * @Author fengwei
 * Created on 2016/9/27/0027.
 */
public class SerializableProtocol extends HandlersInitializer implements RpcEventProtocol{

    private SerializableProtocol() {
        addLastHandler(new LengthFieldBasedFrameDecoder(65535, 0, 2));
        addLastHandler(new LengthFieldPrepender(65535));
        addLastHandler(new ObjectDecoder(1024*1024, ClassResolvers.weakCachingConcurrentResolver(this.getClass().getClassLoader())));
        addLastHandler(new ObjectEncoder());
    }

    @Override
    public HandlersInitializer applyProtocol() {
        return this;
    }
}
