package com.wzb.applet.controller;

import com.wzb.applet.errorcode.ExceptionEnum;
import com.wzb.applet.model.UserModel;
import com.wzb.applet.model.UserRequestModel;
import com.wzb.applet.restfulapi.ApiVersion;
import com.wzb.applet.service.UserService;
import com.wzb.tools.exception.ResultBO;
import com.wzb.tools.exception.ResultTool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * 用户 注册登录
 */
@RestController
@ApiVersion(1)
@Api(description = "用户",produces = "application/json",consumes = "application/json")
@RequestMapping("/{vpi_version}")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 登录
     * @param userName
     * @param userPass
     */
    @RequestMapping(path = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录", notes = "登录")
    public ResultBO userLogin(@PathVariable String vpi_version, @RequestParam String userName, @RequestParam String userPass){
        UserModel userModel = userService.userLogin(userName,userPass);
        if(Objects.isNull(userModel)){
            return ResultTool.error(ExceptionEnum.EXCEPTION_USERORPASS);
        }
        return ResultTool.success(userModel);
    }

    /**
     * 注册
     * @param userRequestModel
     */
    @RequestMapping(path = "/register",method = RequestMethod.POST)
    @ApiOperation(value = "注册", notes = "注册")
    public ResultBO userRegister(@PathVariable String vpi_version, @RequestBody UserRequestModel userRequestModel){
        int row = userService.userRegister(userRequestModel);
        // 失败
        if (row == 1001){
            return ResultTool.error(ExceptionEnum.EXCEPTION_ERR);
        }
        // 验证码不正确
        if (row == 1003){
            return ResultTool.error(ExceptionEnum.EXCEPTION_AUTHCODE_ERR);
        }
        // 验证码已失效
        if (row == 1004){
            return ResultTool.error(ExceptionEnum.EXCEPTION_AUTHCODE_LOSE);
        }
        return ResultTool.success();
    }

    /**
     * 获取验证码
     * @param userName
     * @param userNickname
     */
    @RequestMapping(path = "/authCode",method = RequestMethod.GET)
    @ApiOperation(value = "获取验证码", notes = "获取验证码")
    public ResultBO acquireAuthCode(@PathVariable String vpi_version,@RequestParam String userName, @RequestParam String userNickname){
        int row = userService.acquireAuthCode(userName,userNickname);
        if(row == 1001){
            return ResultTool.error(ExceptionEnum.EXCEPTION_ERR);
        }
        return ResultTool.success();
    }

}
