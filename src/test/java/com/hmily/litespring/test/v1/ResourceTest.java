package com.hmily.litespring.test.v1;

import com.hmily.litespring.core.io.ClassPathResource;
import com.hmily.litespring.core.io.FileSystemResource;
import com.hmily.litespring.core.io.Resource;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zyzhmily on 2018/7/15.
 */
public class ResourceTest {

    @Test
    public void testClassPathResource(){
        Resource r=new ClassPathResource("petstore-v1.xml");
        InputStream is=null;
        try {
            is= r.getInputStream();
            Assert.assertNotNull(is);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testFileSystemResource(){
//        Resource r=new FileSystemResource("E:\\GitHub\\lite-spring\\src\\test\\resources\\petstore-v1.xml");
//        InputStream is=null;
//        try {
//            is=r.getInputStream();
//            Assert.assertNotNull(is);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            if (is!=null){
//                try {
//                    is.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
    }

}
