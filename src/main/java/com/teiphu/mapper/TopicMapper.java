package com.teiphu.mapper;

import com.teiphu.pojo.TopicDo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:45
 **/
@Mapper
public interface TopicMapper {

    int insertTopic(TopicDo topic);

    int deleteTopic(Integer topicId);

    int updateTopic(TopicDo topic);

    TopicDo getTopic(Integer topicId);

    List<TopicDo> listTopic();

    List<TopicDo> listTopicByCreatedUser(Integer userId);

    List<TopicDo> listTopicByUser(Integer userId);

    List<TopicDo> listTopicByQuestion(Integer questionId);
}
