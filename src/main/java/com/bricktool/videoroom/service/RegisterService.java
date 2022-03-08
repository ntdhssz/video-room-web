package com.bricktool.videoroom.service;

import com.bricktool.videoroom.dto.RegisterDTO;
import com.bricktool.videoroom.pojo.User;
import com.bricktool.videoroom.service.database.UserServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private final UserServiceImpl userService;

    public RegisterService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void register(RegisterDTO registerDTO) {
        User newUser = new User(registerDTO);
        userService.insert(newUser);
    }

    public Boolean loginNameCheck(String loginName) {
        User user = userService.getByLoginName(loginName);
        return user != null;
    }
}
