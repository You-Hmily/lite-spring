package com.hmily.litespring.util;

import java.util.Map;

/**
 * Created by zyzhmily on 2018/7/15.
 */
public class Assert {

    public static  void  notNull(Object object,String message){
        if (object==null){
            throw new IllegalArgumentException(message);
        }
    }
}
