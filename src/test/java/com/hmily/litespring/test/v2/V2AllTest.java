package com.hmily.litespring.test.v2;

import com.hmily.litespring.test.v1.ApplicatonContextTest;
import com.hmily.litespring.test.v1.BeanFactoryTest;
import com.hmily.litespring.test.v1.ResourceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by zyzhmily on 2018/7/15.
 * 运行多个测试代码
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ApplicationContextTestV2.class,BeanDefinitionTestV2.class,BeanDefinitionValueResolverTest.class,
CustomBooleanEditorTest.class,CustomNumberEditorTest.class,TypeConverterTest.class})
public class V2AllTest {

}
