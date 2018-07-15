package com.hmily.litespring.beans.factory.support;

import com.hmily.litespring.beans.BeanDefinition;
import com.hmily.litespring.beans.factory.BeanCreationException;
import com.hmily.litespring.beans.factory.BeanDefinitionStoreException;
import com.hmily.litespring.beans.factory.BeanFactory;
import com.hmily.litespring.beans.factory.config.ConfigurableBeanFactory;
import com.hmily.litespring.util.ClassUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zyzhmily on 2018/7/14.
 */
public class DefaultBeanFactory extends DefaultSingletonBeanRegistry implements BeanDefinitionRegistry,ConfigurableBeanFactory{

    private Map<String,BeanDefinition> beanDefinitionMap=new ConcurrentHashMap<>();

    private ClassLoader classLoader;

    public DefaultBeanFactory() {
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanID) {
        return this.beanDefinitionMap.get(beanID);
    }

    @Override
    public void registerBeanDefinition(String benaID, BeanDefinition bd) {
        this.beanDefinitionMap.put(benaID,bd);
    }

    @Override
    public Object getBean(String beanID) {
        BeanDefinition bd=this.getBeanDefinition(beanID);
        if (bd==null){
            throw new BeanCreationException("Bean Definition does not exist");
        }
        if (bd.isSingleton()){
            Object bean=this.getSingleton(beanID);
            if (bean==null){
                 bean=createBean(bd);
                this.regiterSingleton(beanID,bean);
            }
            return bean;
        }
        return createBean(bd);
    }

    private Object createBean(BeanDefinition bd){
        String beanClassName=bd.getBeanClassName();
        try {
            ClassLoader cl= this.getBeanClassLoader();
            Class<?> clz=cl.loadClass(beanClassName);
            return clz.newInstance();
        } catch (Exception e) {
            throw  new BeanCreationException("create bean for "+beanClassName+" fail");
        }
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
          this.classLoader=classLoader;
    }

    @Override
    public ClassLoader getBeanClassLoader() {
        return this.classLoader!=null?this.classLoader:ClassUtils.getDefaultClassLoader();
    }
}
