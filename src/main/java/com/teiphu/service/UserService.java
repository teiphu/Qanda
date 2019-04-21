package com.teiphu.service;

import com.teiphu.pojo.UserDo;

import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:52
 **/
public interface UserService {

    int addUser(UserDo user);

    int deleteUser(Integer userId);

    int updateUser(UserDo user);

    UserDo getUser(Integer userId);

    List<UserDo> listUser();
}
