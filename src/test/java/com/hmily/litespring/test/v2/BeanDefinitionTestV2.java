package com.hmily.litespring.test.v2;

import com.hmily.litespring.beans.BeanDefinition;
import com.hmily.litespring.beans.PropertyValue;
import com.hmily.litespring.beans.RuntimeBeanReference;
import com.hmily.litespring.beans.factory.support.DefaultBeanFactory;
import com.hmily.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import com.hmily.litespring.core.io.ClassPathResource;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by zyzhmily on 2018/7/28.
 */
public class BeanDefinitionTestV2 {

    @Test
    public void testGetBeanDefinition(){
        DefaultBeanFactory factory=new DefaultBeanFactory();
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(new ClassPathResource("petstore-v2.xml"));
        BeanDefinition bd=factory.getBeanDefinition("petStore");
        List<PropertyValue> pvs=bd.getPropertyValues();
        Assert.assertTrue(pvs.size()==5);
        {
            PropertyValue pv1=this.getPropertyValue("accountDao",pvs);
            Assert.assertNotNull(pv1);
            Assert.assertTrue(pv1.getValue() instanceof RuntimeBeanReference);
        }
        {
            PropertyValue pv2=this.getPropertyValue("itemDao",pvs);
            Assert.assertNotNull(pv2);
            Assert.assertTrue(pv2.getValue() instanceof RuntimeBeanReference);
        }
    }

    private PropertyValue getPropertyValue(String name,List<PropertyValue> pvs){
        for (PropertyValue pv:pvs){
            if (pv.getName().equals(name)){
                return pv;
            }
        }
        return null;
    }
}
