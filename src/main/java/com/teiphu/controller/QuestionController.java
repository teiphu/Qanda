package com.teiphu.controller;

import com.teiphu.pojo.QuestionDo;
import com.teiphu.pojo.TopicDo;
import com.teiphu.pojo.UserDo;
import com.teiphu.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:57
 **/
@Api(tags = "问题控制器")
@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

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

    @ApiOperation("检索问题")
    @GetMapping("retrieveQuestion")
    public QuestionDo retrieveQuestion(Integer questionId) {
        QuestionDo question = questionService.getQuestion(questionId);
        return question;
    }

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

    @ApiOperation("检索所有问题")
    @GetMapping("retrieveQuestions")
    public List<QuestionDo> retrieveQuestions() {
        List<QuestionDo> questions = questionService.listQuestion();
        return questions;
    }
}
