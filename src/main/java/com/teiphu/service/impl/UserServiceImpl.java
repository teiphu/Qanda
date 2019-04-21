package com.teiphu.service.impl;

import com.teiphu.mapper.UserMapper;
import com.teiphu.pojo.UserDo;
import com.teiphu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:54
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(UserDo user) {
        return 0;
    }

    @Override
    public int deleteUser(Integer userId) {
        return 0;
    }

    @Override
    public int updateUser(UserDo user) {
        return 0;
    }

    @Override
    public UserDo getUser(Integer userId) {
        return null;
    }

    @Override
    public List<UserDo> listUser() {
        return null;
    }
}
