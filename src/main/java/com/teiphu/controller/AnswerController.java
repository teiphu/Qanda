package com.teiphu.controller;

import com.teiphu.pojo.AnswerDo;
import com.teiphu.pojo.QuestionDo;
import com.teiphu.pojo.UserDo;
import com.teiphu.service.AnswerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:56
 **/
@Api(tags = "答案控制器")
@RestController
@RequestMapping("answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @ApiOperation("保存答案")
    @PutMapping("saveAnswer")
    public String saveAnswer(Integer userId, Integer questId, String content) {
        AnswerDo answer = new AnswerDo();
        answer.setUser(new UserDo(userId));
        answer.setQuestion(new QuestionDo(questId));
        answer.setAnswerContent(content);
        int res = answerService.addAnswer(answer);
        return "";
    }

    @ApiOperation("删除答案")
    @DeleteMapping("removeAnswer")
    public String removeAnswer(Integer answerId) {
        int res = answerService.deleteAnswer(answerId);
        return "";
    }

    @ApiOperation("修改答案")
    @PostMapping("changeAnswer")
    public String changeAnswer(Integer answerId, String content) {
        AnswerDo answer = new AnswerDo();
        answer.setId(answerId);
        answer.setAnswerContent(content);
        int res = answerService.updateAnswer(answer);
        return "";
    }

    @ApiOperation("检索答案")
    @GetMapping("retrieveAnswer")
    public AnswerDo retrieveAnswer(Integer answerId) {
        AnswerDo answer = answerService.getAnswer(answerId);
        return answer;
    }

    @ApiOperation("检索所有答案")
    @GetMapping("retrieveAnswers")
    public List<AnswerDo> retrieveAnswers() {
        List<AnswerDo> answers = answerService.listAnswer();
        return answers;
    }

    @ApiOperation("查询问题的所有答案")
    @GetMapping("retrieveAnswersByQuestion")
    public List<AnswerDo> retrieveAnswersByQuestion(Integer questionId) {
        List<AnswerDo> answers = answerService.listAnswerByQuestion(questionId);
        return answers;
    }

    @ApiOperation("查询用户的所有答案")
    @GetMapping("retrieveAnswersByUser")
    public List<AnswerDo> retrieveAnswersByUser(Integer userId) {
        List<AnswerDo> answers = answerService.listAnswerByUser(userId);
        return answers;
    }

}
