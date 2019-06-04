package com.teiphu.service.impl;

import com.teiphu.es.QuestionRepository;
import com.teiphu.pojo.QuestionDo;
import com.teiphu.service.SearchService;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Teiphu
 * @date 2019.05.29 下午 11:06
 **/
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<QuestionDo> search(String searchContent, Integer page, Integer limit) {
        SearchQuery searchQuery = getLogSearchQuery(page, limit, searchContent);
//        Page<QuestionDo> questionPage = questionRepository.search(searchQuery);
        Page<QuestionDo> questionPage = pageQuery(page, limit, searchContent);
        return questionPage.getContent();
    }

    @Override
    public Iterable<QuestionDo> save(List<QuestionDo> questions) {
        Iterable<QuestionDo> questionIterable = questionRepository.saveAll(questions);
        return questionIterable;
    }

    /**
     * 根据搜索词构造搜索查询语句
     * 代码流程：
     * - 精确查询
     * - 模糊查询
     * - 排序查询
     * - 设置分页参数
     *
     * @param page          当前页码
     * @param size          每页大小
     * @param searchContent 搜索内容
     * @return
     */
    private SearchQuery getLogSearchQuery(Integer page, Integer size, String searchContent) {
        //创建builder
        BoolQueryBuilder builder = QueryBuilders.boolQuery();

         /*must
         所有的语句都 必须（must） 匹配，与 AND 等价。
         must_not
         所有的语句都 不能（must not） 匹配，与 NOT 等价。
         should
         至少有一个语句要匹配，与 OR 等价。
         trem
         精确查找 与= 号等价。
         match
         模糊匹配 与like 等价。*/

        //设置多字段组合模糊搜索
        if (StringUtils.isNotBlank(searchContent)) {
            builder.must(QueryBuilders.multiMatchQuery(searchContent, "content"));
        }
        //设置排序
        FieldSortBuilder sort = SortBuilders.fieldSort("id").order(SortOrder.DESC);
        //设置分页
        //Pageable pageable = new PageRequest(page, size);
        Pageable pageable = PageRequest.of(page, size);
        return new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(builder)
                .withSort(sort)
                .build();
    }

    private Page<QuestionDo> pageQuery(Integer page, Integer size, String searchContent) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchPhraseQuery("content", searchContent))
                .withPageable(PageRequest.of(page, size))
                .build();
        return questionRepository.search(searchQuery);
    }
}

