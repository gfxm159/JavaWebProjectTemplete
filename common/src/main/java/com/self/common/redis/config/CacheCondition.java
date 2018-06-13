package com.self.common.redis.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 匹配获取配置文件中${spring.cache.type} 是否配置
 * @author chengfengfeng
 * @date 2018/6/13
 */
public class CacheCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        return false;
    }
}
