package com.bricktool.videoroom.service;

import com.bricktool.videoroom.exception.BusinessException;
import com.bricktool.videoroom.exception.BusinessExceptionCode;
import com.bricktool.videoroom.mapper.UserMapper;
import com.bricktool.videoroom.pojo.User;
import com.bricktool.videoroom.vo.RoomUserVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getList() {
        return userMapper.getList();
    }

    @Override
    public User get(int id) {
        return userMapper.get(id);
    }

    @Override
    public User getByLoginName(String loginName) {
        return userMapper.getByLoginName(loginName);
    }

    @Override
    public List<User> searchByNickName(String nick_name) {
        return userMapper.searchByNickName(nick_name);
    }

    @Override
    public void updatePcToken(int id, String token) {
        userMapper.updatePcToken(id, token);
    }

    @Override
    public void updateMobileToken(int id, String token) {
        userMapper.updateMobileToken(id, token);
    }

    public void checkUserStatus(int status) {
        switch (status) {
            case 0:
                throw new BusinessException(BusinessExceptionCode.NOT_PASS_USER);
            case 1:
                break;
            case 2:
                throw new BusinessException(BusinessExceptionCode.BANNED_USER);
            default:
                throw new BusinessException(BusinessExceptionCode.UNKNOWN_STATUS);
        }
    }

    public RoomUserVO getRoomUser(int userId) {
        return userMapper.getRoomUser(userId);
    }
}
