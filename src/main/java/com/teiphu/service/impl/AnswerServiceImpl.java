package com.teiphu.service.impl;

import com.teiphu.mapper.AnswerMapper;
import com.teiphu.mapper.CommentMapper;
import com.teiphu.mapper.UpdownvoteMapper;
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

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UpdownvoteMapper voteMapper;

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int addAnswer(AnswerDo answer) {
        return answerMapper.insertAnswer(answer);
    }

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int deleteAnswer(Integer answerId) {
        int res = answerMapper.deleteAnswer(answerId);
        commentMapper.deleteCommentByAnswer(answerId);
        return res;
    }

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int updateAnswer(AnswerDo answer) {
        return answerMapper.updateAnswer(answer);
    }

    @Override
    public AnswerDo getAnswer(Integer answerId) {
        return answerMapper.getAnswer(answerId);
    }

    @Override
    public List<AnswerDo> listAnswer() {
        return answerMapper.listAnswer();
    }

    @Override
    public List<AnswerDo> listAnswerByQuestion(Integer questionId) {
        return answerMapper.listAnswerByQuestion(questionId);
    }

    @Override
    public List<AnswerDo> listAnswerByUser(Integer userId) {
        return answerMapper.listAnswerByUser(userId);
    }
}
