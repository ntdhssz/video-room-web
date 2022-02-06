package com.bricktool.videoroom.controller;

import com.bricktool.videoroom.dto.LoginDTO;
import com.bricktool.videoroom.dto.LogoutDTO;
import com.bricktool.videoroom.service.LoginService;
import com.bricktool.videoroom.util.RestResult.ResultData;
import com.bricktool.videoroom.util.RestResult.ResultUtil;
import com.bricktool.videoroom.vo.LoginVO;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResultData login(HttpServletRequest request, @RequestBody LoginDTO loginDTO) {
        loginDTO.setAgent(request.getHeader("agent"));
        LoginVO loginVO = loginService.login(loginDTO);
        return ResultUtil.success(loginVO);
    }

    @PostMapping("/logout")
    public ResultData logout(HttpServletRequest request, @RequestBody LogoutDTO logoutDTO) {
        logoutDTO.setAgent(request.getHeader("agent"));
        loginService.logout(logoutDTO);
        return ResultUtil.success();
    }

    @PostMapping("/authLogin")
    public ResultData authLogin(HttpServletRequest request) {
        LoginVO loginVO = new LoginVO();
        loginVO.setId((int) request.getAttribute("uid"));
        loginVO.setNickName((String) request.getAttribute("user_nick_name"));
        loginVO.setToken(request.getHeader("token"));
        loginVO.setAvatar((String) request.getAttribute("user_avatar"));
        return ResultUtil.success(loginVO);
    }
}
