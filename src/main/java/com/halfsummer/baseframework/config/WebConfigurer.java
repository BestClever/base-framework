package com.halfsummer.baseframework.config;

import com.halfsummer.baseframework.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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

    private static List<String> EXCLUDE_PATH = Arrays.asList("/","/login/login","/erro","/templates/**","/css/**","/js/**","/lib/**","/images/**","/login.html","/index.html","/pages/**","/data/**","/favicon.ico");

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(EXCLUDE_PATH);
    }
}
