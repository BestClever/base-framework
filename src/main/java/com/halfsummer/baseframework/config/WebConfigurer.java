package com.halfsummer.baseframework.config;

import com.halfsummer.baseframework.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * @author BestClever
 * @title: WebConfigurer
 * @projectName base-framework
 * @description: TODO
 * @date 2020-05-23 23:36
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    private static List<String> EXCLUDE_PATH = Arrays.asList("/","/login/login","/erro","/templates/**","/css/**","/js/**","/lib/**","/images/**","/assets/**","/component/**","/login.html","/index.html","/pages/**","/data/**","/favicon.ico","/gen/**");

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(EXCLUDE_PATH);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //默认地址（可以是页面或后台请求接口）
        registry.addViewController("/").setViewName("redirect:/login.html");
        //设置过滤优先级最高
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
