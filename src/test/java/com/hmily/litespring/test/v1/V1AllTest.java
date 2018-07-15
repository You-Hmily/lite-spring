package com.hmily.litespring.test.v1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by zyzhmily on 2018/7/15.
 * 运行多个测试代码
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({BeanFactoryTest.class,ApplicatonContextTest.class,ResourceTest.class})
public class V1AllTest {

}
