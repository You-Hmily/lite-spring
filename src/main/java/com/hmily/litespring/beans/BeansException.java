package com.hmily.litespring.beans;

/**
 * Created by zyzhmily on 2018/7/14.
 */
public class BeansException extends RuntimeException{

    public BeansException(String msg){
        super(msg);
    }

    public BeansException(String msg,Throwable cause){
        super(msg,cause);
    }
}
