package com.teiphu.mapper;

import com.teiphu.pojo.UpdownvoteDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:46
 **/
@Mapper
public interface UpdownvoteMapper {

    int insertUpdownvote(UpdownvoteDo Updownvote);

    int deleteUpdownvote(Integer updownvoteId);

    int deleteUpdownvoteByComment(Integer commentId);

    int updateUpdownvote(UpdownvoteDo updownvote);

    UpdownvoteDo getUpdownvote(Integer updownvoteId);

    UpdownvoteDo getUpdownvoteStatus(@Param("answerId") Integer answerId, @Param("userId") Integer userId);

    List<UpdownvoteDo> listUpdownvote();

    List<UpdownvoteDo> listUpvoteByAnswer(Integer answerId);

    List<UpdownvoteDo> listUpvoteByComment(Integer commentId);

    Integer countUpvoteByAnswer(Integer answerId);

    Integer countDownvoteByAnswer(Integer answerId);

    Integer countUpvoteByComment(Integer commentId);

    Integer countDownvoteByComment(Integer commentId);

    Integer deleteVoteByAnswerAndUser(@Param("answerId") Integer answerId, @Param("userId") Integer userId);

    UpdownvoteDo getVoteByAnswerAndUser(@Param("answerId") Integer answerId, @Param("userId") Integer userId);
}
