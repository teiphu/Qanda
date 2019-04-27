package com.teiphu.service;

import com.teiphu.pojo.QuestionDo;

import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:51
 **/
public interface QuestionService {
    int addQuestion(QuestionDo question);

    int deleteQuestion(Integer questionId);

    int updateQuestion(QuestionDo question);

    QuestionDo getQuestion(Integer questionId);

    List<QuestionDo> listQuestionByUser(Integer userId);

    List<QuestionDo> listQuestionByTopic(Integer topicId);

    List<QuestionDo> listQuestion();
}