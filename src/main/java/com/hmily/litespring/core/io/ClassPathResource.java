package com.hmily.litespring.core.io;

import com.hmily.litespring.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zyzhmily on 2018/7/15.
 */
public class ClassPathResource implements Resource {

    private String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
         this(path,(ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = classLoader!=null?classLoader: ClassUtils.getDefaultClassLoader();
    }

    @Override
    public InputStream getInputStream() throws IOException{
        InputStream is=this.classLoader.getResourceAsStream(this.path);
        if (is==null){
            throw new FileNotFoundException(this.path);
        }
        return is;
    }

    @Override
    public String getDescription() {
        return null;
    }


}
