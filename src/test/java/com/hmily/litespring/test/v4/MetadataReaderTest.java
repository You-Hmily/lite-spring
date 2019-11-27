package com.hmily.litespring.test.v4;

import com.hmily.litespring.core.annotation.AnnotationAttributes;
import com.hmily.litespring.core.io.ClassPathResource;
import com.hmily.litespring.core.type.AnnotationMetadata;
import com.hmily.litespring.core.type.classreading.MetadataReader;
import com.hmily.litespring.core.type.classreading.SimpleMetadataReader;
import com.hmily.litespring.stereotype.Component;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class MetadataReaderTest {


    @Test
    public void testGetMetadata() throws IOException {
        ClassPathResource resource = new ClassPathResource("com/hmily/litespring/service/v4/PetStoreService.class");

        MetadataReader reader = new SimpleMetadataReader(resource);
        //注意：不需要单独使用ClassMetadata
        //ClassMetadata clzMetadata = reader.getClassMetadata();
        AnnotationMetadata amd = reader.getAnnotationMetadata();

        String annotation = Component.class.getName();

        Assert.assertTrue(amd.hasAnnotation(annotation));
        AnnotationAttributes attributes = amd.getAnnotationAttributes(annotation);
        Assert.assertEquals("petStoreService", attributes.get("value"));

        //注：下面对class metadata的测试并不充分
        Assert.assertFalse(amd.isAbstract());
        Assert.assertFalse(amd.isFinal());
        Assert.assertEquals("com.hmily.litespring.service.v4.PetStoreService", amd.getClassName());

    }

}
