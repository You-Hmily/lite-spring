package com.hmily.litespring.beans.factory.config;

/**
 * Created by zyzhmily on 2018/7/15.
 */
public interface SingletonBeanRegistry {

    public void regiterSingleton(String beanName,Object singletonObject);

    public Object getSingleton(String beanName);
}
