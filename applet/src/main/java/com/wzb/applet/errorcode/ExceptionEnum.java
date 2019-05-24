package com.wzb.applet.errorcode;

import com.wzb.tools.exception.ExceptionInfoBO;
import com.wzb.tools.exception.OrgExceptionInfoEnum;

public interface ExceptionEnum extends OrgExceptionInfoEnum {

    /**
     * code:1001  <br>
     * msg: 失败
     */
    public ExceptionInfoBO EXCEPTION_ERR= new ExceptionInfoBO(1001,"失败");
    /**
     * code:1002  <br>
     * msg: 账号或密码错误
     */
    public ExceptionInfoBO EXCEPTION_USERORPASS= new ExceptionInfoBO(1002,"账号或密码错误");
    /**
     * code:1003  <br>
     * msg: 验证码不正确
     */
    public ExceptionInfoBO EXCEPTION_AUTHCODE_ERR= new ExceptionInfoBO(1003,"验证码不正确");
    /**
     * code:1004  <br>
     * msg: 验证码已失效
     */
    public ExceptionInfoBO EXCEPTION_AUTHCODE_LOSE= new ExceptionInfoBO(1004,"验证码已失效");

}
