package com.teiphu.controller;

import com.teiphu.pojo.TopicDo;
import com.teiphu.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:57
 **/
@RestController
@RequestMapping("topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @ResponseBody
    @PutMapping("saveTopic")
    public String saveTopic(TopicDo topic) {
        int res = topicService.addTopic(topic);
        return "";
    }

    @ResponseBody
    @DeleteMapping("removeTopic")
    public String removeTopic(Integer topicId) {
        int res = topicService.deleteTopic(topicId);
        return "";
    }

    @ResponseBody
    @PostMapping("changeTopic")
    public String changeTopic(TopicDo topic) {
        int res = topicService.updateTopic(topic);
        return "";
    }

    @ResponseBody
    @GetMapping("retrieveTopic")
    public TopicDo retrieveTopic(Integer topicId) {
        TopicDo topic = topicService.getTopic(topicId);
        return topic;
    }

    @ResponseBody
    @GetMapping("retrieveTopics")
    public List<TopicDo> retrieveTopics() {
        List<TopicDo> topics = topicService.listTopic();
        return topics;
    }

}
