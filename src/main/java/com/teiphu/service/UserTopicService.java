package com.teiphu.service;

/**
 * @Author Teiphu
 * @Creation 2019.05.07 下午 11:58
 **/
public interface UserTopicService {

    int getAttentionCount(Integer topicId);

    int deleteUserTopic(Integer topicId, Integer userId);

    int getUserTopic(Integer topicId, Integer userId);

    int addUserTopic(Integer topicId, Integer userId);
}
