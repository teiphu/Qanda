package com.teiphu.mapper;

import com.teiphu.pojo.QuestionDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:46
 **/
@Mapper
public interface QuestionMapper {

    int insertQuestion(QuestionDo question);

    int deleteQuestion(Integer questionId);

    int updateQuestion(QuestionDo question);

    QuestionDo getQuestion(Integer questionId);

    List<QuestionDo> listQuestionByUser(Integer userId);

    List<QuestionDo> listQuestionByTopic(Integer topicId);

    List<QuestionDo> listQuestion();

    int countQuestion();

    List<QuestionDo> listQuestionByPage(RowBounds rowBounds);
}
