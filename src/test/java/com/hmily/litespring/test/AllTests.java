package com.hmily.litespring.test;

import com.hmily.litespring.test.v1.ApplicatonContextTest;
import com.hmily.litespring.test.v1.BeanFactoryTest;
import com.hmily.litespring.test.v1.ResourceTest;
import com.hmily.litespring.test.v1.V1AllTest;
import com.hmily.litespring.test.v2.V2AllTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by zyzhmily on 2018/7/15.
 * 运行多个测试代码
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({V1AllTest.class,V2AllTest.class})
public class AllTests {

}
