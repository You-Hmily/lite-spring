package com.hmily.litespring.test.v2;


import com.hmily.litespring.context.ApplicationContext;
import com.hmily.litespring.context.support.ClassPathXmlApplicationContext;
import com.hmily.litespring.service.v2.PetStoreService;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by zyzhmily on 2018/7/28.
 */
public class ApplicationContextTestV2 {

    @Test
    public void testGetBean(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("petstore-v2.xml");
        PetStoreService petStore=(PetStoreService)ctx.getBean("petStore");
        assertNotNull(petStore.getAccountDao());
        assertNotNull(petStore.getItemDao());
    }



}
