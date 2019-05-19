package com.teiphu.config;

import com.teiphu.Interceptor.SecurityInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author Teiphu
 * @Creation 2019.05.20 上午 02:05
 **/
@Configuration
public class MVCConfig extends WebMvcConfigurerAdapter {

    @Bean
    public SecurityInterceptor securityInterceptor() {
        return new SecurityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(securityInterceptor()).excludePathPatterns("/static/**")
                .excludePathPatterns("/error").addPathPatterns("/**");
    }
}
