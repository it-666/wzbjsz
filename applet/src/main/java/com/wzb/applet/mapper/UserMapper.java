package com.wzb.applet.mapper;

import com.wzb.applet.bean.UserDO;
import com.wzb.applet.model.UserModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * 用户
 */
@Mapper
public interface UserMapper {
    /**
     * 注册
     * @param userDO
     * @return
     */
    int insertUser(@Param("userDO")UserDO userDO);

    /**
     * 登录
     * @param userName
     * @param userPhone
     * @param userPass
     * @return
     */
    UserModel getUserByUserNameAndUserPass(@Param("userName")String userName, @Param("userPhone")String userPhone, @Param("userPass")String userPass);

    /**
     * 修改登录时间
     * @param id
     * @param loginTime
     */
    void updateUserLoginTime(@Param("id")Long id,@Param("loginTime")LocalDateTime loginTime);
}
