package com.teiphu.controller;

import com.teiphu.pojo.AnswerDo;
import com.teiphu.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:56
 **/
@RestController
@RequestMapping("answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @ResponseBody
    @PutMapping("saveAnswer")
    public String saveAnswer(AnswerDo answer) {
        int res = answerService.addAnswer(answer);
        return "";
    }

    @ResponseBody
    @DeleteMapping("removeAnswer")
    public String removeAnswer(Integer answerId) {
        int res = answerService.deleteAnswer(answerId);
        return "";
    }

    @ResponseBody
    @PostMapping("changeAnswer")
    public String changeAnswer(AnswerDo answer) {
        int res = answerService.updateAnswer(answer);
        return "";
    }

    @ResponseBody
    @GetMapping("retrieveAnswer")
    public AnswerDo retrieveAnswer(Integer answerId) {
        AnswerDo answer = answerService.getAnswer(answerId);
        return answer;
    }

    @ResponseBody
    @GetMapping("retrieveAnswers")
    public List<AnswerDo> retrieveAnswers() {
        List<AnswerDo> answers = answerService.listAnswer();
        return answers;
    }

    @ResponseBody
    @GetMapping("retrieveAnswersByQuestion")
    public List<AnswerDo> retrieveAnswersByQuestion(Integer questionId) {
        List<AnswerDo> answers = answerService.listAnswerByQuestion(questionId);
        return answers;
    }

    @ResponseBody
    @GetMapping("retrieveAnswersByUser")
    public List<AnswerDo> retrieveAnswersByUser(Integer userId) {
        List<AnswerDo> answers = answerService.listAnswerByUser(userId);
        return answers;
    }

}
