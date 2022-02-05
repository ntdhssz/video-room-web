package com.bricktool.videoroom.dto;

public class LogoutDTO {
    private int id;
    private String token;
    private String agent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String loginName) {
        this.token = token;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }
}
