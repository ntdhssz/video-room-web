package com.bricktool.videoroom.service.database;

import com.bricktool.videoroom.pojo.User;
import com.bricktool.videoroom.vo.RoomUserVO;

import java.util.List;

public interface UserService
{
    void insert(User user);
    User get(int id);
    List<User> getList();
    User getByLoginName(String loginName);
    List<User> searchByNickName(String nick_name);
    void updatePcToken(int id, String token);
    void updateMobileToken(int id, String token);
}
