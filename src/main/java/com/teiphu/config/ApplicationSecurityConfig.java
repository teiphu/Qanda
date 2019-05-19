package com.teiphu.config;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author Teiphu
 * @Creation 2019.05.18 下午 11:54
 **/
//@Configuration
//@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    /*@Autowired
    private DefaultUserDetailService userDetailService;

    @Autowired
    private SessionRegistry sessionRegistry;*/

    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                *//*return super.encode(rawPassword);*//*
                return DigestUtils.md5Hex(rawPassword.toString());
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                String loginPassword = encode(DigestUtils.md5Hex(rawPassword.toString()));
                return loginPassword.equals(encodedPassword);
            }
        };
    }*/

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/reg/register", "/question/retrieveQuestions").permitAll()
                .and().formLogin().loginPage("/user/login").defaultSuccessUrl("/question/retrieveQuestions").permitAll()
                .and().logout().logoutUrl("/user/logout");*/
                //.and().sessionManagement().maximumSessions(1).sessionRegistry(sessionRegistry).maxSessionsPreventsLogin(true)

        /*http.authorizeRequests()
                .antMatchers("/admin/**", "/topic/**").hasRole("admin") //ROLE_
                .antMatchers("/user/**").hasAnyRole("admin", "normal")
                .antMatchers("/reg/**", "/reg/register").permitAll()
                .anyRequest().authenticated();*/
        /*http.authorizeRequests()
                .antMatchers("/bootstrap/**", "/common/**", "/css/**", "/img/**", "/js/**", "/layer/**");*/
        /*"/answer/**", "/comment/**", "/question/**", "/topic/**", "/updownvote/**", "/user/**"*/
        //.loginPage("/user/login")
        /*http.formLogin()
                .loginPage("/user/signin")
                .defaultSuccessUrl("/question/retrieveQuestions")
                *//*.failureUrl("/user/login")*//*
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/user/logout")
                .logoutSuccessUrl("/user/signin")
                .permitAll();*/

    /*}*/

    /*@Override
    public void configure(WebSecurity web) throws Exception {*/
        /*web.ignoring().antMatchers("/static/**");*/
        /*web.ignoring().antMatchers("/resources/**");*/
//        , "/reg/**"
        //web.ignoring().antMatchers("/**/*.js", "/**/*.css", "/**/*.map", "/**/*.html", "/**/*.png", "/**/*.jpg", "/**/*.svg");
    /*}*/
}
