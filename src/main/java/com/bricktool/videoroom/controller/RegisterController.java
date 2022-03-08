package com.bricktool.videoroom.controller;

import com.alibaba.fastjson.JSON;
import com.bricktool.videoroom.dto.RegisterDTO;
import com.bricktool.videoroom.service.RegisterService;
import com.bricktool.videoroom.util.RestResult.ResultData;
import com.bricktool.videoroom.util.RestResult.ResultUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {
    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping
    public ResultData register(@RequestBody RegisterDTO registerDTO) {
        System.out.println(JSON.toJSONString(registerDTO));
        registerService.register(registerDTO);
        return ResultUtil.success();
    }

    @GetMapping("/login-name-check")
    public ResultData loginNameCheck(@RequestParam(value = "login_name") String loginName) {
        return ResultUtil.success(registerService.loginNameCheck(loginName));
    }
}
