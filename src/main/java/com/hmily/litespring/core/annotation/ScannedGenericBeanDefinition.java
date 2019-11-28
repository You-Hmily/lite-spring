package com.hmily.litespring.core.annotation;

import com.hmily.litespring.beans.factory.annotation.AnnotatedBeanDefinition;
import com.hmily.litespring.beans.factory.support.GenericBeanDefinition;
import com.hmily.litespring.core.type.AnnotationMetadata;

public class ScannedGenericBeanDefinition extends GenericBeanDefinition implements AnnotatedBeanDefinition {

    private final AnnotationMetadata metadata;


    public ScannedGenericBeanDefinition(AnnotationMetadata metadata) {
        super();

        this.metadata = metadata;

        setBeanClassName(this.metadata.getClassName());
    }


    public final AnnotationMetadata getMetadata() {
        return this.metadata;
    }

}
