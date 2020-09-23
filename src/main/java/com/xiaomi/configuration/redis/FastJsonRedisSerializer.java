package com.xiaomi.configuration.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

/**
 * @author hekun
 */
public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {

    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private Class<T> clazz;

    static{
        ParserConfig.getGlobalInstance().addAccept("com.xiaomi.pojo.User");
        ParserConfig.getGlobalInstance().addAccept("com.xiaomi.pojo.Type");
        ParserConfig.getGlobalInstance().addAccept("com.xiaomi.pojo.Orders");
        ParserConfig.getGlobalInstance().addAccept("com.xiaomi.pojo.OrdersBody");
        ParserConfig.getGlobalInstance().addAccept("com.xiaomi.pojo.GoodsVersion");
        ParserConfig.getGlobalInstance().addAccept("com.xiaomi.pojo.GoodsImage");
        ParserConfig.getGlobalInstance().addAccept("com.xiaomi.pojo.Goods");
        ParserConfig.getGlobalInstance().addAccept("com.xiaomi.pojo.Evaluation");
        ParserConfig.getGlobalInstance().addAccept("com.xiaomi.pojo.Color");
        ParserConfig.getGlobalInstance().addAccept("com.xiaomi.pojo.shiro.Role");
        ParserConfig.getGlobalInstance().addAccept("com.xiaomi.pojo.shiro.Permission");
    }

    public FastJsonRedisSerializer(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (null == t)return new byte[0];
        return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (null == bytes || bytes.length <= 0) {
            return null;
        }
        String str = new String(bytes,DEFAULT_CHARSET);

        return JSON.parseObject(str,clazz);
    }
}
