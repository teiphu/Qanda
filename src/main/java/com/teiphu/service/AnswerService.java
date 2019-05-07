package com.teiphu.service;

import com.teiphu.pojo.AnswerDo;

import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:50
 **/
public interface AnswerService {

    int addAnswer(AnswerDo answer);

    int deleteAnswer(Integer answerId);

    int updateAnswer(AnswerDo answer);

    AnswerDo getAnswer(Integer answerId);

    List<AnswerDo> listAnswer();

    List<AnswerDo> listAnswerByQuestion(Integer questionId);

    List<AnswerDo> listAnswerByUser(Integer userId);

    AnswerDo getLatestAnswerByQuestion(Integer questionId);
}
