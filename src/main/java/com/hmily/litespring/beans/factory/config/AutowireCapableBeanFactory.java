package com.hmily.litespring.beans.factory.config;

import com.hmily.litespring.beans.factory.BeanFactory;

public interface AutowireCapableBeanFactory extends BeanFactory {

    Object resolveDependency(DependencyDescriptor descriptor);

}
