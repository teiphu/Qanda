package com.teiphu.controller;

import com.teiphu.pojo.TopicDo;
import com.teiphu.pojo.UserDo;
import com.teiphu.service.TopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:57
 **/
@Api(tags = "话题控制器")
@RestController
@RequestMapping("topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @ApiOperation("保存话题")
    @PutMapping("saveTopic")
    public String saveTopic(Integer userId, String topicName, String topicDetail) {
        TopicDo topic = new TopicDo();
        topic.setUser(new UserDo(userId));
        topic.setTopicName(topicName);
        topic.setTopicDetail(topicDetail);
        int res = topicService.addTopic(topic);
        return "";
    }

    @ApiOperation("删除话题")
    @DeleteMapping("removeTopic")
    public String removeTopic(Integer topicId) {
        int res = topicService.deleteTopic(topicId);
        return "";
    }

    @ApiOperation("修改话题")
    @PostMapping("changeTopic")
    public String changeTopic(Integer topicId, String topicName, String topicDetail) {
        TopicDo topic = new TopicDo();
        topic.setId(topicId);
        topic.setTopicName(topicName);
        topic.setTopicDetail(topicDetail);
        int res = topicService.updateTopic(topic);
        return "";
    }

    @ApiOperation("检索话题")
    @GetMapping("retrieveTopic")
    public TopicDo retrieveTopic(Integer topicId) {
        TopicDo topic = topicService.getTopic(topicId);
        return topic;
    }

    @ApiOperation("检索所有话题")
    @GetMapping("retrieveTopics")
    public List<TopicDo> retrieveTopics() {
        List<TopicDo> topics = topicService.listTopic();
        return topics;
    }

}
