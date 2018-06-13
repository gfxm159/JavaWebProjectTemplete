package com.self.cms.system.environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Environment 是最早初始的类 包含了系统运行环境的配置 可以注入到任何地方使用
 * @author self
 * @date 2018/6/13
 */
@Configuration
public class EnvConfig {

    @Autowired
    private Environment env;

    public int getServerPort(){
        return env.getProperty("server.port", Integer.class);
    }


}
