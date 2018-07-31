package com.hmily.litespring.beans;

/**
 * Created by zyzhmily on 2018/7/28.
 */
public class RuntimeBeanReference {

    private final String beanName;

    public RuntimeBeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
