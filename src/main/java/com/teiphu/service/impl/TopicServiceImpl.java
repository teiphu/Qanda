package com.teiphu.service.impl;

import com.teiphu.mapper.TopicMapper;
import com.teiphu.mapper.UserTopicMapper;
import com.teiphu.pojo.TopicDo;
import com.teiphu.service.TopicService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:54
 **/
@Service
public class TopicServiceImpl implements TopicService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TopicServiceImpl.class);

    @Autowired
    private TopicMapper topicMapper;

    @Autowired
    private UserTopicMapper userTopicMapper;

    @PostConstruct
    public void init() {
        LOGGER.info(topicMapper.toString());
    }

    @Override
    @Transactional(rollbackFor = {IOException.class})
    public int addTopic(TopicDo topic) {
        return topicMapper.insertTopic(topic);
    }

    @Override
    @Transactional(rollbackFor = {IOException.class})
    public int deleteTopic(Integer topicId) {
        return topicMapper.deleteTopic(topicId);
    }

    @Override
    @Transactional(rollbackFor = {IOException.class})
    public int updateTopic(TopicDo topic) {
        return topicMapper.updateTopic(topic);
    }

    @Override
    public TopicDo getTopic(Integer topicId, Integer userId) {
        TopicDo topic = topicMapper.getTopic(topicId);
        int num = userTopicMapper.getUserTopic(topicId, userId);
        if (num > 0) {
            topic.setFollowStatus(1);
        } else {
            topic.setFollowStatus(0);
        }
        return topic;
    }

    @Override
    public List<TopicDo> listTopic(Integer userId) {
        List<TopicDo> topics = topicMapper.listTopic();
        Iterator<TopicDo> it = topics.iterator();
        while (it.hasNext()) {
            TopicDo topic = it.next();
            int num = userTopicMapper.getUserTopic(topic.getId(), userId);
            int attention = userTopicMapper.getAttentionCount(topic.getId());
            topic.setAttention(attention);
            if (num > 0) {
                topic.setFollowStatus(1);
            } else {
                topic.setFollowStatus(0);
            }
        }
        return topics;
    }

    @Override
    public List<TopicDo> listTopicByQuestion(Integer questionId) {
        return topicMapper.listTopicByQuestion(questionId);
    }

    @Override
    public List<TopicDo> listTopicByUser(Integer userId) {
        return topicMapper.listTopicByUser(userId);
    }

    @Override
    public List<TopicDo> listSimilarTopic(String content, List<TopicDo> topics) {
        Set<String> topicNameSet = new HashSet<>();
        if (topics != null && topics.size() > 0) {
            for (TopicDo topic : topics) {
                topicNameSet.add(topic.getTopicName());
            }
        }
        List<TopicDo> availTopics = topicMapper.listTopic();
        Iterator<TopicDo> it = availTopics.iterator();
        while (it.hasNext()) {
            TopicDo topic = it.next();
            if (topicNameSet.contains(topic.getTopicName()) || !StringUtils.contains(content, topic.getTopicName())) {
                it.remove();
            }
        }
        return availTopics;
    }
}
