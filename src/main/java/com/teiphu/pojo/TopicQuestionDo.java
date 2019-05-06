package com.teiphu.pojo;

import java.io.Serializable;

/**
 * @Author Teiphu
 * @Creation 2019.05.07 上午 01:31
 **/
public class TopicQuestionDo implements Serializable {

    private Integer id;
    private Integer topicId;
    private Integer questionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
}
