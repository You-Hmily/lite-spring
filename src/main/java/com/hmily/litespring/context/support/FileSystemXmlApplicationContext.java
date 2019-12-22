package com.hmily.litespring.context.support;


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
    protected Resource getResource(String path) {
        return new FileSystemResource(path);
    }

}
