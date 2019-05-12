package com.teiphu.service.impl;

import com.teiphu.mapper.AnswerMapper;
import com.teiphu.mapper.CommentMapper;
import com.teiphu.mapper.UpdownvoteMapper;
import com.teiphu.pojo.AnswerDo;
import com.teiphu.pojo.UpdownvoteDo;
import com.teiphu.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Iterator;
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
    public List<AnswerDo> listAnswerByQuestion(Integer questionId, Integer userId) {
        List<AnswerDo> answers = answerMapper.listAnswerByQuestion(questionId);
        Iterator<AnswerDo> it = answers.iterator();
        while (it.hasNext()) {
            AnswerDo answer = it.next();
            UpdownvoteDo vote = voteMapper.getUpdownvoteStatus(answer.getId(), userId);
            if (vote == null) {
                answer.setVoteStatus(0);
            } else {
                if (vote.getUpOrDown() == 1) {
                    answer.setVoteStatus(1);
                } else {
                    answer.setVoteStatus(2);
                }
            }
        }
        return answers;
    }

    @Override
    public List<AnswerDo> listAnswerByUser(Integer userId) {
        return answerMapper.listAnswerByUser(userId);
    }

    /**
     * 获取一个问题最新的那条答案
     * @param questionId
     * @return
     */
    @Override
    public AnswerDo getLatestAnswerByQuestion(Integer questionId) {
        AnswerDo answer = answerMapper.getLatestAnswerByQuestion(questionId);
        return answer;
    }
}
