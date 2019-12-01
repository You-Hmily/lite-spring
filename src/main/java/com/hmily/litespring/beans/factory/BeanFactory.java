package com.hmily.litespring.beans.factory;


import com.hmily.litespring.beans.NoSuchBeanDefinitionException;

/**
 * Created by zyzhmily on 2018/7/14.
 */
public interface BeanFactory {

    Object getBean(String beanID);

    Class<?> getType(String name) throws NoSuchBeanDefinitionException;
}
