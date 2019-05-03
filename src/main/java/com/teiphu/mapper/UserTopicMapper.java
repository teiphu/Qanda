package com.teiphu.mapper;

import com.teiphu.pojo.UserTopicDo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Teiphu
 * @Creation 2019.05.02 下午 06:16
 **/
@Mapper
public interface UserTopicMapper {

    int insertUserTopic(UserTopicDo userTopic);

    int deleteUserTopic(UserTopicDo userTopic);

}
