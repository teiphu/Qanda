package com.teiphu.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Author Teiphu
 * @Date 2019.03.08 下午 3:55
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnswerDo implements Serializable {

    private Integer id;
    private UserDo user;
    private QuestionDo question;
    private String answerContent;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;

    public AnswerDo() {
    }

    public AnswerDo(Integer answerId) {
        this.id = answerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDo getUser() {
        return user;
    }

    public void setUser(UserDo user) {
        this.user = user;
    }

    public QuestionDo getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDo question) {
        this.question = question;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }
}
