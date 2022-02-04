package com.bricktool.videoroom.util.Redis;

public enum RedisKey {
    PC_USER_TOKEN("video_room:user_token:pc:"),
    MOBILE_USER_TOKEN("video_room:user_token:mobile:");

    private String key;

    private RedisKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
