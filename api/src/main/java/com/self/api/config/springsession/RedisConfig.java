package com.self.api.config.springsession;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author ShiXin
 * @date 2018/7/12 18:37
 */
@EnableRedisHttpSession
public class RedisConfig {
    @Bean
    public LettuceConnectionFactory connectionFactory() {
        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory();
        lettuceConnectionFactory.setDatabase(0);
        lettuceConnectionFactory.setPassword("123456");
        lettuceConnectionFactory.setHostName("47.98.160.143");
        lettuceConnectionFactory.setPort(6379);
        return new LettuceConnectionFactory();
    }

}
