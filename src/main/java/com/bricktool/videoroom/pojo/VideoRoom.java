package com.bricktool.videoroom.pojo;


public class VideoRoom {
  private int id;
  private int userId;
  private String title;
  private int type;
  private int auditStatus;
  private int playStatus;
  private String videoUrl;
  private String snapshot;
  private String createdAt;
  private String updatedAt;

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
}
