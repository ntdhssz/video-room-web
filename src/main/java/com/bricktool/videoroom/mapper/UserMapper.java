package com.bricktool.videoroom.mapper;

import com.bricktool.videoroom.pojo.User;
import com.bricktool.videoroom.vo.RoomUserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    void insert(User user);
    User get(int id);
    List<User> getList();
    User getByLoginName(String loginName);
    List<User> searchByNickName(String nick_name);
    void updatePcToken(int id, String token);
    void updateMobileToken(int id, String token);
    RoomUserVO getRoomUser(int userId);
}
