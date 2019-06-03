package com.teiphu.service;

import com.teiphu.pojo.QuestionDo;

import java.util.List;

/**
 * @Author Teiphu
 * @date 2019.05.29 下午 11:05
 **/
public interface SearchService {

    List<QuestionDo> search(String searchContent, Integer page, Integer limit);

    Iterable<QuestionDo> save(List<QuestionDo> questions);
}
