package com.teiphu.es;

import com.teiphu.pojo.QuestionDo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @Author Teiphu
 * @date 2019.05.29 下午 10:02
 **/
@Component
public interface QuestionRepository extends ElasticsearchRepository<QuestionDo, Integer> {

}
