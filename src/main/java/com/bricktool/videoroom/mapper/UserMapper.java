package com.bricktool.videoroom.mapper;

import com.bricktool.videoroom.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper
{
    List<User> getList();
    User get(int id);
    User getByLoginName(String loginName);
    List<User> searchByNickName(String nick_name);
    void updatePcToken(int id, String token);
    void updateMobileToken(int id, String token);
}
