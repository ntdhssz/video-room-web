package com.bricktool.videoroom.mapper;

import com.bricktool.videoroom.pojo.ChooseVideo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChooseVideoMapper {
    void insert(ChooseVideo chooseVideo);
    List<ChooseVideo> getList();
    ChooseVideo getByNameAndUrl(String videoName, String videoUrl);
}
