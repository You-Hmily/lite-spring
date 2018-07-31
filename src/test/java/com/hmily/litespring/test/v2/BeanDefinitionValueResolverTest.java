package com.hmily.litespring.test.v2;

import com.hmily.litespring.beans.RuntimeBeanReference;
import com.hmily.litespring.beans.TypeStringValue;
import com.hmily.litespring.beans.factory.support.DefaultBeanFactory;
import com.hmily.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import com.hmily.litespring.context.support.BeanDefinitionValueResolver;
import com.hmily.litespring.core.io.ClassPathResource;
import com.hmily.litespring.dao.v2.AccountDao;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zyzhmily on 2018/7/30.
 */
public class BeanDefinitionValueResolverTest {

    @Test
    public void testResolveRuntimeBeanReference(){
        DefaultBeanFactory factory=new DefaultBeanFactory();
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(new ClassPathResource("petstore-v2.xml"));

        BeanDefinitionValueResolver resolver=new BeanDefinitionValueResolver(factory);

        RuntimeBeanReference reference=new RuntimeBeanReference("accountDao");
        Object value=resolver.resolveValueIfNecessary(reference);

        Assert.assertNotNull(value);
        Assert.assertTrue(value instanceof AccountDao);
    }

    @Test
    public void testResolveTypedStringValue(){
        DefaultBeanFactory factory=new DefaultBeanFactory();
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(new ClassPathResource("petstore-v2.xml"));
        BeanDefinitionValueResolver resolver=new BeanDefinitionValueResolver(factory);

        TypeStringValue stringValue=new TypeStringValue("test");
        Object value=resolver.resolveValueIfNecessary(stringValue);

        Assert.assertNotNull(value);
        Assert.assertEquals("test",value);
    }
}
