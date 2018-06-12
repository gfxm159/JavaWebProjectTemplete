package com.self.cms.system.config.mybatis;



import com.self.cms.system.config.datasource.MyDataSourceConfigure;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author chengfengfeng
 *  * @date 2018/6/9
 */
@Configuration
@AutoConfigureAfter(MyDataSourceConfigure.class)
public class MyBatisScannerConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.chengfengfeng.bussiness.dao.mapper");
        return mapperScannerConfigurer;
    }
}
