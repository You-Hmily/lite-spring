package com.hmily.litespring.beans.factory.support;

import com.hmily.litespring.beans.factory.config.SingletonBeanRegistry;
import com.hmily.litespring.util.Assert;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zyzhmily on 2018/7/15.
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry{

    private final Map<String,Object> singletonObjectMap=new ConcurrentHashMap<String,Object>(64);


    @Override
    public void regiterSingleton(String beanName, Object singletonObject) {
        Assert.notNull(beanName,"'beanName' must not be null");
        Object oldObject=this.singletonObjectMap.get(beanName);
        if (oldObject!=null){
            throw new IllegalStateException("Could not register object ["+singletonObject+"] under beanName '"+beanName+" ': there is already object [ "+oldObject+" ]");
        }
        this.singletonObjectMap.put(beanName,singletonObject);
    }

    @Override
    public Object getSingleton(String beanName) {
        return this.singletonObjectMap.get(beanName);
    }
}
