package com.hmily.litespring.beans.factory.config;


import com.hmily.litespring.beans.BeansException;

public interface BeanPostProcessor {

	Object beforeInitialization(Object bean, String beanName) throws BeansException;

	
	Object afterInitialization(Object bean, String beanName) throws BeansException;

}
