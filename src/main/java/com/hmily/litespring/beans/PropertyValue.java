package com.hmily.litespring.beans;

/**
 * Created by zyzhmily on 2018/7/28.
 */
public class PropertyValue {
    private final String name;

    private final Object value;

    private boolean converted=false;

    private Object convertedValue;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public synchronized boolean isConverted(){
        return converted;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public synchronized Object getConvertedValue() {
        return convertedValue;
    }

    public synchronized void setConvertedValue(Object convertedValue) {
        this.converted=true;
        this.convertedValue = convertedValue;
    }
}
