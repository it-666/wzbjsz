package com.wzb.applet.service;

import com.wzb.applet.bean.UserDO;
import com.wzb.applet.id.IdGenerator;
import com.wzb.applet.mapper.UserMapper;
import com.wzb.applet.model.UserModel;
import com.wzb.applet.model.UserRequestModel;
import com.wzb.applet.tools.DateTimeTool;
import com.wzb.applet.tools.EmailTools;
import com.wzb.applet.tools.MD5Handler;
import com.wzb.applet.tools.MapCollectionHandler;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

/**
 * 用户
 */
@Service
@Log4j
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IdGenerator idGenerator;
    /**
     * 登录
     * @param userName
     * @param userPass
     */
    public UserModel userLogin(String userName,String userPass){
        userPass = MD5Handler.getMD5UpperCase(userPass);
        UserModel userModel = userMapper.getUserByUserNameAndUserPass(userName,userName,userPass);
        if (Objects.isNull(userModel)){
            return null;
        }
        userMapper.updateUserLoginTime(userModel.getId(),DateTimeTool.millisToLocalDateTime(System.currentTimeMillis()));
        return userModel;
    }

    /**
     * 注册
     * @return
     */
    public int userRegister(UserRequestModel userRequestModel){
        UserDO userDO = new UserDO();
        if (Objects.isNull(userRequestModel)){
            log.warn("UserRequestModel is NULL");
            return 1001;
        }
        Long dataTim = System.currentTimeMillis();
        Map<String,Object> map = MapCollectionHandler.queryAuthCode(userRequestModel.getUserName());
        if (Objects.isNull(map) && map.size() == 0){
            return 1001;
        }
        if(!Objects.equals(Integer.valueOf(String.valueOf(map.get("code"))),userRequestModel.getCode())){
            return 1003; // 验证码不正确
        }
        if(Objects.nonNull(map.get("dateTime"))){
            Long dateTime = Long.valueOf(String.valueOf(map.get("dateTime")));
            Long time = (dataTim - dateTime) / (1000 * 60);
            if(time > 10){
                return 1004;//验证码已失效
            }
        }
        userDO.setId(idGenerator.getNextId());
        userDO.setUserName(userRequestModel.getUserName());
        userDO.setUserPass(MD5Handler.getMD5UpperCase(userRequestModel.getUserPass()));
        userDO.setUserNickname(userRequestModel.getUserNickname());
        userDO.setRegisterTime(DateTimeTool.millisToLocalDateTime(dataTim));
        userDO.setUserPhone(userRequestModel.getUserPhone());
        userDO.setHeadUrl(userRequestModel.getHeadUrl());
        int row = userMapper.insertUser(userDO);
        if(row == 0){
            return 1001;
        }
        MapCollectionHandler.delAuthCode(userRequestModel.getUserName());//清除验证码
        return row;
    }

    /**
     * 发送验证码
     * @param userName
     * @param userNickname
     * @return
     */
    public int acquireAuthCode(String userName,String userNickname){
        int code = (int)((Math.random()*9+1)*100000);
        Long dataTime = System.currentTimeMillis();
        String emSubject = "技术栈注册验证码";
        String embody = "亲爱的"+userNickname+"您好,您的验证码是："+code+",十分钟内有效，欢迎使用技术栈。";
        // 记录验证码
        MapCollectionHandler.putAuthCode(userName,code,dataTime);
        try {
            EmailTools.email(userName,userNickname,emSubject,embody);
        }catch (Exception e){
            return 1001;//发送邮件失败
        }
        return 0000;//成功
    }
}
