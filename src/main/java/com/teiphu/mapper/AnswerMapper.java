package com.teiphu.mapper;

import com.teiphu.pojo.AnswerDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:45
 **/
@Mapper
public interface AnswerMapper {

    int insertAnswer(AnswerDo answer);

    int deleteAnswer(Integer answerId);

    int deleteAnswerByQuestion(Integer questionId);

    int updateAnswer(AnswerDo answer);

    AnswerDo getAnswer(Integer answerId);

    List<AnswerDo> listAnswerByQuestion(Integer questionId);

    List<AnswerDo> listAnswerByUser(Integer userId);

    List<AnswerDo> listAnswer();

    AnswerDo getLatestAnswerByQuestion(Integer questionId);

    List<AnswerDo> listNewAnswer(@Param("userId") Integer userId, @Param("recentTime") Timestamp recentTime);

    List<AnswerDo> listAnswerPaging(RowBounds rowBounds);

    int countAnswer();

    List<AnswerDo> listAnswerBySearch(String searchText, RowBounds rowBounds);

    int countAnswerBySearch(String searchText);
}
