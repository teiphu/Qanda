package com.teiphu;

import com.teiphu.controller.UserController;
import com.teiphu.mapper.AnswerMapper;
import com.teiphu.pojo.AnswerDo;
import com.teiphu.pojo.UserDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Author Teiphu
 * @Creation 2019.05.20 下午 12:28
 **/
public class NoticeTask implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoticeTask.class);

    private UserDo user;

    @Autowired
    private AnswerMapper answerMapper;

    public NoticeTask(UserDo user) {
        this.user = user;
    }

    @Override
    public void run() {
        Integer userId = user.getId();
        Timestamp gmtLogout = user.getGmtLogout();
        Timestamp recentTime = new Timestamp(System.currentTimeMillis() - 4*1000);
        LOGGER.info(recentTime.toString());
        List<AnswerDo> answerList = answerMapper.listNewAnswer(userId, recentTime);
        user.getAnswers().addAll(answerList);

    }

}
