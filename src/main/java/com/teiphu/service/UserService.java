package com.teiphu.service;

import com.teiphu.pojo.AnswerDo;
import com.teiphu.pojo.UserDo;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:52
 **/
public interface UserService {

    int addUser(UserDo user);

    int deleteUser(Integer userId);

    int updateUser(UserDo user);

    UserDo getUserByName(String username);

    UserDo getUser(Integer userId);

    List<UserDo> listUser(Integer page, Integer limit);

    UserDo getUserByLogin(String email, String phone, String password);

    List<AnswerDo> listAnswerToTheQuestionOfConcern(Integer id, Timestamp gmtLogout);

    int countUser();

    int updateLogoutTime(Integer id);
}
