package com.hmily.litespring.test.v5;



import com.hmily.litespring.aop.config.AspectInstanceFactory;
import com.hmily.litespring.beans.factory.BeanFactory;
import com.hmily.litespring.beans.factory.support.DefaultBeanFactory;
import com.hmily.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import com.hmily.litespring.core.io.ClassPathResource;
import com.hmily.litespring.core.io.Resource;
import com.hmily.litespring.tx.TransactionManager;

import java.lang.reflect.Method;

public class AbstractV5Test {
		
	protected BeanFactory getBeanFactory(String configFile){
		DefaultBeanFactory defaultBeanFactory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(defaultBeanFactory);
		Resource resource = new ClassPathResource(configFile);
		reader.loadBeanDefinitions(resource);	
		return  defaultBeanFactory;		
	}
	
	protected  Method getAdviceMethod(String methodName) throws Exception{
		return TransactionManager.class.getMethod(methodName);
	}
	
	protected AspectInstanceFactory getAspectInstanceFactory(String targetBeanName){
		AspectInstanceFactory factory = new AspectInstanceFactory();
		factory.setAspectBeanName(targetBeanName);		
		return factory;
	}
	
	
}
