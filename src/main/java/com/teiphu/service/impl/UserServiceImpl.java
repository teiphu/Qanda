package com.teiphu.service.impl;

import com.teiphu.mapper.AnswerMapper;
import com.teiphu.mapper.UserMapper;
import com.teiphu.pojo.AnswerDo;
import com.teiphu.pojo.UserDo;
import com.teiphu.service.UserService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:54
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AnswerMapper answerMapper;

    /*@Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDo user = userMapper.getUserByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("username is not exists");
        }
        return user;
    }*/

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int addUser(UserDo user) {
        return userMapper.insertUser(user);
    }

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int deleteUser(Integer userId) {
        return userMapper.deleteUser(userId);
    }

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int updateUser(UserDo user) {
        return userMapper.updateUser(user);
    }

    @Override
    public UserDo getUserByName(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public UserDo getUser(Integer userId) {
        return userMapper.getUser(userId);
    }

    @Override
    public List<UserDo> listUser(Integer page, Integer limit) {
        int offset = (page - 1) * limit;
        RowBounds rowBounds = new RowBounds(offset, limit);
        List<UserDo> users = userMapper.listUser(rowBounds);
        return users;
    }

    @Override
    public UserDo getUserByLogin(String email, String phone, String password) {
        UserDo user = new UserDo(email, phone, password);
        UserDo userDo = userMapper.getUserByLogin(user);
        return userDo;
    }

    @Override
    public List<AnswerDo> listAnswerToTheQuestionOfConcern(Integer id, Timestamp gmtLogout) {
        return answerMapper.listNewAnswer(id, gmtLogout);
    }

    @Override
    public int countUser() {
        return userMapper.countUser();
    }

    @Override
    public int updateLogoutTime(Integer userId) {
        int res = userMapper.updateLogoutTime(userId);
        return res;
    }
}
