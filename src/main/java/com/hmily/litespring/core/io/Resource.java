package com.hmily.litespring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zyzhmily on 2018/7/15.
 */
public interface Resource {

    public InputStream getInputStream() throws IOException;

    public String getDescription();

}
