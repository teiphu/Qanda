package com.teiphu.service.impl;

import com.teiphu.mapper.TopicMapper;
import com.teiphu.pojo.TopicDo;
import com.teiphu.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:54
 **/
@Service
public class TopicServiceImpl implements TopicService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TopicServiceImpl.class);

    @Autowired
    private TopicMapper topicMapper;

    @PostConstruct
    public void init() {
        LOGGER.info(topicMapper.toString());
    }

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int addTopic(TopicDo topic) {
        return topicMapper.insertTopic(topic);
    }

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int deleteTopic(Integer topicId) {
        return topicMapper.deleteTopic(topicId);
    }

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int updateTopic(TopicDo topic) {
        return topicMapper.updateTopic(topic);
    }

    @Override
    public TopicDo getTopic(Integer topicId) {
        return topicMapper.getTopic(topicId);
    }

    @Override
    public List<TopicDo> listTopic() {
        return topicMapper.listTopic();
    }

    @Override
    public List<TopicDo> listTopicByQuestion(Integer questionId) {
        return topicMapper.listTopicByQuestion(questionId);
    }

    @Override
    public List<TopicDo> listTopicByUser(Integer userId) {
        return topicMapper.listTopicByUser(userId);
    }
}
