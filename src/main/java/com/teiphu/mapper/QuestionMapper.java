package com.teiphu.mapper;

import com.teiphu.pojo.QuestionDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    List<QuestionDo> listQuestOfUserInterest();

    List<QuestionDo> listQuestionsAnswered(Integer userId);

    List<QuestionDo> listQuestionPaging(RowBounds rowBounds, Integer userId);

    List<QuestionDo> listQuestionBySearch(String searchContent);

    int addTopicToQuestion(@Param("questionId") Integer questionId, @Param("topicIds") List<Integer> topicIds);

    List<QuestionDo> listQuestionsByPagination(RowBounds rowBounds);

    List<QuestionDo> listQuestionsByPaginationWithName(String content, RowBounds rowBounds);

    int countQuestionBySearch(String searchText);
}
