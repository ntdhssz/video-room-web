package com.bricktool.videoroom.config;

import com.bricktool.videoroom.interceptor.AuthInterceptor;
import com.bricktool.videoroom.service.UserServiceImpl;
import com.bricktool.videoroom.util.Redis.RedisUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    private final RedisUtil redisUtil;
    private final UserServiceImpl userService;

    public InterceptorConfig(RedisUtil redisUtil, UserServiceImpl userService) {
        this.redisUtil = redisUtil;
        this.userService = userService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor(this.redisUtil, this.userService)).addPathPatterns("/**")
                .excludePathPatterns("/login");
    }
}
