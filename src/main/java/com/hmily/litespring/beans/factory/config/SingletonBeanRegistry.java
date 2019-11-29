package com.hmily.litespring.beans.factory.config;

/**
 * Created by zyzhmily on 2018/7/15.
 */
public interface SingletonBeanRegistry {

    void registerSingleton(String beanName, Object singletonObject);

    Object getSingleton(String beanName);
}
