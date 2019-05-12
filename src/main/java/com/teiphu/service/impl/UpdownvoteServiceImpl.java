package com.teiphu.service.impl;

import com.teiphu.mapper.UpdownvoteMapper;
import com.teiphu.pojo.UpdownvoteDo;
import com.teiphu.service.UpdownvoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:54
 **/
@Service
public class UpdownvoteServiceImpl implements UpdownvoteService {

    @Autowired
    private UpdownvoteMapper voteMapper;

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int addVote(UpdownvoteDo vote) {
        return voteMapper.insertUpdownvote(vote);
    }

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int deleteVote(Integer voteId) {
        return voteMapper.deleteUpdownvote(voteId);
    }

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int updateVote(UpdownvoteDo vote) {
        return voteMapper.updateUpdownvote(vote);
    }

    @Override
    public UpdownvoteDo getVote(Integer voteId) {
        return voteMapper.getUpdownvote(voteId);
    }

    @Override
    public List<UpdownvoteDo> listVote() {
        return voteMapper.listUpdownvote();
    }

    @Override
    public List<UpdownvoteDo> listUpvoteByAnswer(Integer answerId) {
        return voteMapper.listUpvoteByAnswer(answerId);
    }

    @Override
    public List<UpdownvoteDo> listUpvoteByComment(Integer commentId) {
        return voteMapper.listUpvoteByComment(commentId);
    }

    @Override
    public Integer countUpvoteByAnswer(Integer answerId) {
        return voteMapper.countUpvoteByAnswer(answerId);
    }

    @Override
    public Integer countDownvoteByAnswer(Integer answerId) {
        return voteMapper.countDownvoteByAnswer(answerId);
    }

    @Override
    public Integer countUpvoteByComment(Integer commentId) {
        return voteMapper.countUpvoteByComment(commentId);
    }

    @Override
    public Integer countDownvoteByComment(Integer commentId) {
        return voteMapper.countDownvoteByComment(commentId);
    }

    @Override
    public Integer deleteVoteByAnswerAndUser(Integer answerId, Integer userId) {
        return voteMapper.deleteVoteByAnswerAndUser(answerId, userId);
    }

    @Override
    public UpdownvoteDo getVoteByAnswerAndUser(Integer answerId, Integer userId) {
        return voteMapper.getVoteByAnswerAndUser(answerId, userId);
    }
}
