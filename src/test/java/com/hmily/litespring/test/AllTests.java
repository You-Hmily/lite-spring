package com.hmily.litespring.test;

import com.hmily.litespring.test.v1.ApplicatonContextTest;
import com.hmily.litespring.test.v1.BeanFactoryTest;
import com.hmily.litespring.test.v1.ResourceTest;
import com.hmily.litespring.test.v1.V1AllTest;
import com.hmily.litespring.test.v2.V2AllTest;
import com.hmily.litespring.test.v3.V3AllTests;
import com.hmily.litespring.test.v4.V4AllTests;
import com.hmily.litespring.test.v5.V5AllTests;
import com.hmily.litespring.test.v6.V6AllTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by zyzhmily on 2018/7/15.
 * 运行多个测试代码
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({V1AllTest.class,V2AllTest.class, V3AllTests.class, V4AllTests.class, V5AllTests.class, V6AllTests.class})
public class AllTests {

}
