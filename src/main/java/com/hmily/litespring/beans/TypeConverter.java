package com.hmily.litespring.beans;

import com.sun.corba.se.impl.io.TypeMismatchException;

/**
 * Created by zyzhmily on 2018/7/31.
 */
public interface TypeConverter {


    <T> T convertIfNecessary(Object value, Class<T> requiredType) throws TypeMismatchException;
}
