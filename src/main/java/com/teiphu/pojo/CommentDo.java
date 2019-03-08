package com.teiphu.pojo;

import java.sql.Timestamp;

/**
 * @Author Teiphu
 * @Creation 2019.03.08 下午 3:57
 **/
public class CommentDo {

    private int id;
    private int parentCommentId;
    private UserDo user;
    private AnswerDo answer;
    private String commentContent;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private int delete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(int parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public UserDo getUser() {
        return user;
    }

    public void setUser(UserDo user) {
        this.user = user;
    }

    public AnswerDo getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerDo answer) {
        this.answer = answer;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
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

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }
}
