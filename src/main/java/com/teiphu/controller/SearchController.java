package com.teiphu.controller;

import com.teiphu.pojo.QuestionDo;
import com.teiphu.service.QuestionService;
import com.teiphu.service.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Teiphu
 * @date 2019.05.29 下午 10:16
 **/
@Api("搜索控制器")
@RestController
@RequestMapping("/es")
public class SearchController {

    private final static Logger LOGGER = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    private SearchService searchService;

    @Autowired
    private QuestionService questionService;

    @ApiOperation("问题搜索")
    @RequestMapping(name = "search", method = RequestMethod.GET)
    public List<QuestionDo> searchQuestion(String searchContent, Integer page, Integer limit) {
        List<QuestionDo> questions = searchService.search(searchContent, page, limit);
        return questions;
    }

    @ApiOperation("建立索引")
    @RequestMapping(name = "indexing", method = RequestMethod.POST)
    public void indexing() {
        List<QuestionDo> questions = questionService.listAllQuestion();
        Iterable<QuestionDo> questionIterable = searchService.save(questions);
    }

}
