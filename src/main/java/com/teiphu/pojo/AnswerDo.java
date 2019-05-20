package com.teiphu.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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

    private Integer upvoteCount;

    private List<CommentDo> comments;

    public Integer getVoteStatus() {
        return voteStatus;
    }

    public void setVoteStatus(Integer voteStatus) {
        this.voteStatus = voteStatus;
    }

    private Integer voteStatus;

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

    public Integer getUpvoteCount() {
        return upvoteCount;
    }

    public void setUpvoteCount(Integer upvoteCount) {
        this.upvoteCount = upvoteCount;
    }

    public List<CommentDo> getComments() {
        return comments;
    }

    public void setComments(List<CommentDo> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerDo answerDo = (AnswerDo) o;
        return Objects.equals(id, answerDo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
