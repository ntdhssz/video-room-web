package com.bricktool.videoroom.interceptor;

import com.bricktool.videoroom.exception.BusinessException;
import com.bricktool.videoroom.exception.BusinessExceptionCode;
import com.bricktool.videoroom.pojo.User;
import com.bricktool.videoroom.service.UserServiceImpl;
import com.bricktool.videoroom.util.Redis.RedisKey;
import com.bricktool.videoroom.util.Redis.RedisUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthInterceptor implements HandlerInterceptor {
    private final RedisUtil redisUtil;
    private final UserServiceImpl userService;

    public AuthInterceptor(RedisUtil redisUtil, UserServiceImpl userService) {
        this.redisUtil = redisUtil;
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws IOException {
        String token = request.getHeader("token");
        String agent = request.getHeader("agent");
        if (token == null) {
            throw new BusinessException(BusinessExceptionCode.NOT_LOGIN);
        }

        if (agent == null) {
            throw new BusinessException(BusinessExceptionCode.ILLEGAL_AGENT);
        }

        String tokenKey;
        if (agent.equals("mobile")) {
            tokenKey = RedisKey.MOBILE_USER_TOKEN.getKey() + token;
        } else if (agent.equals("pc")) {
            tokenKey = RedisKey.PC_USER_TOKEN.getKey() + token;
        } else {
            throw new BusinessException(BusinessExceptionCode.ILLEGAL_AGENT);
        }
        Object tokenInfo = redisUtil.get(tokenKey);
        if (tokenInfo == null) {
            throw new BusinessException(BusinessExceptionCode.ILLEGAL_TOKEN);
        }

        int userId = (int) tokenInfo;
        User user = userService.get(userId);
        String serverToken;
        if (agent.equals("mobile")) {
            serverToken = user.getMobileToken();
        } else {
            serverToken = user.getPcToken();
        }
        if (!token.equals(serverToken)) {
            throw new BusinessException(BusinessExceptionCode.LOGIN_TIMEOUT);
        }

        userService.checkUserStatus(user.getStatus());

        System.out.println(user.getId());
        request.setAttribute("id", user.getId());
        request.setAttribute("nick_name", user.getNickName());
        request.setAttribute("avatar", user.getAvatar());

        return true;
    }
}