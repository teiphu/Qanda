package com.teiphu.controller;

import com.teiphu.pojo.AnswerDo;
import com.teiphu.pojo.QuestionDo;
import com.teiphu.pojo.TopicDo;
import com.teiphu.pojo.UserDo;
import com.teiphu.service.AnswerService;
import com.teiphu.service.QuestionService;
import com.teiphu.service.TopicService;
import com.teiphu.service.UserTopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:57
 **/
@Api(tags = "话题控制器")
@Controller
@RequestMapping("topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private UserTopicService userTopicService;

    @ApiOperation("取消关注或关注话题")
    @PostMapping("updateTopicAttention")
    public String updateTopicAttention(Integer topicId, Integer userId, Integer followStatus) {
        if (followStatus.intValue() == 0) {
            int res = userTopicService.deleteUserTopic(topicId, userId);
        } else if (followStatus.intValue() == 1){
            int num = userTopicService.getUserTopic(topicId, userId);
            if (num < 1) {
                int res = userTopicService.addUserTopic(topicId, userId);
            }
        }
        return "";
    }

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

    /**
     * 获取一个话题下的所有问题，问题与话题是M:N的关系
     * @param model
     * @param topicId
     * @return 返回“话题”页面
     */
    @ApiOperation("检索话题")
    @RequestMapping(value = "/retrieveTopic/{topicId}")
    public String retrieveTopic(HttpSession session, Model model, @PathVariable Integer topicId) {
        UserDo user = (UserDo) session.getAttribute("user");
        TopicDo topic = topicService.getTopic(topicId, user.getId());
        List<QuestionDo> questions = questionService.listQuestionByTopic(topicId);
        Iterator<QuestionDo> it = questions.iterator();
        while (it.hasNext()) {
            QuestionDo question = it.next();
            AnswerDo answer = answerService.getLatestAnswerByQuestion(question.getId());
            question.setAnswer(answer);
        }
        List<TopicDo> topicList = topicService.listTopicByUser(user.getId());
        Integer attention = userTopicService.getAttentionCount(topicId);
        model.addAttribute("attention", attention);
        model.addAttribute("user", user);
        model.addAttribute("topic", topic);
        model.addAttribute("topicList", topicList);
        model.addAttribute("questions", questions);
        return "topic";
    }

    @ApiOperation("检索所有话题")
    @GetMapping("retrieveTopics")
    public String retrieveTopics(HttpSession session, Model model) {
        UserDo user = (UserDo) session.getAttribute("user");
        List<TopicDo> topics = topicService.listTopic(user.getId());
        model.addAttribute("topics", topics);
        return "topiclist";
    }

}
