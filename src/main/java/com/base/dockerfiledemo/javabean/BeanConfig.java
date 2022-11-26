package com.base.dockerfiledemo.javabean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@Slf4j
public class BeanConfig  {

    @Bean(value = "testBean",name = "testBean",initMethod = "doInitMethod")
    public TestBean getBean(){
        return new TestBean();
    }
    @Bean
    public BeanPostProcessBean BeanPost(){
        return new BeanPostProcessBean();
    }
    @Bean
    public PlatformTransactionManager txManager(final DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
