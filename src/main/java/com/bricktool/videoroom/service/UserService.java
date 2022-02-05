package com.bricktool.videoroom.service;

import com.bricktool.videoroom.pojo.User;

import java.util.List;

public interface UserService
{
    User get(int id);
    List<User> getList();
    User getByLoginName(String loginName);
    List<User> searchByNickName(String nick_name);
    void updatePcToken(int id, String token);
    void updateMobileToken(int id, String token);
}
