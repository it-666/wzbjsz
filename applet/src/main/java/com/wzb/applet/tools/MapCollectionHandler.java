package com.wzb.applet.tools;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MapCollectionHandler {

    private static Map<String,Map<String,Object>> authCode = new HashMap<String,Map<String,Object>>();

    /**
     * 存储验证码 记录过期时间
     * @param userName 用户名
     * @param code  验证码
     * @param dataTime  时间
     * @throws Exception
     */
    public static synchronized void putAuthCode(String userName,Integer code,Long dataTime) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",code);
        map.put("dateTime",dataTime);
        authCode.put(userName,map);
    }

    /**
     * 获取内容
     * @param userName
     * @return
     */
    public static synchronized Map<String,Object> queryAuthCode(String userName) {
        System.out.println("---->"+authCode);
        if(Objects.nonNull(authCode) && authCode.size() > 0){
            Set<String> set = authCode.keySet();
            Iterator<String> it = set.iterator();
            if(set.contains(userName)){
                return authCode.get(userName);
            }
        }
        return null;
    }

    /**
     * 删除
     * @param userName
     */
    public static synchronized void delAuthCode(String userName){
        if(Objects.nonNull(authCode) && authCode.size() > 0){
            authCode.remove(userName);
        }
    }
}
