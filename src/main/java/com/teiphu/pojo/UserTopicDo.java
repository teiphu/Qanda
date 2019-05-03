package com.teiphu.pojo;

/**
 * @Author Teiphu
 * @Creation 2019.05.02 下午 06:15
 **/
public class UserTopicDo {

    private Integer id;
    private UserDo user;
    private TopicDo topic;

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
}
