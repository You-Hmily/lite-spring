package com.hmily.litespring.test.v5;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ApplicationContextTest5.class,BeanDefinitionTestV5.class,BeanFactoryTestV5.class,CglibAopProxyTest.class,
CGLibTest.class,MethodLocatingFactoryTest.class,PointCutTest.class,ReflectiveMethodInvocationTest.class})
public class V5AllTests {

}
