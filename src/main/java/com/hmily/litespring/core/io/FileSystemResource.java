package com.hmily.litespring.core.io;

import com.hmily.litespring.util.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zyzhmily on 2018/7/15.
 */
public class FileSystemResource implements Resource {

    private final String path;

    private final File file;


    public FileSystemResource(String path) {
        Assert.notNull(path,"Path must not be null");
        this.file=new File(path);
        this.path=path;
    }

    public FileSystemResource(File file){
        this.path = file.getPath();
        this.file = file;
    }



    @Override
    public InputStream getInputStream() throws IOException{
        return new FileInputStream(this.file);
    }

    @Override
    public String getDescription() {
        return "file [ "+this.file.getAbsolutePath()+" ]";
    }
}
