package com.hmily.litespring.beans.factory.support;

import com.hmily.litespring.beans.BeanDefinition;
import com.hmily.litespring.beans.PropertyValue;
import com.hmily.litespring.beans.SimpleTypeConverter;
import com.hmily.litespring.beans.factory.BeanCreationException;
import com.hmily.litespring.beans.factory.BeanDefinitionStoreException;
import com.hmily.litespring.beans.factory.BeanFactory;
import com.hmily.litespring.beans.factory.config.ConfigurableBeanFactory;
import com.hmily.litespring.context.support.BeanDefinitionValueResolver;
import com.hmily.litespring.util.ClassUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
        //创建实例
        Object value=instantiateBean(bd);
        //设置属性
        populateBean(bd,value);
        return value;
    }

    private Object instantiateBean(BeanDefinition bd) {
        ClassLoader cl= this.getBeanClassLoader();
        String beanClassName=bd.getBeanClassName();
        try {
            Class<?> clz=cl.loadClass(beanClassName);
            return clz.newInstance();
        } catch (Exception e) {
            throw  new BeanCreationException("create bean for "+beanClassName+" fail");
        }
    }

    private void populateBean(BeanDefinition bd, Object value) {
        List<PropertyValue> pvs=bd.getPropertyValues();

        if (pvs==null||pvs.isEmpty()){
            return;
        }
        BeanDefinitionValueResolver valueResolver=new BeanDefinitionValueResolver(this);

        try{
            for (PropertyValue pv:pvs){
                String propertyName=pv.getName();
                Object originalValue=pv.getValue();
                Object resolvedValue=valueResolver.resolveValueIfNecessary(originalValue);
                SimpleTypeConverter simpleTypeConverter=new SimpleTypeConverter();
                //假设现在originalValue 表示的是ref=accountDao,已经通过resolve得到了accountDao对象
                //接下来怎么办？如何去调用PetStore的setAccountDao方法？
                BeanInfo beanInfo= Introspector.getBeanInfo(value.getClass());
                PropertyDescriptor[] pds=beanInfo.getPropertyDescriptors();
                for (PropertyDescriptor pd:pds){
                    if (pd.getName().equals(propertyName)){
                        Object convertValue=simpleTypeConverter.convertIfNecessary(resolvedValue,pd.getPropertyType());
                        pd.getWriteMethod().invoke(value,convertValue);
                        break;
                    }
                }
            }
        }catch (Exception e){
         throw new BeanCreationException("Failed to obtain BeanInfo for class ["+bd.getBeanClassName()+"]");
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
