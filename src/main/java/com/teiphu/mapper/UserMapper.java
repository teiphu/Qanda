package com.teiphu.mapper;

import com.teiphu.pojo.UserDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

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

    List<UserDo> listUser(RowBounds rowBounds);

    UserDo getUserByLogin(UserDo user);

    UserDo getUserByUsername(String username);

    int countUser();

    int updateLogoutTime(Integer userId);
}
