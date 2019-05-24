package com.wzb.applet.tools;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具
 * @author 邬志斌<br>
 * 2018年4月27日 下午6:23:43
 */
public class MD5Handler {

    /**  */
    private MD5Handler() {}

    /** 
    * 对字符串 md5加密(小写+数字)  
    */  
   public static String getMD5LowerCase(String str)  {  
        
       MessageDigest md = null;
    try {
        md = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
        return null;
    }  
       md.update(str.getBytes());  
       return new BigInteger(1, md.digest()).toString(16);  
   } 

   /** 
    * 对字符串 md5加密(大写+数字)  
    */  
   public static String getMD5UpperCase(String str) {
       
       char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};         
 
       byte[] btInput = str.getBytes();  
       MessageDigest mdInst = null;
    try {
        mdInst = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
        return null;
    }  
       mdInst.update(btInput);  
       byte[] md = mdInst.digest();  
       int j = md.length;  
       char s[] = new char[j * 2];  
       int k = 0;  
       for (int i = 0; i < j; i++) {  
           byte byte0 = md[i];  
           s[k++] = hexDigits[byte0 >>> 4 & 0xf];  
           s[k++] = hexDigits[byte0 & 0xf];  
       }  
       return new String(s);  
     }


}
