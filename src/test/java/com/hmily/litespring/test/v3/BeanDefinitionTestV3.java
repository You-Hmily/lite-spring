package com.hmily.litespring.test.v3;

import com.hmily.litespring.beans.BeanDefinition;
import com.hmily.litespring.beans.ConstructorArgument;
import com.hmily.litespring.beans.RuntimeBeanReference;
import com.hmily.litespring.beans.TypeStringValue;
import com.hmily.litespring.beans.factory.support.DefaultBeanFactory;
import com.hmily.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import com.hmily.litespring.core.io.ClassPathResource;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by zyzhmily on 2018/8/18.
 */
public class BeanDefinitionTestV3 {

    @Test
    public void testConstructorArgument(){
        DefaultBeanFactory factory=new DefaultBeanFactory();
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(new ClassPathResource("petstore-v3.xml"));
        BeanDefinition bd=factory.getBeanDefinition("petStore");
        Assert.assertEquals("com.hmily.litespring.service.v3.PetStoreService",bd.getBeanClassName());

        ConstructorArgument args=bd.getConstructorArgument();
        List<ConstructorArgument.ValueHolder> valueHolders=args.getArgumentValues();

        Assert.assertEquals(3,valueHolders.size());

        RuntimeBeanReference ref1=(RuntimeBeanReference)valueHolders.get(0).getValue();
        Assert.assertEquals("accountDao",ref1.getBeanName());
        RuntimeBeanReference ref2= (RuntimeBeanReference) valueHolders.get(1).getValue();
        Assert.assertEquals("itemDao",ref2.getBeanName());

        TypeStringValue strValue= (TypeStringValue) valueHolders.get(2).getValue();
        Assert.assertEquals("1",strValue.getValue());




    }

}
