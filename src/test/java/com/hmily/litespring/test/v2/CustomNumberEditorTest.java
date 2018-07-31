package com.hmily.litespring.test.v2;

import com.hmily.litespring.beans.propertyeditors.CustomNumberEditor;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zyzhmily on 2018/7/30.
 */
public class CustomNumberEditorTest {

    @Test
    public void testConvertString(){
        CustomNumberEditor editor=new CustomNumberEditor(Integer.class,true);
        editor.setAsText("3");
        Object value=editor.getValue();
        Assert.assertTrue(value instanceof Integer);
        Assert.assertEquals(3,((Integer)editor.getValue()).intValue());

        editor.setAsText("");
        Assert.assertTrue(editor.getValue()==null);

        try{
            editor.setAsText("3.1");
        }catch (IllegalArgumentException e){
            return;
        }
    }


}
