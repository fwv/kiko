package com.kiko.protocol.protobuf;

import com.kiko.event.protobuf.MsgProtobuf;
import com.kiko.netty.impl.HandlersInitializer;
import com.kiko.protocol.RpcEventProtocol;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 * @Author fengwei
 * Created on 2016/10/20/0020.
 * Google Protobuf编解码器
 */
public class ProtobufProtocol extends HandlersInitializer implements RpcEventProtocol{

    private ProtobufProtocol() {}

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(65535, 0, 2));
        ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
        ch.pipeline().addLast(new ProtobufDecoder(MsgProtobuf.KikoMsg.getDefaultInstance()));
        ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
        ch.pipeline().addLast(new ProtobufEncoder());
        super.initChannel(ch);
    }

    @Override
    public HandlersInitializer applyProtocol() {
        return new ProtobufProtocol();
    }
}
