package com.self.cms.system.config.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * spring cache 整合redis
 * @author chengfengfeng
 * @date 2018/6/13
 */
@Configuration
public class RedisCacheConfig {
    @Autowired
    RedisConnectionFactory redisConnectionFactory;
    /**
     * 实例化 RedisTemplate 对象
     * 使用自定义序列化工具
     * @return RedisTemplate
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        initRedisTemplate(redisTemplate);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    /**
     * 设置数据存入 redis 的序列化方式
     * redisTemplate 序列化默认使用的jdkSerializeable, 存储二进制字节码, 导致key会出现乱码，所以自定义
     * 序列化类
     *
     * @param redisTemplate
     */
    private void initRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        // 使用Jackson2JsonRedisSerialize 替换默认序列化
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        //// string结构的数据，设置value的序列化规则和 key的序列化规则
        //StringRedisSerializer解决key中乱码问题。//Long类型不可以会出现异常信息;
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //value乱码问题：Jackson2JsonRedisSerializer
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);

        //设置Hash结构的key和value的序列化方式
        //redisTemplate.setHashKeySerializer(jackson2JsonRedisSerializer);
        //redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
    }
}
