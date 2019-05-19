package com.teiphu.mapper;

import org.apache.ibatis.annotations.Mapper;

import javax.jnlp.IntegrationService;

/**
 * @Author Teiphu
 * @Creation 2019.05.20 上午 04:02
 **/
@Mapper
public interface QuestionAttentionMapper {

    int getAttentionCount(Integer questionId);

    int getUserAttention(Integer questionId, Integer userId);

    int deleteQuestionAttention(Integer questionId, Integer userId);

    int addQuestionAttention(Integer questionId, Integer userId);
}
