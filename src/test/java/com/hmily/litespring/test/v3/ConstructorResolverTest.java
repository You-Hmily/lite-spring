package com.hmily.litespring.test.v3;

import com.hmily.litespring.beans.BeanDefinition;
import com.hmily.litespring.beans.factory.support.ConstructorResolver;
import com.hmily.litespring.beans.factory.support.DefaultBeanFactory;
import com.hmily.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import com.hmily.litespring.core.io.ClassPathResource;
import com.hmily.litespring.service.v3.PetStoreService;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * Created by zyzhmily on 2018/8/18.
 */
public class ConstructorResolverTest {


    @Test
    public void testAutowireConstructor(){
        DefaultBeanFactory factory=new DefaultBeanFactory();
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(new ClassPathResource("petstore-v3.xml"));
        BeanDefinition bd=factory.getBeanDefinition("petStoreService");

        ConstructorResolver resolver=new ConstructorResolver(factory);

        PetStoreService petStoreService= (PetStoreService) resolver.autowireConstructor(bd);

        Assert.assertEquals(1,petStoreService.getVersion());
        Assert.assertNotNull(petStoreService.getAccountDao());
        Assert.assertNotNull(petStoreService.getItemDao());
    }

}
