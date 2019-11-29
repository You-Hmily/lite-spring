package com.hmily.litespring.context.support;

import com.hmily.litespring.beans.factory.support.DefaultBeanFactory;
import com.hmily.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import com.hmily.litespring.context.ApplicationContext;
import com.hmily.litespring.core.io.FileSystemResource;
import com.hmily.litespring.core.io.Resource;

/**
 * Created by zyzhmily on 2018/7/15.
 */
public class FileSystemXmlApplicationContext extends AbstractApplicationContext {

    public FileSystemXmlApplicationContext(String path) {
        super(path);
    }

    @Override
    protected Resource getResourceByPath(String path) {
        return new FileSystemResource(path);
    }

}
