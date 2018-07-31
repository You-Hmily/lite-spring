package com.hmily.litespring.util;

/**
 * Created by zyzhmily on 2018/7/29.
 */
public abstract class StringUtils {

    public static boolean hasLength(String str){
        return hasLength((CharSequence) str);
    }

    public static boolean hasLength(CharSequence str){
        return (str!=null&&str.length()>0);
    }

    public static boolean hasText(String str){
        return hasLength((CharSequence) str);
    }

    public static boolean hasText(CharSequence charSequence){
        if (!hasLength(charSequence)){
            return false;
        }
        int strLen=charSequence.length();
        for (int i=0;i<strLen;i++){
            if (!Character.isWhitespace(charSequence.charAt(i))){
                return true;
            }
        }
        return false;
    }

    public static String trimAllWhitespace(String str) {
        if (!hasLength(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        int index = 0;
        while (sb.length() > index) {
            if (Character.isWhitespace(sb.charAt(index))) {
                sb.deleteCharAt(index);
            }
            else {
                index++;
            }
        }
        return sb.toString();
    }


}
