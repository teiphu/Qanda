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
        return 0;
    }

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int deleteVote(Integer voteId) {
        return 0;
    }

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int updateVote(UpdownvoteDo vote) {
        return 0;
    }

    @Override
    public UpdownvoteDo getVote(Integer voteId) {
        return null;
    }

    @Override
    public List<UpdownvoteDo> listVote() {
        return null;
    }

    @Override
    public List<UpdownvoteDo> listUpvoteByAnswer(Integer answerId) {
        return null;
    }

    @Override
    public List<UpdownvoteDo> listUpvoteByComment(Integer commentId) {
        return null;
    }

    @Override
    public Integer countUpvoteByAnswer(Integer answerId) {
        return null;
    }

    @Override
    public Integer countDownvoteByAnswer(Integer answerId) {
        return null;
    }

    @Override
    public Integer countUpvoteByComment(Integer commentId) {
        return null;
    }

    @Override
    public Integer countDownvoteByComment(Integer commentId) {
        return null;
    }
}
