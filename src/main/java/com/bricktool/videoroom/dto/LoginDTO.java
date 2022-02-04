package com.bricktool.videoroom.dto;

public class LoginDTO {
    private String loginName;
    private String password;
    private int phoneLogin;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhoneLogin() {
        return phoneLogin;
    }

    public void setPhoneLogin(int phoneLogin) {
        this.phoneLogin = phoneLogin;
    }
}
