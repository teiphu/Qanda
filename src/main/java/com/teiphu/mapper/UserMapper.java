package com.teiphu.mapper;

import com.teiphu.pojo.UserDo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:42
 **/
@Mapper
public interface UserMapper {

    int insertUser(UserDo user);

    int deleteUser(Integer userId);

    int updateUser(UserDo user);

    UserDo getUser(Integer userId);

    List<UserDo> listUser();

    UserDo getUserByLogin(UserDo user);
}