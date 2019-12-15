package com.hmily.litespring.test.v1;

import com.hmily.litespring.context.ApplicationContext;
import com.hmily.litespring.context.support.ClassPathXmlApplicationContext;
import com.hmily.litespring.context.support.FileSystemXmlApplicationContext;
import com.hmily.litespring.service.v1.PetStoreService;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zyzhmily on 2018/7/15.
 */
public class ApplicatonContextTest {

    @Test
    public void testGetBean(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("petstore-v1.xml");
        PetStoreService petStoreService=(PetStoreService) ctx.getBean("petStoreService");
        Assert.assertNotNull(petStoreService);
    }

    @Test
    public void testGetBeanFromFileSystemContext(){
        //注意啊，这里仍然是hardcode了一个本地路径，这是不好的实践!! 如何处理，留作作业
		/*ApplicationContext ctx = new FileSystemXmlApplicationContext("C:\\Users\\liuxin\\git-litespring\\src\\test\\resources\\petstore-v1.xml");
		PetStoreService petStore = (PetStoreService)ctx.getBean("petStore");
		Assert.assertNotNull(petStore);*/
    }


}
