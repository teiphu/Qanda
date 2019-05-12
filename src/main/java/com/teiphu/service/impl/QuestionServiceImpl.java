package com.teiphu.service.impl;

import com.teiphu.mapper.AnswerMapper;
import com.teiphu.mapper.QuestionMapper;
import com.teiphu.pojo.AnswerDo;
import com.teiphu.pojo.QuestionDo;
import com.teiphu.service.QuestionService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
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

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int addQuestion(QuestionDo question) {
        return questionMapper.insertQuestion(question);
    }

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int deleteQuestion(Integer questionId) {
        answerMapper.deleteAnswerByQuestion(questionId);
        return questionMapper.deleteQuestion(questionId);
    }

    @Override
    @Transactional(rollbackFor = { IOException.class })
    public int updateQuestion(QuestionDo question) {
        return questionMapper.updateQuestion(question);
    }

    @Override
    public QuestionDo getQuestion(Integer questionId) {
        QuestionDo question = questionMapper.getQuestion(questionId);
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
    public List<QuestionDo> listQuestionPaging(Integer page) {
        int limit = 4;
        int offset = (page - 1) * limit;
        RowBounds rowBounds = new RowBounds(offset, limit);
        List<QuestionDo> questions = questionMapper.listQuestionPaging(rowBounds);
        Iterator<QuestionDo> it = questions.iterator();
        while (it.hasNext()) {
            QuestionDo question = it.next();
            AnswerDo answer = answerMapper.getLatestAnswerByQuestion(question.getId());
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
        return questionMapper.listQuestionsAnswered(userId);
    }
}
