package com.wzb.applet.tools;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * 时间转换类
 * @author 邬志斌 <br>
 * 2018年4月12日 下午5:28:55
 */
public class DateTimeTool {
    private final static  DateTimeFormatter DATETIME_FORTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final static  DateTimeFormatter DATE_FORTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final static  DateTimeFormatter TIME_FORTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    
    /**
     * private 类型的构造器
     * 
     * 工具类 全部添加私有构造器，方法全部声明为static 
     */
    private DateTimeTool(){}

   
    //对象转字符串
    /** 1
     * 1. LocalDateTime 转为字符串
     */
    public static synchronized String localDateTimeToString(LocalDateTime localDateTime){
        String strDate = localDateTime.format(DATETIME_FORTER); 
        return strDate;
    }
    
    /** 2
     * 2. LocalDate 转为字符串
     */
    public static synchronized String localDateToString(LocalDate localDate){   	
    	
        return localDate.toString();
    }

    /** 3
     * 3. LocalTime 转为字符串
     */
    public static synchronized String localTimeToString(LocalTime localTime){
    	String strDate = localTime.format(TIME_FORTER);
        return strDate;
    }
    
    //字符串转对象
    
    /** 4
     * 1. 字符串类型日期转为 LocalDateTime 
     */
    public static synchronized LocalDateTime stringToLocaDateTime(String stringDateTime){
    	LocalDateTime localDateTime = LocalDateTime.parse(stringDateTime, DATETIME_FORTER);
        return localDateTime;
    }
    
    /** 5
     * 2. 字符串类型日期转为 LocalDate 
     */
    public static synchronized LocalDate stringToLocaDate(String stringDate){
    	LocalDate localDate = LocalDate.parse(stringDate, DATE_FORTER);
        return localDate;
    }
    
    /** 6
     * 3. 字符串类型日期转为 LocalTime 
     */
    public static synchronized LocalTime stringToLocaTime(String stringTime){
    	LocalTime localTime = LocalTime.parse(stringTime, TIME_FORTER);
        return localTime;
    }
    
    //=====================================================
    
    /** 7
     * 毫秒数转为LocalDateTime日期
     */
    public static synchronized LocalDateTime millisToLocalDateTime(Long milliSeconds){
    	//我的操作系统是"Asia/Shanghai"，即GMT+8的北京时间  用：ZoneId.systemDefault()可以查看 
    	
    	//此毫秒数为 13位
    	LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(milliSeconds),  ZoneOffset.of("+8"));
    	
    	
        return localDateTime;
    }
    
    //对象转毫秒数
    
    /** 8
     * 把LocalDateTime日期转为毫秒数 
     */
    public static synchronized Long localDateTimeToMillis(LocalDateTime localDateTime){
    	
    	Long longLocalDateTime = localDateTime.atZone(ZoneOffset.of("+8")).toInstant().toEpochMilli(); 
        return longLocalDateTime;
    }

    /** 9
     *  字符串转为毫秒数
     */
    public static synchronized Long stringToMillis(String stringDateTime){
    	LocalDateTime localDateTime = LocalDateTime.parse(stringDateTime, DATETIME_FORTER);
    	Long longLocalDateTime = localDateTime.atZone(ZoneOffset.of("+8")).toInstant().toEpochMilli();
        return longLocalDateTime;
    }
    
    /** 10 
     * 毫秒数 转为 字符串 年月日 时分秒
     */
    public static synchronized String millisToStringDateTime(Long milliSeconds){
    	//此毫秒数为 13位
    	LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(milliSeconds),  ZoneOffset.of("+8"));  
        String strDate = localDateTime.format(DATETIME_FORTER); 
        return strDate;
    }
    
    /** 11
     * 毫秒数 转为 日期字符串 年月日
     */
    public static synchronized String millisToStringDate(Long milliSeconds){
    	String strLocalDate = LocalDateTime.ofInstant(Instant.ofEpochMilli(milliSeconds), ZoneId.of("+8")).format(DATE_FORTER);
        return strLocalDate;
    }
    
    
    /** 12
     * 毫秒数转为 日期字符串 时分秒
     */
    public static synchronized String millisToStringTime(Long milliSeconds){
    	String strDate = LocalDateTime.ofInstant(Instant.ofEpochMilli(milliSeconds), ZoneId.of("+8")).format(TIME_FORTER);
        return strDate;
    }
    
    

}
