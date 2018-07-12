package com.self.api.config.springsession;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * @author ShiXin
 * @date 2018/7/12 18:45
 */
public class Initializer  extends AbstractHttpSessionApplicationInitializer {
    public Initializer() {
        super(RedisConfig.class);
    }
}
