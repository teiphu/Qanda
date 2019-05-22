package com.teiphu.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.teiphu.http.HttpStatus;
import com.teiphu.http.Result;
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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    @ResponseBody
    @PostMapping("saveAnswer")
    public Result saveAnswer(HttpSession session, Integer questionId, String answerContent) {
        AnswerDo answer = new AnswerDo();
        UserDo user = (UserDo) session.getAttribute("user");
        answer.setUser(user);
        answer.setQuestion(new QuestionDo(questionId));
        answer.setAnswerContent(answerContent);
        int res = answerService.addAnswer(answer);
        if (res > 0) {
            return new Result(HttpStatus.OK.getCode(), HttpStatus.OK.getDesc());
        } else {
            return new Result(HttpStatus.INTERNAL_SERVER_ERROR.getCode(), HttpStatus.INTERNAL_SERVER_ERROR.getDesc());
        }
    }

    @ApiOperation("删除答案")
    @ResponseBody
    @PostMapping("removeAnswer")
    public Result removeAnswer(Integer answerId) {
        int res = answerService.deleteAnswer(answerId);
        if (res > 0) {
            return new Result(HttpStatus.OK.getCode(), HttpStatus.OK.getDesc());
        } else {
            return new Result(HttpStatus.INTERNAL_SERVER_ERROR.getCode(), HttpStatus.INTERNAL_SERVER_ERROR.getDesc());
        }
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
    /*@RequiredPermission(PermissionConstants.ADMIN)*/
    @GetMapping("retrieveAnswersByQuestion")
    @RequestMapping(value = "/retrieveAnswersByQuestion/{questionId}", method = RequestMethod.GET)
    public String retrieveAnswersByQuestion(HttpSession session, Model model, @PathVariable Integer questionId) {
        UserDo user = (UserDo) session.getAttribute("user");
        QuestionDo question = questionService.getQuestion(questionId, user.getId());
        List<AnswerDo> answers = answerService.listAnswerByQuestion(questionId, user.getId());
        List<TopicDo> topics = topicService.listTopicByQuestion(questionId);
        model.addAttribute("question", question);
        model.addAttribute("answers", answers);
        Integer answerCount = answers.size();
        model.addAttribute("answerCount", answerCount);
        model.addAttribute("topics", topics);
        List<TopicDo> availTopics = topicService.listSimilarTopic(question.getContent(), topics);
        model.addAttribute("availTopics", availTopics);
        return "question-details";
    }

    @ApiOperation("查询用户的所有答案")
    @GetMapping("retrieveAnswersByUser")
    public List<AnswerDo> retrieveAnswersByUser(Integer userId) {
        List<AnswerDo> answers = answerService.listAnswerByUser(userId);
        return answers;
    }

    @ResponseBody
    @GetMapping("listAnswerPaging")
    public JSONObject listAnswerPaging(String searchText, Integer page, Integer limit) {
        int count = 0;
        List<AnswerDo> answers = null;
        if (!StringUtils.isEmpty(searchText)) {
            answers = answerService.listAnswerBySearch(searchText, page, limit);
            count = answerService.countAnswerBySearch(searchText);
        } else {
            answers = answerService.listAnswerPaging(page, limit);
            count = answerService.countAnswer();
        }
        JSONObject res = new JSONObject();
        res.put("code", 0);
        res.put("count", count);
        res.put("msg", "");
        JSONArray quesJA = new JSONArray();
        quesJA.addAll(answers);
        res.put("data", quesJA);
        return res;
    }

}
