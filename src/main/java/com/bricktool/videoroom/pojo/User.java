package com.bricktool.videoroom.pojo;

public class User {
    private int id;
    private String loginName;
    private String nickName;
    private String password;
    private String pcToken;
    private String mobileToken;
    private String avatar;
    private short status;
    private String createdAt;
    private String updatedAt;

    public User() {

    }

    public User(String loginName, String nickName, String password) {
        this.loginName = loginName;
        this.nickName = nickName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPcToken() {
        return pcToken;
    }

    public void setPcToken(String pcToken) {
        this.pcToken = pcToken;
    }

    public String getMobileToken() {
        return mobileToken;
    }

    public void setMobileToken(String mobileToken) {
        this.mobileToken = mobileToken;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getStatusText() {
        String statusText;
        switch (this.status) {
            case 0:
                statusText = "审核中";
                break;
            case 1:
                statusText = "正常";
                break;
            case 2:
                statusText = "封禁";
                break;
            default:
                statusText = "未知";
        }
        return statusText;
    }
}
