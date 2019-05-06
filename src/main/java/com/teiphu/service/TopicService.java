package com.teiphu.service;

import com.teiphu.pojo.TopicDo;

import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:51
 **/
public interface TopicService {

    int addTopic(TopicDo topicDo);
    
    int deleteTopic(Integer topicId);
    
    int updateTopic(TopicDo topic);

    TopicDo getTopic(Integer topicId);

    List<TopicDo> listTopic();

    List<TopicDo> listTopicByQuestion(Integer questionId);
}
