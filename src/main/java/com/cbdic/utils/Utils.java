package com.cbdic.utils;

public class Utils {

    /**
     * 对数据进行前3后4脱敏
     * @param id
     * @return
     */
    public static String cookPhoneIdNo(String id){
        //数据不规范
        if(id.length()<= 6) return null;
        int len = id.length();
        String res = "";
        for(int i = 0;i < 3;i++) res += id.substring(i,i+1);
        for(int i = 3;i < len-3;i++) res += "*";
        for(int i = len-4;i<len;i++) res += id.substring(i,i+1);
        return res;
    }
}
