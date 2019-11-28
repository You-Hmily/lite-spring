package com.hmily.litespring.beans.factory.annotation;

import com.hmily.litespring.beans.BeanDefinition;
import com.hmily.litespring.core.type.AnnotationMetadata;

public interface AnnotatedBeanDefinition extends BeanDefinition {
    AnnotationMetadata getMetadata();
}
