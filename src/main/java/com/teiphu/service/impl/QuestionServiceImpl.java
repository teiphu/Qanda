package com.teiphu.service.impl;

import com.teiphu.mapper.AnswerMapper;
import com.teiphu.mapper.QuestionAttentionMapper;
import com.teiphu.mapper.QuestionMapper;
import com.teiphu.mapper.UpdownvoteMapper;
import com.teiphu.pojo.AnswerDo;
import com.teiphu.pojo.QuestionDo;
import com.teiphu.pojo.UpdownvoteDo;
import com.teiphu.service.QuestionService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.04.17 下午 09:53
 **/
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private AnswerMapper answerMapper;

    @Autowired
    private UpdownvoteMapper voteMapper;

    @Autowired
    private QuestionAttentionMapper questionAttentionMapper;

    @Override
    @Transactional(rollbackFor = {IOException.class})
    public int addQuestion(QuestionDo question) {
        return questionMapper.insertQuestion(question);
    }

    @Override
    @Transactional(rollbackFor = {IOException.class})
    public int deleteQuestion(Integer questionId) {
        answerMapper.deleteAnswerByQuestion(questionId);
        return questionMapper.deleteQuestion(questionId);
    }

    @Override
    @Transactional(rollbackFor = {IOException.class})
    public int updateQuestion(QuestionDo question) {
        return questionMapper.updateQuestion(question);
    }

    @Override
    public QuestionDo getQuestion(Integer questionId, Integer userId) {

        QuestionDo question = questionMapper.getQuestion(questionId);
        int num = questionAttentionMapper.getUserAttention(questionId, userId);
        int attention = questionAttentionMapper.getAttentionCount(questionId);
        question.setAttention(attention);
        if (num > 0) {
            question.setFollowStatus(1);
        } else {
            question.setFollowStatus(0);
        }
        question.setAnswers(answerMapper.listAnswerByQuestion(questionId));
        return question;
    }

    @Override
    public List<QuestionDo> listQuestionByUser(Integer userId) {
        return questionMapper.listQuestionByUser(userId);
    }

    @Override
    public List<QuestionDo> listQuestionByTopic(Integer topicId) {
        return questionMapper.listQuestionByTopic(topicId);
    }

    @Override
    public List<QuestionDo> listQuestion() {
        List<QuestionDo> questions = questionMapper.listQuestion();
        Iterator<QuestionDo> it = questions.iterator();
        while (it.hasNext()) {
            QuestionDo question = it.next();
            AnswerDo answer = answerMapper.getLatestAnswerByQuestion(question.getId());
            question.setAnswer(answer);
        }
        return questions;
    }

    @Override
    public List<QuestionDo> listQuestionPaging(Integer page, Integer userId) {
        int limit = 4;
        int offset = (page - 1) * limit;
        RowBounds rowBounds = new RowBounds(offset, limit);
        List<QuestionDo> questions = questionMapper.listQuestionPaging(rowBounds, userId);
        Iterator<QuestionDo> it = questions.iterator();
        while (it.hasNext()) {
            QuestionDo question = it.next();
            AnswerDo answer = answerMapper.getLatestAnswerByQuestion(question.getId());
            if (answer != null) {
                UpdownvoteDo vote = voteMapper.getUpdownvoteStatus(answer.getId(), userId);
                if (vote == null) {
                    answer.setVoteStatus(0);
                } else {
                    if (vote.getUpOrDown().intValue() == 1) {
                        answer.setVoteStatus(1);
                    } else {
                        answer.setVoteStatus(2);
                    }
                }
            } else {
                it.remove();
            }
            question.setAnswer(answer);
        }
        return questions;
    }

    @Override
    public List<QuestionDo> listAllQuestionPaging(Integer page, Integer userId) {
        int limit = 4;
        int offset = (page - 1) * limit;
        RowBounds rowBounds = new RowBounds(offset, limit);
        List<QuestionDo> questions = questionMapper.listAllQuestionPaging(rowBounds, userId);
        Iterator<QuestionDo> it = questions.iterator();
        while (it.hasNext()) {
            QuestionDo question = it.next();
            AnswerDo answer = answerMapper.getLatestAnswerByQuestion(question.getId());
            if (answer != null) {
                UpdownvoteDo vote = voteMapper.getUpdownvoteStatus(answer.getId(), userId);
                if (vote == null) {
                    answer.setVoteStatus(0);
                } else {
                    if (vote.getUpOrDown().intValue() == 1) {
                        answer.setVoteStatus(1);
                    } else {
                        answer.setVoteStatus(2);
                    }
                }
            }
            question.setAnswer(answer);
        }
        return questions;
    }

    @Override
    public List<QuestionDo> listQuestionByPage(Integer num) {
        int limit = 10;
        int offset = (num - 1) * limit;
        int total = questionMapper.countQuestion();
        RowBounds rowBounds = new RowBounds(offset, limit);
        List<QuestionDo> questions = questionMapper.listQuestionByPage(rowBounds);
        Iterator it = questions.iterator();
        while (it.hasNext()) {
            QuestionDo question = (QuestionDo) it.next();
            Integer questId = question.getId();
            List<AnswerDo> answers = answerMapper.listAnswerByQuestion(questId);
            question.setAnswers(answers);
        }
        return questions;
    }

    @Override
    public List<QuestionDo> listQuestOfUserInterest() {
        return questionMapper.listQuestOfUserInterest();
    }

    @Override
    public List<QuestionDo> listQuestionsAnswered(Integer userId) {
        List<QuestionDo> questions = questionMapper.listQuestionsAnswered(userId);
        Iterator<QuestionDo> it = questions.iterator();
        while (it.hasNext()) {
            QuestionDo question = it.next();
            AnswerDo answer = question.getAnswer();
            if (answer != null) {
                UpdownvoteDo vote = voteMapper.getUpdownvoteStatus(answer.getId(), userId);
                if (vote == null) {
                    answer.setVoteStatus(0);
                } else {
                    if (vote.getUpOrDown().intValue() == 1) {
                        answer.setVoteStatus(1);
                    } else {
                        answer.setVoteStatus(2);
                    }
                }
            }
        }
        return questions;
    }

    @Override
    public List<QuestionDo> searchQuestion(String searchContent) {
        StringBuilder sb = new StringBuilder();
        sb.append('%');
        for (int i = 0; i < searchContent.length(); i++) {
            sb.append(searchContent.charAt(i));
            sb.append('%');
        }
        String content = sb.toString();
        List<QuestionDo> questions = questionMapper.listQuestionBySearch(content);
        return questions;
    }

    @Override
    public int addTopicToQuestion(Integer questionId, Integer[] topicStr) {
        int res = 0;
        /*Integer[] topicIds = StringUtils.stringToIntegerArray(topicStr);*/
        Integer[] topicIds = topicStr;
        if (topicIds != null && topicIds.length > 0) {
            List<Integer> topicIdList = Arrays.asList(topicIds);
            res = questionMapper.addTopicToQuestion(questionId, topicIdList);
        }
        return res;
    }

    @Override
    public int deleteQuestionAttention(Integer questionId, Integer userId) {
        return questionAttentionMapper.deleteQuestionAttention(questionId, userId);
    }

    @Override
    public int addQuestionAttention(Integer questionId, Integer userId) {
        return questionAttentionMapper.addQuestionAttention(questionId, userId);
    }

    @Override
    public List<QuestionDo> listQuestionsByPagination(Integer page, Integer limit) {
        int offset = (page - 1) * limit;
        RowBounds rowBounds = new RowBounds(offset, limit);
        List<QuestionDo> questions = questionMapper.listQuestionsByPagination(rowBounds);
        return questions;
    }

    @Override
    public int countQuestion() {
        return questionMapper.countQuestion();
    }

    @Override
    public List<QuestionDo> listQuestionsByPaginationWithName(String content, Integer page, Integer limit) {
        content = '%' + content + '%';
        int offset = (page - 1) * limit;
        RowBounds rowBounds = new RowBounds(offset, limit);
        List<QuestionDo> questions = questionMapper.listQuestionsByPaginationWithName(content, rowBounds);
        return questions;
    }

    @Override
    public int countQuestionBySearch(String searchText) {
        searchText = '%' + searchText + '%';
        return questionMapper.countQuestionBySearch(searchText);
    }

}
