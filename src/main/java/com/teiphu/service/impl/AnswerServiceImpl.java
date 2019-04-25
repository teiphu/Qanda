package com.teiphu.service.impl;

import com.teiphu.mapper.AnswerMapper;
import com.teiphu.pojo.AnswerDo;
import com.teiphu.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:52
 **/
@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerMapper answerMapper;

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int addAnswer(AnswerDo answer) {
        return 0;
    }

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int deleteAnswer(Integer answerId) {
        return 0;
    }

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int updateAnswer(AnswerDo answer) {
        return 0;
    }

    @Override
    public AnswerDo getAnswer(Integer answerId) {
        return null;
    }

    @Override
    public List<AnswerDo> listAnswer() {
        return null;
    }

    @Override
    public List<AnswerDo> listAnswerByQuestion(Integer questionId) {
        return null;
    }

    @Override
    public List<AnswerDo> listAnswerByUser(Integer userId) {
        return null;
    }
}
