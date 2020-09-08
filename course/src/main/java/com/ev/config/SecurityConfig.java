package com.ev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/courses").hasAnyRole("student","admin")
                .antMatchers("/toInfo").hasAnyRole("student","admin")
                .antMatchers("/studentList").hasRole("admin")
                .antMatchers("/addCourse/**","/updateCourse/**","/deleteCourse/**").hasRole("admin");

        //定制登录页 loginPage
        http.formLogin().loginPage("/toLogin");

        //注销
        http.csrf().disable();  //关闭csrf功能，解决注销失败
        http.logout().logoutSuccessUrl("/");

        //记住我 cookie
        http.rememberMe().rememberMeParameter("remember");
    }

    @Bean  //注入PasswordEncode
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
