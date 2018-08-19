package com.hmily.litespring.beans.factory.support;

import com.hmily.litespring.beans.BeanDefinition;
import com.hmily.litespring.beans.ConstructorArgument;
import com.hmily.litespring.beans.PropertyValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyzhmily on 2018/7/14.
 */
public class GenericBeanDefinition implements BeanDefinition{

    public static final String SCOPE_ATTRIBUTE="scope";

    private String id;

    private String beanClassName;

    private String scope=SCOPE_DEFAULT;

    private boolean singleton=true;

    private boolean prototype=false;

    private List<PropertyValue> propertyValueList=new ArrayList<PropertyValue>();

    private ConstructorArgument constructorArgument=new ConstructorArgument();

    public GenericBeanDefinition(String id, String beanClassName) {
        this.id = id;
        this.beanClassName = beanClassName;
    }

    @Override
    public boolean isSingleton() {
        return this.singleton;
    }

    @Override
    public boolean isPrototype() {
        return this.prototype;
    }

    @Override
    public String getScope() {
        return this.scope;
    }

    @Override
    public void setScope(String scope) {
        this.scope=scope;
        this.singleton=SCOPE_SINGLTEON.equals(scope)||SCOPE_DEFAULT.equals(scope);
        this.prototype=SCOPE_PROTOTYPE.equals(scope);
    }

    @Override
    public String getBeanClassName() {

        return this.beanClassName;
    }

    @Override
    public List<PropertyValue> getPropertyValues() {
        return this.propertyValueList;
    }

    @Override
    public ConstructorArgument getConstructorArgument() {
        return this.constructorArgument;
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public boolean hasConstructorArgumentValues() {
        return !this.constructorArgument.isEmpty();
    }


}
