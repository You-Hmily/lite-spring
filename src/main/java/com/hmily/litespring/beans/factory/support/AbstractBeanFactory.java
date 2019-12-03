package com.hmily.litespring.beans.factory.support;


import com.hmily.litespring.beans.BeanDefinition;
import com.hmily.litespring.beans.factory.BeanCreationException;
import com.hmily.litespring.beans.factory.config.ConfigurableBeanFactory;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {
	protected abstract Object createBean(BeanDefinition bd) throws BeanCreationException;
}
