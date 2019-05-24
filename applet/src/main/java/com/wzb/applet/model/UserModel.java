package com.wzb.applet.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("用户信息")
public class UserModel {

    @ApiModelProperty("表ID")
    private Long id;

    @ApiModelProperty("用户姓名")
    private String userName;

    @ApiModelProperty("用户昵称")
    private String userNickname;

    @ApiModelProperty("登录时间")
    private LocalDateTime logonTime;

    @ApiModelProperty("注册时间")
    private LocalDateTime registerTime;

    @ApiModelProperty("手机号")
    private String userPhone;

    @ApiModelProperty("头像地址")
    private String headUrl;

}
