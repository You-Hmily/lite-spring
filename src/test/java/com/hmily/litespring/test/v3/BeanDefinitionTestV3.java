package com.hmily.litespring.test.v3;

import com.hmily.litespring.beans.BeanDefinition;
import com.hmily.litespring.beans.ConstructorArgument;
import com.hmily.litespring.beans.RuntimeBeanReference;
import com.hmily.litespring.beans.TypeStringValue;
import com.hmily.litespring.beans.factory.support.ConstructorResolver;
import com.hmily.litespring.beans.factory.support.DefaultBeanFactory;
import com.hmily.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import com.hmily.litespring.core.io.ClassPathResource;
import com.hmily.litespring.core.io.Resource;
import com.hmily.litespring.service.v3.PetStoreService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by zyzhmily on 2018/8/18.
 */
public class BeanDefinitionTestV3 {

    @Test
    public void testConstructorArgument(){

        DefaultBeanFactory factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        Resource resource = new ClassPathResource("petstore-v3.xml");
        reader.loadBeanDefinitions(resource);

        BeanDefinition bd = factory.getBeanDefinition("petStoreService");

        ConstructorResolver resolver = new ConstructorResolver(factory);

        PetStoreService petStore = (PetStoreService)resolver.autowireConstructor(bd);

        // 验证参数version 正确地通过此构造函数做了初始化
        // PetStoreService(AccountDao accountDao, ItemDao itemDao,int version)
        Assert.assertEquals(1, petStore.getVersion());

        Assert.assertNotNull(petStore.getAccountDao());
        Assert.assertNotNull(petStore.getItemDao());




    }

}
