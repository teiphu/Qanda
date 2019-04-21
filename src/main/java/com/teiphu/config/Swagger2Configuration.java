package com.teiphu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author： xiaoming
 */
@Configuration
public class Swagger2Configuration {

    /**
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.teiphu.controller")).paths(PathSelectors.any())
                .build();
    }

    /**
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("在线问答社区的API文档").description("在线问答社区利用Swagger构建API文档")
                .termsOfServiceUrl("termsOfServiceUrl").version("1.0").build();
    }
}
