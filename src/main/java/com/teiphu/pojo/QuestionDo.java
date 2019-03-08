package com.teiphu.pojo;

import java.sql.Timestamp;

/**
 * @Author Teiphu
 * @Creation 2019.03.08 下午 3:52
 **/
public class QuestionDo {

    private int id;
    private UserDo user;
    private TopicDo topic;
    private String content;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
