package com.teiphu.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 问题关注
 * @Author Teiphu
 * @Creation 2019.05.20 上午 03:50
 **/
public class QuestionAttentionDo implements Serializable {

    private Integer id;

    private Integer questionId;

    private Integer userId;

    private Timestamp gmtCreate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}
