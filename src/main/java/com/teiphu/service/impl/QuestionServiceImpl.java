package com.teiphu.service.impl;

import com.teiphu.mapper.QuestionMapper;
import com.teiphu.pojo.QuestionDo;
import com.teiphu.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:53
 **/
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int addQuestion(QuestionDo question) {
        return 0;
    }

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int deleteQuestion(Integer questionId) {
        return 0;
    }

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int updateQuestion(QuestionDo question) {
        return 0;
    }

    @Override
    public QuestionDo getQuestion(Integer questionId) {
        return null;
    }

    @Override
    public List<QuestionDo> listQuestionByUser(Integer userId) {
        return null;
    }

    @Override
    public List<QuestionDo> listQuestionByTopic(Integer topicId) {
        return null;
    }

    @Override
    public List<QuestionDo> listQuestion() {
        return null;
    }
}
