package com.hmily.litespring.context.support;

import com.hmily.litespring.beans.factory.support.DefaultBeanFactory;
import com.hmily.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import com.hmily.litespring.context.ApplicationContext;
import com.hmily.litespring.core.io.Resource;
import com.hmily.litespring.util.ClassUtils;

/**
 * Created by zyzhmily on 2018/7/15.
 */
public abstract class AbstractApplicationContext implements ApplicationContext{

    private String path;

    private DefaultBeanFactory factory;

    private ClassLoader classLoader;

    public AbstractApplicationContext(String path) {
        factory=new DefaultBeanFactory();
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
        Resource resource=this.getResource(path);
        reader.loadBeanDefinitions(resource);
        factory.setBeanClassLoader(this.classLoader);
    }

    @Override
    public Object getBean(String beanID) {
        return factory.getBean(beanID);
    }

    protected abstract Resource getResource(String path);

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader=classLoader;
    }

    @Override
    public ClassLoader getBeanClassLoader() {
        return this.classLoader!=null?this.classLoader: ClassUtils.getDefaultClassLoader();
    }
}
