package com.teiphu.pojo;

import java.sql.Timestamp;

/**
 * @Author Teiphu
 * @Creation 2019.03.08 下午 3:50
 **/
public class TopicDo {

    private int id;
    private UserDo user;
    private String topicName;
    private String topicDetail;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;

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

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicDetail() {
        return topicDetail;
    }

    public void setTopicDetail(String topicDetail) {
        this.topicDetail = topicDetail;
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
