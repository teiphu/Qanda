package com.teiphu.service;

import com.teiphu.pojo.QuestionDo;
import com.teiphu.pojo.UserDo;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionServiceTest.class);

    @Autowired
    private QuestionService questionService;

    @Rule
    public ContiPerfRule contiPerfRule = new ContiPerfRule();

    @Test
    public void addQuestion() {
        UserDo user = new UserDo();
        user.setId(2);
        QuestionDo questionDo = new QuestionDo();
        questionDo.setContent("为什么要做单元测试？");
        questionDo.setUser(user);
        int res = questionService.addQuestion(questionDo);
        LOGGER.info(String.valueOf(res));

    }

    @Test
    public void deleteQuestion() {
        Integer questionId = 46;
        int res = questionService.deleteQuestion(questionId);
        LOGGER.info(String.valueOf(res));

    }

    @Test
    @PerfTest(invocations = 10000, threads = 1000)
    public void getQuestion() {
        Integer questionId = 48;
        QuestionDo question = questionService.getQuestion(questionId);
        LOGGER.info(question.toString());

    }

    @Test
    @PerfTest(invocations = 1000, threads = 10)
    public void listQuestionByUser() {
        String msg = "This is a test";
        List<QuestionDo> questions = questionService.listQuestionByUser(2);
        for (QuestionDo question : questions) {
            LOGGER.info(question.toString());
        }

    }

    @Test
    @PerfTest(invocations = 100, threads = 10)
    public void listQuestionByPage() {
        int page = 1;
        List<QuestionDo> questions = questionService.listQuestionByPage(1);
        for (QuestionDo question : questions) {
            LOGGER.info(question.toString());
        }
    }
}
