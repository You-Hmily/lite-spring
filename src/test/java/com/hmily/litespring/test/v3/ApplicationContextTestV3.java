package com.hmily.litespring.test.v3;


import com.hmily.litespring.context.ApplicationContext;
import com.hmily.litespring.context.support.ClassPathXmlApplicationContext;

import com.hmily.litespring.service.v3.PetStoreService;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by zyzhmily on 2018/7/28.
 */
public class ApplicationContextTestV3 {

    @Test
    public void testGetBeanProperty(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("petstore-v3.xml");
        PetStoreService petStore=(PetStoreService)ctx.getBean("petStoreService");
        assertNotNull(petStore.getAccountDao());
        assertNotNull(petStore.getItemDao());
        assertNotNull(petStore.getVersion());
    }



}
