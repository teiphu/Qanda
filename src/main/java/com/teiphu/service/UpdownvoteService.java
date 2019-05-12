package com.teiphu.service;

import com.teiphu.pojo.UpdownvoteDo;

import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:51
 **/
public interface UpdownvoteService {

    int addVote(UpdownvoteDo vote);

    int deleteVote(Integer voteId);

    int updateVote(UpdownvoteDo vote);

    UpdownvoteDo getVote(Integer voteId);

    List<UpdownvoteDo> listVote();

    List<UpdownvoteDo> listUpvoteByAnswer(Integer answerId);

    List<UpdownvoteDo> listUpvoteByComment(Integer commentId);

    Integer countUpvoteByAnswer(Integer answerId);

    Integer countDownvoteByAnswer(Integer answerId);

    Integer countUpvoteByComment(Integer commentId);

    Integer countDownvoteByComment(Integer commentId);

    Integer deleteVoteByAnswerAndUser(Integer answerId, Integer userId);

    UpdownvoteDo getVoteByAnswerAndUser(Integer answerId, Integer userId);
}
