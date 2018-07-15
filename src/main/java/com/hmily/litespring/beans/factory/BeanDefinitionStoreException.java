package com.hmily.litespring.beans.factory;

import com.hmily.litespring.beans.BeansException;

/**
 * Created by zyzhmily on 2018/7/14.
 */
public class BeanDefinitionStoreException extends BeansException {

    public BeanDefinitionStoreException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
