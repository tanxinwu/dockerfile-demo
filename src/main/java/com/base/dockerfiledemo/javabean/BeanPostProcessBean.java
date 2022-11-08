package com.base.dockerfiledemo.javabean;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessBean implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //这里是处理所有的bean
        if (ObjectUtil.equal(beanName,"testBean")){
            System.out.println("postProcessBeforeInitialization");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (ObjectUtil.equal(beanName,"testBean")){
            System.out.println("postProcessAfterInitialization");
        }
        return bean;
    }
}
