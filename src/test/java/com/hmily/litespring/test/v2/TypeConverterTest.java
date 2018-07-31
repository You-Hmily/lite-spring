package com.hmily.litespring.test.v2;

import com.hmily.litespring.beans.SimpleTypeConverter;
import com.hmily.litespring.beans.TypeConverter;

import com.hmily.litespring.beans.TypeMismatchException;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Assert;
import org.junit.Test;



/**
 * Created by zyzhmily on 2018/7/31.
 */
public class TypeConverterTest {

    @Test
    public void testConvertStringToInt(){
        TypeConverter converter=new SimpleTypeConverter();
        Integer i=converter.convertIfNecessary("3",Integer.class);
        Assert.assertEquals(3,i.intValue());

        try{
            converter.convertIfNecessary("3.1",Integer.class);
        }catch (TypeMismatchException e){
            return;
        }
        Assert.fail();
    }

    @Test
    public void testConvertStringToBoolean(){
        TypeConverter converter=new SimpleTypeConverter();
        Boolean b=converter.convertIfNecessary("true",Boolean.class);
        Assert.assertEquals(true,b.booleanValue());

        try{
            converter.convertIfNecessary("hhh",Boolean.class);
        }catch (TypeMismatchException e){
            return;
        }
        Assert.fail();
    }

}
