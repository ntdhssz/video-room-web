package com.bricktool.videoroom.vo;

import com.bricktool.videoroom.eList.VideoRoomType;
import com.bricktool.videoroom.pojo.ChooseVideo;
import com.bricktool.videoroom.pojo.VideoRoom;

import java.util.*;

public class MyRoomListVO {
    List<VideoRoom> roomList;
    List<Map<String, String>> typeList;
    Set<String> createdDateList;
    List<ChooseVideo> chooseVideoList;

    public List<VideoRoom> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<VideoRoom> roomList) {
        this.roomList = roomList;
    }

    public List<Map<String, String>> getTypeList() {
        return VideoRoomType.toList();
    }

    public Set<String> getCreatedDateList() {
        createdDateList = new HashSet<>();
        for (VideoRoom room: roomList) {
            createdDateList.add(room.getCreatedDate());
        }
        return createdDateList;
    }

    public List<ChooseVideo> getChooseVideoList() {
        return chooseVideoList;
    }

    public void setChooseVideoList(List<ChooseVideo> chooseVideoList) {
        this.chooseVideoList = chooseVideoList;
    }
}
