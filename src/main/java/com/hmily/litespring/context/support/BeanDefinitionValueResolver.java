package com.hmily.litespring.context.support;

import com.hmily.litespring.beans.RuntimeBeanReference;
import com.hmily.litespring.beans.TypeStringValue;
import com.hmily.litespring.beans.factory.support.DefaultBeanFactory;

/**
 * Created by zyzhmily on 2018/7/30.
 */
public class BeanDefinitionValueResolver {

    private final DefaultBeanFactory beanFactory;

    public BeanDefinitionValueResolver(DefaultBeanFactory beanFactory) {
           this.beanFactory=beanFactory;
    }

    public Object resolveValueIfNecessary(Object value) {
        if (value instanceof RuntimeBeanReference){
            RuntimeBeanReference ref= (RuntimeBeanReference) value;
            String refName=ref.getBeanName();
            Object bean=this.beanFactory.getBean(refName);
            return bean;
        }else if (value instanceof TypeStringValue){
            return ((TypeStringValue) value).getValue();
        }else {
            //// TODO: 2018/7/30
            throw new RuntimeException("the Value "+value+"has not implemented");
        }
    }
}
