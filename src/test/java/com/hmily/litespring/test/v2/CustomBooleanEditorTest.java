package com.hmily.litespring.test.v2;

import com.hmily.litespring.beans.propertyeditors.CustomBooleanEditor;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zyzhmily on 2018/7/31.
 */
public class CustomBooleanEditorTest {

    @Test
    public void testConvertStringToBoolean(){

        CustomBooleanEditor editor=new CustomBooleanEditor(true);

        editor.setAsText("true");
        Assert.assertEquals(true,((Boolean)editor.getValue()).booleanValue());
        editor.setAsText("false");
        Assert.assertEquals(false,((Boolean)editor.getValue()).booleanValue());

        editor.setAsText("on");
        Assert.assertEquals(true,((Boolean)editor.getValue()).booleanValue());
        editor.setAsText("off");
        Assert.assertEquals(false,((Boolean)editor.getValue()).booleanValue());

        editor.setAsText("yes");
        Assert.assertEquals(true,((Boolean)editor.getValue()).booleanValue());
        editor.setAsText("no");
        Assert.assertEquals(false,((Boolean)editor.getValue()).booleanValue());

        try{
            editor.setAsText("aabbcc");
        }catch (IllegalArgumentException e){
            return;
        }
        Assert.fail();

    }

}
