package com.hmily.litespring.beans;

/**
 * Created by zyzhmily on 2018/7/14.
 */
public interface BeanDefinition {

    public static final String SCOPE_SINGLTEON="singleton";

    public static final String SCOPE_PROTOTYPE="prototype";

    public static final String SCOPE_DEFAULT="";

    public boolean isSingleton();

    public boolean isPrototype();

    public String getScope();

    public void setScope(String scope);

    public String getBeanClassName();
}
