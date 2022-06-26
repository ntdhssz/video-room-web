package com.bricktool.videoroom.pojo;


import com.bricktool.videoroom.dto.CreateRoomDTO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VideoRoom {
  private int id;
  private int userId;
  private String nickName;
  private String title;
  private int type;
  private String typeText;
  private int auditStatus;
  private int playStatus;
  private int chooseVideo;
  private String videoName;
  private String videoUrl;
  private String snapshot;
  private Date createdAt;
  private String createdDate;
  private String createdDateTime;
  private Date updatedAt;
  private Date watchTime;
  private String watchDate;
  private String watchDateTime;

  public VideoRoom() {

  }

  public VideoRoom(int userId, CreateRoomDTO createRoomDTO) {
    this.userId = userId;
    this.title = createRoomDTO.getTitle();
    this.type = createRoomDTO.getType();
    this.auditStatus = 1;
    this.playStatus = 1;
    this.chooseVideo = createRoomDTO.getChooseVideo();
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

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
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

  public String getTypeText() {
    switch (this.type) {
      case 0:
        this.typeText = "泛型";
        break;
      case 1:
        this.typeText = "电影";
        break;
      case 2:
        this.typeText = "动画";
        break;
    }
    return this.typeText;
  }

  public int getAuditStatus() {
    return auditStatus;
  }

  public void setAuditStatus(int auditStatus) {
    this.auditStatus = auditStatus;
  }

  public int getPlayStatus() {
    return playStatus;
  }

  public void setPlayStatus(int playStatus) {
    this.playStatus = playStatus;
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

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public String getCreatedDate() {
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    return dateFormatter.format(createdAt);
  }

  public String getCreatedDateTime() {
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return dateFormatter.format(createdAt);
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Date getWatchTime() {
    return watchTime;
  }

  public void setWatchTime(Date watchTime) {
    this.watchTime = watchTime;
  }

  public String getWatchDate() {
    if (watchTime != null) {
      SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
      return dateFormatter.format(watchTime);
    } else {
      return null;
    }
  }

  public String getWatchDateTime() {
    if (watchTime != null) {
      SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      return dateFormatter.format(watchTime);
    } else {
      return null;
    }
  }
}
