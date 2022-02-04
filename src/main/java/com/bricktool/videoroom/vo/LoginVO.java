package com.bricktool.videoroom.vo;

import com.bricktool.videoroom.pojo.User;

public class LoginVO {
    private int id;
    private String nickName;
    private String token;
    private String avatar;

    public LoginVO() {};

    public LoginVO(User user) {
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
