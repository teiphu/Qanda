package com.teiphu.pojo;

import java.sql.Timestamp;

/**
 * @Author Teiphu
 * @Creation 2019.03.08 下午 4:04
 **/
public class UpdownvoteDo {

    private int id;
    private CommentDo comment;
    private AnswerDo answer;
    private UserDo sender;
    private UserDo receiver;
    private int upOrDown;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getUpOrDown() {
        return upOrDown;
    }

    public void setUpOrDown(int upOrDown) {
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
