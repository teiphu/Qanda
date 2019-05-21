package com.teiphu;

import com.teiphu.controller.UserController;
import com.teiphu.mapper.AnswerMapper;
import com.teiphu.pojo.AnswerDo;
import com.teiphu.pojo.UserDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Teiphu
 * @Creation 2019.05.20 下午 12:28
 **/
public class NoticeTask implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoticeTask.class);

    private UserDo user;

    private AnswerMapper answerMapper;

    public Set<AnswerDo> answers = new HashSet<>();

    public NoticeTask(UserDo user, AnswerMapper answerMapper) {
        this.user = user;
        this.answerMapper = answerMapper;
    }

    @Override
    public void run() {
        Integer userId = user.getId();
        LOGGER.info("UserId: " + userId + ", " + Thread.currentThread().getId());
        Timestamp gmtLogout = user.getGmtLogout();
        LOGGER.info(new Timestamp(System.currentTimeMillis()).toString());
        Timestamp recentTime = new Timestamp(System.currentTimeMillis() - 4 * 1000);
        LOGGER.info(recentTime.toString());
        List<AnswerDo> answerList = answerMapper.listNewAnswer(userId, recentTime);
        /*user.getAnswers().addAll(answerList);*/
        answers.addAll(answerList);
    }

    public UserDo getUser() {
        return user;
    }

    public void setUser(UserDo user) {
        this.user = user;
    }

}
