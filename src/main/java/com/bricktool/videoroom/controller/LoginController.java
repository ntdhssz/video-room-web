package com.bricktool.videoroom.controller;

import com.bricktool.videoroom.dto.LoginDTO;
import com.bricktool.videoroom.service.LoginService;
import com.bricktool.videoroom.util.RestResult.ResultData;
import com.bricktool.videoroom.util.RestResult.ResultUtil;
import com.bricktool.videoroom.vo.LoginVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResultData login(@RequestBody LoginDTO loginDTO) {
        LoginVO loginVo = loginService.login(loginDTO);
        return ResultUtil.success(loginVo);
    }

    @GetMapping("/authLogin")
    public ResultData authLogin() {
        return ResultUtil.success();
    }
}
