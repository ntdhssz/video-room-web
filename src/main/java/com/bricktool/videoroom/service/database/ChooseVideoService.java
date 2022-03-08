package com.bricktool.videoroom.service.database;

import com.bricktool.videoroom.pojo.ChooseVideo;

import java.util.List;

public interface ChooseVideoService {
    void insert(ChooseVideo chooseVideo);
    List<ChooseVideo> getList();
    ChooseVideo getByNameAndUrl(String videoName, String videoUrl);
}
