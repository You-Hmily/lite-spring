package com.hmily.litespring.test.v4;

import com.hmily.litespring.context.ApplicationContext;
import com.hmily.litespring.context.support.ClassPathXmlApplicationContext;
import com.hmily.litespring.service.v4.PetStoreService;
import org.junit.Assert;
import org.junit.Test;

public class ApplicationContextTest4 {

    @Test
    public void testGetBeanProperty(){
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v4.xml");
        PetStoreService petStoreService = (PetStoreService) ctx.getBean("petStore");

        Assert.assertNotNull(petStoreService.getAccountDao());
        Assert.assertNotNull(petStoreService.getItemDao());

    }


}
