package com.teiphu.controller;

import com.teiphu.pojo.AnswerDo;
import com.teiphu.pojo.QuestionDo;
import com.teiphu.pojo.TopicDo;
import com.teiphu.pojo.UserDo;
import com.teiphu.service.AnswerService;
import com.teiphu.service.QuestionService;
import com.teiphu.service.TopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:56
 **/
@Api(tags = "答案控制器")
@Controller
@RequestMapping("answer")
public class AnswerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnswerController.class);

    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private TopicService topicService;

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

    /**
     * 获取一个问题下的所有答案
     * @param model
     * @param questionId
     * @return
     */
    @ApiOperation("查询一个问题的所有答案")
    @GetMapping("retrieveAnswersByQuestion")
    @RequestMapping(value = "/retrieveAnswersByQuestion/{questionId}", method = RequestMethod.GET)
    public String retrieveAnswersByQuestion(Model model, @PathVariable Integer questionId) {
        QuestionDo question = questionService.getQuestion(questionId);
        List<AnswerDo> answers = answerService.listAnswerByQuestion(questionId);
        List<TopicDo> topics = topicService.listTopicByQuestion(questionId);
        model.addAttribute("question", question);
        model.addAttribute("answers", answers);
        Integer answerCount = answers.size();
        model.addAttribute("answerCount", answerCount);
        model.addAttribute("topics", topics);
        return "question-details";
    }

    @ApiOperation("查询用户的所有答案")
    @GetMapping("retrieveAnswersByUser")
    public List<AnswerDo> retrieveAnswersByUser(Integer userId) {
        List<AnswerDo> answers = answerService.listAnswerByUser(userId);
        return answers;
    }

}
