package com.hmily.litespring.core.type;

import java.util.Set;

import com.hmily.litespring.core.annotation.AnnotationAttributes;

public interface AnnotationMetadata extends ClassMetadata{

    Set<String> getAnnotationTypes();

    boolean hasAnnotation(String annotationType);

    public AnnotationAttributes getAnnotationAttributes(String annotationType);
}
