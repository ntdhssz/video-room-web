package com.bricktool.videoroom.exception;

public enum BusinessExceptionCode {
    NOT_PASS_USER(30001, "账户还未通过审核"),
    BANNED_USER(30002, "账户已被封禁"),
    ERROR_PASSWORD(30003, "用户名或密码错误"),
    ILLEGAL_TOKEN(30004, "非法token"),
    LOGIN_TIMEOUT(30005, "登录过期"),
    ILLEGAL_AGENT(30006, "非法设备端口"),
    NULL_USER(40001, "账户不存在"),
    NOT_LOGIN(40002, "未登录"),
    NOT_USER(40003, "用户不存在"),
    UNKNOWN_STATUS(50001, "账户处于未知状态"),
    ROOM_NOT_ALLOW_ENTER(50002, "房间不允许进入");

    private int code;
    private String message;

    private BusinessExceptionCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getValue() {
        return code;
    }

    public void setValue(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return "[" + this.code + "]" + this.message;
    }
}
