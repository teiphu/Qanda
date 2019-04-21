package com.teiphu.service.impl;

import com.teiphu.mapper.TopicMapper;
import com.teiphu.pojo.TopicDo;
import com.teiphu.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
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
    public int addTopic(TopicDo topicDo) {
        return 0;
    }

    @Override
    public int deleteTopic(Integer topicId) {
        return 0;
    }

    @Override
    public int updateTopic(TopicDo topic) {
        return 0;
    }

    @Override
    public TopicDo getTopic(Integer topicId) {
        return null;
    }

    @Override
    public List<TopicDo> listTopic() {
        return null;
    }
}
