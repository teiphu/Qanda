package com.teiphu.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Author Teiphu
 * @Date 2019.03.08 下午 4:04
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdownvoteDo implements Serializable {

    private Integer id;
    private CommentDo comment;
    private AnswerDo answer;
    private UserDo sender;
    private UserDo receiver;
    private Integer upOrDown;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;

    public UpdownvoteDo() {
    }

    public UpdownvoteDo(AnswerDo answer, UserDo sender, UserDo receiver, Integer upOrDown) {
        this.answer = answer;
        this.sender = sender;
        this.receiver = receiver;
        this.upOrDown = upOrDown;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CommentDo getComment() {
        return comment;
    }

    public void setComment(CommentDo comment) {
        this.comment = comment;
    }

    public AnswerDo getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerDo answer) {
        this.answer = answer;
    }

    public UserDo getSender() {
        return sender;
    }

    public void setSender(UserDo sender) {
        this.sender = sender;
    }

    public UserDo getReceiver() {
        return receiver;
    }

    public void setReceiver(UserDo receiver) {
        this.receiver = receiver;
    }

    public Integer getUpOrDown() {
        return upOrDown;
    }

    public void setUpOrDown(Integer upOrDown) {
        this.upOrDown = upOrDown;
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
