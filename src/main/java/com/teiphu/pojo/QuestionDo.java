package com.teiphu.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Author Teiphu
 * @Date 2019.03.08 下午 3:52
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionDo implements Serializable {

    private Integer id;
    private UserDo user;
    private String username;
    private TopicDo topic;
    private String content;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private Integer status;

    private Integer followStatus;

    private Integer attention;

    private AnswerDo answer;

    private List<AnswerDo> answers;

    public List<AnswerDo> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDo> answers) {
        this.answers = answers;
    }

    public QuestionDo() {
    }

    public QuestionDo(Integer questId) {
        this.id = questId;
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

    public TopicDo getTopic() {
        return topic;
    }

    public void setTopic(TopicDo topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public AnswerDo getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerDo answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "QuestionDo{" +
                "id=" + id +
                ", user=" + user +
                ", topic=" + topic +
                ", content='" + content + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", status=" + status +
                ", answer=" + answer +
                ", answers=" + answers +
                '}';
    }

    public Integer getFollowStatus() {
        return followStatus;
    }

    public void setFollowStatus(Integer followStatus) {
        this.followStatus = followStatus;
    }

    public Integer getAttention() {
        return attention;
    }

    public void setAttention(Integer attention) {
        this.attention = attention;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
