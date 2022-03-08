package com.bricktool.videoroom.vo;

import com.bricktool.videoroom.eList.VideoRoomType;
import com.bricktool.videoroom.pojo.ChooseVideo;
import com.bricktool.videoroom.pojo.VideoRoom;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WatchHistoryVO {
    List<VideoRoom> roomList;
    List<Map<String, String>> typeList;
    Set<String> watchDateList;
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

    public Set<String> getWatchDateList() {
        watchDateList = new HashSet<>();
        for (VideoRoom room: roomList) {
            watchDateList.add(room.getWatchDate());
        }
        return watchDateList;
    }

    public List<ChooseVideo> getChooseVideoList() {
        return chooseVideoList;
    }

    public void setChooseVideoList(List<ChooseVideo> chooseVideoList) {
        this.chooseVideoList = chooseVideoList;
    }
}
