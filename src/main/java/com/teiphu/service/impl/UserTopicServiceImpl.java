package com.teiphu.service.impl;

import com.teiphu.mapper.UserTopicMapper;
import com.teiphu.service.UserTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Teiphu
 * @Creation 2019.05.07 下午 11:59
 **/
@Service
public class UserTopicServiceImpl implements UserTopicService {

    @Autowired
    private UserTopicMapper userTopicMapper;

    @Override
    public int getAttentionCount(Integer topicId) {
        return userTopicMapper.getAttentionCount(topicId);
    }

    @Override
    public int deleteUserTopic(Integer topicId, Integer userId) {
        return userTopicMapper.deleteUserTopicByTopicidAndUserid(topicId, userId);
    }

    @Override
    public int getUserTopic(Integer topicId, Integer userId) {
        return userTopicMapper.getUserTopic(topicId, userId);
    }

    @Override
    public int addUserTopic(Integer topicId, Integer userId) {
        return userTopicMapper.insertUserTopicById(topicId, userId);
    }
}
