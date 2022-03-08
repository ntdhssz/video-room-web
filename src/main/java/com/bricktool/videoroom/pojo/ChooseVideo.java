package com.bricktool.videoroom.pojo;

import com.bricktool.videoroom.dto.CreateRoomDTO;
import com.bricktool.videoroom.dto.UpdateRoomDTO;

public class ChooseVideo {
    private int id;
    private String videoName;
    private String videoUrl;
    private String snapshot;
    private String createdAt;
    private String updatedAt;

    public ChooseVideo() {

    }

    public ChooseVideo(CreateRoomDTO createRoomDTO) {
        this.videoName = createRoomDTO.getVideoName();
        this.videoUrl = createRoomDTO.getVideoUrl();
        this.snapshot = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fmaterials.cdn.bcebos.com%2Fimages%2Fbded219d0ebb320b3a9784c0d2434db8.jpeg&refer=http%3A%2F%2Fmaterials.cdn.bcebos.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1646725332&t=416b11ea68d358c09df1bbdf3c8cad8b";
    }
    public ChooseVideo(UpdateRoomDTO updateRoomDTO) {
        this.videoName = updateRoomDTO.getVideoName();
        this.videoUrl = updateRoomDTO.getVideoUrl();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
