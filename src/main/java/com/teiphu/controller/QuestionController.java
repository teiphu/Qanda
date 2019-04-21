package com.teiphu.controller;

import com.teiphu.pojo.QuestionDo;
import com.teiphu.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:57
 **/
@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @ResponseBody
    @PutMapping("saveQuestion")
    public String saveQuestion(QuestionDo question) {
        int res = questionService.addQuestion(question);
        return "";
    }

    @ResponseBody
    @DeleteMapping("removeQuestion")
    public String removeQuestion(Integer questionId) {
        int res = questionService.deleteQuestion(questionId);
        return "";
    }

    @ResponseBody
    @PostMapping("changeQuestion")
    public String changeQuestion(QuestionDo question) {
        int res = questionService.updateQuestion(question);
        return "";
    }

    @ResponseBody
    @GetMapping("retrieveQuestion")
    public QuestionDo retrieveQuestion(Integer questionId) {
        QuestionDo question = questionService.getQuestion(questionId);
        return question;
    }

    @ResponseBody
    @GetMapping("retrieveQuestionsByUser")
    public List<QuestionDo> retrieveQuestionsByUser(Integer userId) {
        List<QuestionDo> questions = questionService.listQuestionByUser(userId);
        return questions;
    }

    @ResponseBody
    @GetMapping("retrieveQuestionsByTopic")
    public List<QuestionDo> retrieveQuestionsByTopic(Integer topicId) {
        List<QuestionDo> questions = questionService.listQuestionByTopic(topicId);
        return questions;
    }

    @ResponseBody
    @GetMapping("retrieveQuestions")
    public List<QuestionDo> retrieveQuestions() {
        List<QuestionDo> questions = questionService.listQuestion();
        return questions;
    }
}
