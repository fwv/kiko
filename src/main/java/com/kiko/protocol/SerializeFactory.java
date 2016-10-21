package com.kiko.protocol;

import com.kiko.netty.impl.HandlersInitializer;
import com.kiko.protocol.jboss.MarshallingProtocol;
import com.kiko.protocol.protobuf.ProtobufProtocol;
import com.kiko.protocol.serializable.SerializableProtocol;

/**
 * @Author fengwei
 * Created on 2016/10/20/0020.
 * 编解码协议工厂
 */
public class SerializeFactory {

    public enum SerializeType {
        SERIALIZABLE,
        PROTOBUF,
        JBOSS;
    }

    public static HandlersInitializer applyProtocol(SerializeType type) {

        switch (type) {
            case SERIALIZABLE:
                return new SerializableProtocol();

            case PROTOBUF:
                return new ProtobufProtocol();

            case JBOSS:
                return new MarshallingProtocol();

            default:
                return null;
        }
    }
}
