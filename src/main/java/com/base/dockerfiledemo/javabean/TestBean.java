package com.base.dockerfiledemo.javabean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class TestBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    private String name;
    public String getName(){
        return name;
    }
    public void doInitMethod(){
        System.out.println("执行initMethod");
    }
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

        System.out.println("执行setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {

        System.out.println("执行setBeanName");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("执行setApplicationContext");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("执行destroy");
    }
}