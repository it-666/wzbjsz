package com.wzb.applet.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Data
@ApiModel("用户信息")
public class UserRequestModel {

    @ApiModelProperty("用户姓名")
    private String userName;

    @ApiModelProperty("用户昵称")
    private String userNickname;

    @ApiModelProperty("密码")
    private String userPass;

    @ApiModelProperty("手机号")
    private String userPhone;

    @ApiModelProperty("头像地址")
    private String headUrl;

    @ApiModelProperty("验证码")
    private Integer code;

}
