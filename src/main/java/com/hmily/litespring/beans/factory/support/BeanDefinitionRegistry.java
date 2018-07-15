package com.hmily.litespring.beans.factory.support;

import com.hmily.litespring.beans.BeanDefinition;

/**
 * Created by zyzhmily on 2018/7/14.
 */
public interface BeanDefinitionRegistry {

    BeanDefinition getBeanDefinition(String beanID);

    void registerBeanDefinition(String benaID,BeanDefinition bd);

}
