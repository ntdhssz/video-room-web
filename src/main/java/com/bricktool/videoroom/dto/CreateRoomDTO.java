package com.bricktool.videoroom.dto;

public class CreateRoomDTO {
    private String title;
    private int type;
    private int chooseVideo;
    private String videoName;
    private String videoUrl;

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
}
