package com.hmily.litespring.context.support;

import com.hmily.litespring.beans.NoSuchBeanDefinitionException;
import com.hmily.litespring.beans.factory.annotation.AutowiredAnnotationProcessor;
import com.hmily.litespring.beans.factory.config.ConfigurableBeanFactory;
import com.hmily.litespring.beans.factory.support.DefaultBeanFactory;
import com.hmily.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import com.hmily.litespring.context.ApplicationContext;
import com.hmily.litespring.core.io.Resource;
import com.hmily.litespring.util.ClassUtils;

import java.util.List;

/**
 * Created by zyzhmily on 2018/7/15.
 */
public abstract class AbstractApplicationContext implements ApplicationContext{

    private DefaultBeanFactory factory = null;
    private ClassLoader beanClassLoader;

    public AbstractApplicationContext(String configFile){
        factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        Resource resource = this.getResourceByPath(configFile);
        reader.loadBeanDefinitions(resource);
        factory.setBeanClassLoader(this.getBeanClassLoader());
        registerBeanPostProcessors(factory);
    }

    public Object getBean(String beanID) {

        return factory.getBean(beanID);
    }

    protected abstract Resource getResourceByPath(String path);

    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        this.beanClassLoader = beanClassLoader;
    }

    public ClassLoader getBeanClassLoader() {
        return (this.beanClassLoader != null ? this.beanClassLoader : ClassUtils.getDefaultClassLoader());
    }
    protected void registerBeanPostProcessors(ConfigurableBeanFactory beanFactory) {

        AutowiredAnnotationProcessor postProcessor = new AutowiredAnnotationProcessor();
        postProcessor.setBeanFactory(beanFactory);
        beanFactory.addBeanPostProcessor(postProcessor);

    }

    @Override
    public Class<?> getType(String name) throws NoSuchBeanDefinitionException {
        return this.factory.getType(name);
    }

    public List<Object> getBeansByType(Class<?> type){
        return this.factory.getBeansByType(type);
    }
}
