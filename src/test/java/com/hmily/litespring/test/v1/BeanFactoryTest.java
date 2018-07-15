package com.hmily.litespring.test.v1;


import com.hmily.litespring.beans.BeanDefinition;
import com.hmily.litespring.beans.factory.BeanCreationException;
import com.hmily.litespring.beans.factory.BeanDefinitionStoreException;
import com.hmily.litespring.beans.factory.BeanFactory;
import com.hmily.litespring.beans.factory.support.DefaultBeanFactory;
import com.hmily.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import com.hmily.litespring.core.io.ClassPathResource;
import com.hmily.litespring.core.io.Resource;
import com.hmily.litespring.service.v1.PetStoreService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zyzhmily on 2018/7/14.
 */
public class BeanFactoryTest {

    DefaultBeanFactory factory=null;
    XmlBeanDefinitionReader reader=null;

    @Before
    public void setFactory(){
        factory =new DefaultBeanFactory();
        reader=new XmlBeanDefinitionReader(factory);
    }


    /**
     * 版本1测试用例
     */
    @Test
    public void  testgGetBean(){

//        BeanFactory factory =new DefaultBeanFactory("petstore-v1.xml");
//
//        BeanDefinition bd=factory.getBeanDefinition("petStore");
//
//        assertEquals("com.hmily.litespring.service.v1.PetStoreService",bd.getBeanClassName());
//
//        PetStoreService petStore=(PetStoreService)factory.getBean("petStore");
//
//        assertNotNull(petStore);
    }

    @Test
    public void  testgGetBeanV2(){
        Resource resource=new ClassPathResource("petstore-v1.xml");
        reader.loadBeanDefinitions(resource);
        BeanDefinition bd=factory.getBeanDefinition("petStoreService");

        assertTrue(bd.isSingleton());
        assertFalse(bd.isPrototype());
        assertEquals(BeanDefinition.SCOPE_DEFAULT,bd.getScope());

        assertEquals("com.hmily.litespring.service.v1.PetStoreService",bd.getBeanClassName());
        PetStoreService petStore=(PetStoreService)factory.getBean("petStoreService");


        assertNotNull(petStore);

        PetStoreService petStore1=(PetStoreService)factory.getBean("petStoreService");

        assertEquals(petStore,petStore1);
    }


    @Test
    public void testInvalidBean(){
        Resource resource=new ClassPathResource("petstore-v1.xml");
        reader.loadBeanDefinitions(resource);
        try{
            factory.getBean("invalidBean");
        }catch (BeanCreationException e){
            return;
        }
        Assert.fail("expect BeanCreationException ");
    }


    @Test
    public void testInvalidXML(){
        try{
            Resource resource=new ClassPathResource("xxxxx.xml");
            reader.loadBeanDefinitions(resource);
        }catch (BeanDefinitionStoreException e){
            return;
        }
        Assert.fail("except BeanDefinitionStoreException ");
    }
}
