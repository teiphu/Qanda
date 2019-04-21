package com.teiphu.mapper;

import com.teiphu.pojo.AnswerDo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:45
 **/
@Mapper
public interface AnswerMapper {

    int insertAnswer(AnswerDo answer);

    int deleteAnswer(Integer answerId);

    int updateAnswer(AnswerDo answer);

    AnswerDo getAnswer(Integer answerId);

    List<AnswerDo> listAnswerByQuestion(Integer questionId);

    List<AnswerDo> listAnswerByUser(Integer userId);

    List<AnswerDo> listAnswer();
}
