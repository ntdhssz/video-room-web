package com.bricktool.videoroom.service;

import com.bricktool.videoroom.dto.LoginDTO;
import com.bricktool.videoroom.dto.LogoutDTO;
import com.bricktool.videoroom.exception.BusinessException;
import com.bricktool.videoroom.exception.BusinessExceptionCode;
import com.bricktool.videoroom.pojo.User;
import com.bricktool.videoroom.util.Redis.RedisKey;
import com.bricktool.videoroom.util.Redis.RedisUtil;
import com.bricktool.videoroom.vo.LoginVO;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Calendar;

@Service
public class LoginService {
    private final UserServiceImpl userService;
    private final RedisUtil redisUtil;

    public LoginService(UserServiceImpl userService, RedisUtil redisUtil) {
        this.userService = userService;
        this.redisUtil = redisUtil;
    }

    public LoginVO login(LoginDTO loginDTO) {
        String loginName = loginDTO.getLoginName();
        String password = loginDTO.getPassword();
        String agent = loginDTO.getAgent();
        if (agent == null) {
            throw new BusinessException(BusinessExceptionCode.ILLEGAL_AGENT);
        }

        User user = userService.getByLoginName(loginName);

        if (user == null) {
            throw new BusinessException(BusinessExceptionCode.NULL_USER);
        }

        String md5Str = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!md5Str.equals(user.getPassword())) {
            throw new BusinessException(BusinessExceptionCode.ERROR_PASSWORD);
        }

        userService.checkUserStatus(user.getStatus());

        String newToken = DigestUtils.md5DigestAsHex(
                (loginName + Calendar.getInstance().getTime()).getBytes());
        LoginVO loginVo = new LoginVO(user);
        loginVo.setToken(newToken);
        String tokenKey;
        String oldToken;
        if (agent.equals("pc")) {
            tokenKey = RedisKey.PC_USER_TOKEN.getKey();
            oldToken = user.getPcToken();
            userService.updatePcToken(user.getId(), newToken);
        } else {
            tokenKey = RedisKey.MOBILE_USER_TOKEN.getKey();
            oldToken = user.getMobileToken();
            userService.updateMobileToken(user.getId(), newToken);
        }
        redisUtil.del(tokenKey + oldToken);
        redisUtil.set(tokenKey + newToken, user.getId());

        return loginVo;
    }

    public void logout(LogoutDTO logoutDTO) {
        int id = logoutDTO.getId();
        String token = logoutDTO.getToken();
        String agent = logoutDTO.getAgent();
        if (agent.equals("pc")) {
            String tokenKey = RedisKey.PC_USER_TOKEN.getKey() + token;
            redisUtil.del(tokenKey);
            userService.updatePcToken(id, null);
        } else {
            String tokenKey = RedisKey.MOBILE_USER_TOKEN.getKey() + token;
            redisUtil.del(tokenKey);
            userService.updateMobileToken(id, null);
        }
    }
}
