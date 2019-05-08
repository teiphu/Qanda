package com.teiphu.controller;

import com.teiphu.mapper.TopicMapper;
import com.teiphu.pojo.QuestionDo;
import com.teiphu.pojo.TopicDo;
import com.teiphu.pojo.UserDo;
import com.teiphu.service.QuestionService;
import com.teiphu.service.TopicService;
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
@Api(tags = "问题控制器")
@Controller
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private TopicService topicService;

    @RequestMapping(value = "/home")
    public String home() {
        return "redirect:/question/retrieveQuestions";
    }

    @ApiOperation("保存问题")
    @PutMapping("saveQuestion")
    public String saveQuestion(Integer userId, Integer topicId, String content) {
        QuestionDo question = new QuestionDo();
        question.setUser(new UserDo(userId));
        question.setTopic(new TopicDo(topicId));
        question.setContent(content);
        int res = questionService.addQuestion(question);
        return "";
    }

    @ApiOperation("删除问题")
    @DeleteMapping("removeQuestion")
    public String removeQuestion(Integer questionId) {
        int res = questionService.deleteQuestion(questionId);
        return "";
    }

    @ApiOperation("修改问题")
    @PostMapping("changeQuestion")
    public String changeQuestion(Integer questionId, String questionContent) {
        QuestionDo question = new QuestionDo();
        question.setId(questionId);
        question.setContent(questionContent);
        int res = questionService.updateQuestion(question);
        return "";
    }

    @ApiOperation("分页检索问题")
    @GetMapping("retrieveQuestionByPage")
    public List<QuestionDo> retrieveQuestionByPage(Integer num) {
        List<QuestionDo> questions = questionService.listQuestionByPage(num);
        return questions;
    }

    /*@ApiOperation("检索问题")
    @RequestMapping(value = "/retrieveQuestion/{questionId}", method = RequestMethod.GET)
    public String retrieveQuestion(@PathVariable Integer questionId, Model model) {
        QuestionDo question = questionService.getQuestion(questionId);
        return question;
    }*/

    @ApiOperation("按用户检索问题")
    @GetMapping("retrieveQuestionsByUser")
    public List<QuestionDo> retrieveQuestionsByUser(Integer userId) {
        List<QuestionDo> questions = questionService.listQuestionByUser(userId);
        return questions;
    }

    @ApiOperation("按话题检索问题")
    @GetMapping("retrieveQuestionsByTopic")
    public List<QuestionDo> retrieveQuestionsByTopic(Integer topicId) {
        List<QuestionDo> questions = questionService.listQuestionByTopic(topicId);
        return questions;
    }

    /**
     * 获取所有的问题并附带一个答案到首页
     * @param session
     * @param model
     * @return
     */
    @ApiOperation("检索所有问题")
    @RequestMapping("retrieveQuestions")
    public String retrieveQuestions(HttpSession session, Model model) {
        List<QuestionDo> questions = questionService.listQuestion();
        model.addAttribute("questions", questions);
        UserDo user = (UserDo) session.getAttribute("user");
        model.addAttribute("user", user);
        List<TopicDo> topics = topicService.listTopicByUser(user.getId());
        model.addAttribute("topics", topics);
        return "index";
    }

    @ApiOperation("获取用户感兴趣的问题")
    @RequestMapping(value = "listQuestOfUserInterest", method = RequestMethod.GET)
    public String listQuestOfUserInterest(HttpSession session, Model model) {
        List<QuestionDo> questions = questionService.listQuestOfUserInterest();
        model.addAttribute("questions", questions);
        return "answer";
    }
}
