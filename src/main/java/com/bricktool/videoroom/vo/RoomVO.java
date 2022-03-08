package com.bricktool.videoroom.vo;

import com.bricktool.videoroom.pojo.VideoRoom;

public class RoomVO {
    private int id;
    private int userId;
    private String nickName;
    private String title;
    private int type;
    private int chooseVideo;
    private String videoName;
    private String videoUrl;
    private String snapshot;
    private String createdDateTime;

    public RoomVO(VideoRoom videoRoom) {
        this.id = videoRoom.getId();
        this.userId = videoRoom.getUserId();
        this.nickName = videoRoom.getNickName();
        this.title = videoRoom.getTitle();
        this.type = videoRoom.getType();
        this.chooseVideo = videoRoom.getChooseVideo();
        this.videoName = videoRoom.getVideoName();
        this.videoUrl = videoRoom.getVideoUrl();
        this.snapshot = videoRoom.getSnapshot();
        this.createdDateTime = videoRoom.getCreatedDateTime();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getChooseVideo() {
        return chooseVideo;
    }

    public void setChooseVideo(int chooseVideo) {
        this.chooseVideo = chooseVideo;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getSnapshot() {
        return snapshot;
    }

    public void setSnapshot(String snapshot) {
        this.snapshot = snapshot;
    }

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
