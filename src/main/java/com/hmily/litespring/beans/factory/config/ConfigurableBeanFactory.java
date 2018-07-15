package com.hmily.litespring.beans.factory.config;

import com.hmily.litespring.beans.factory.BeanFactory;

/**
 * Created by zyzhmily on 2018/7/15.
 */
public interface ConfigurableBeanFactory extends BeanFactory{

    public void setBeanClassLoader(ClassLoader classLoader);

    public ClassLoader getBeanClassLoader();

}
