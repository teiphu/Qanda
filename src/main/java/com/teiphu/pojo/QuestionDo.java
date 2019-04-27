package com.teiphu.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Author Teiphu
 * @Date 2019.03.08 下午 3:52
 **/
public class QuestionDo implements Serializable {

    private Integer id;
    private UserDo user;
    private TopicDo topic;
    private String content;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private Integer status;

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
}
