package com.bricktool.videoroom.vo;

import com.bricktool.videoroom.pojo.User;

public class RoomUserVO {
    int id;
    String nickName;
    String avatar;

    public RoomUserVO(User user) {
        this.id = user.getId();
        this.nickName = user.getNickName();
        this.avatar = user.getAvatar();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
