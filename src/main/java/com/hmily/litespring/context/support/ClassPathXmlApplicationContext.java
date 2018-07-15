package com.hmily.litespring.context.support;

import com.hmily.litespring.core.io.ClassPathResource;
import com.hmily.litespring.core.io.Resource;

/**
 * Created by zyzhmily on 2018/7/15.
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    public ClassPathXmlApplicationContext(String configFile) {
        super(configFile);
    }

    @Override
    protected Resource getResource(String path) {
        return new ClassPathResource(path,this.getBeanClassLoader());
    }

}
