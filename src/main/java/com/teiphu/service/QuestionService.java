package com.teiphu.service;

import com.teiphu.pojo.QuestionDo;

import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:51
 **/
public interface QuestionService {

    int addQuestion(QuestionDo question);

    int deleteQuestion(Integer questionId);

    int updateQuestion(QuestionDo question);

    QuestionDo getQuestion(Integer questionId, Integer userId);

    List<QuestionDo> listQuestionByUser(Integer userId);

    List<QuestionDo> listQuestionByTopic(Integer topicId);

    List<QuestionDo> listQuestion();

    List<QuestionDo> listQuestionPaging(Integer page, Integer userId);

    List<QuestionDo> listAllQuestionPaging(Integer page, Integer userId);

    List<QuestionDo> listQuestionByPage(Integer num);

    List<QuestionDo> listQuestOfUserInterest();

    List<QuestionDo> listQuestionsAnswered(Integer userId);

    List<QuestionDo> searchQuestion(String searchContent);

    int addTopicToQuestion(Integer questionId, Integer[] topicStr);

    int deleteQuestionAttention(Integer questionId, Integer userId);

    int addQuestionAttention(Integer questionId, Integer userId);

    List<QuestionDo> listQuestionsByPagination(Integer page, Integer limit);

    int countQuestion();

    List<QuestionDo> listQuestionsByPaginationWithName(String searchText, Integer page, Integer limit);

    int countQuestionBySearch(String searchText);

    List<QuestionDo> listAllQuestion();
}
