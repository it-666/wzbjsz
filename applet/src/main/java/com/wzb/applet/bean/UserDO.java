package com.wzb.applet.bean;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户
 */
@Data
public class UserDO {

    private Long id;
    /**
     * 用户名用于登录 邮箱
     */
    private String userName;
    /**
     * 登录密码
     */
    private String userPass;
    /**
     * 昵称
     */
    private String userNickname;
    /**
     * 登录时间
     */
    private LocalDateTime loginTime;
    /**
     * 注册时间
     */
    private LocalDateTime registerTime;
    /**
     * 手机号 用于登录
     */
    private String userPhone;
    /**
     * 修改时间
     */
    private LocalDateTime amendTime;
    /**
     * 注册码 用于活动
     */
    private String registerCode;
    /**
     * 头像地址
     */
    private String headUrl;

}
