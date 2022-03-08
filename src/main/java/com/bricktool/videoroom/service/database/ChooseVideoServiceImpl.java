package com.bricktool.videoroom.service.database;

import com.bricktool.videoroom.mapper.ChooseVideoMapper;
import com.bricktool.videoroom.pojo.ChooseVideo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChooseVideoServiceImpl implements ChooseVideoService {
    @Resource
    private ChooseVideoMapper chooseRoomMapper;

    @Override
    public void insert(ChooseVideo chooseVideo) {
        chooseRoomMapper.insert(chooseVideo);
    }

    @Override
    public List<ChooseVideo> getList() {
        return chooseRoomMapper.getList();
    }

    @Override
    public ChooseVideo getByNameAndUrl(String videoName, String videoUrl) {
        return chooseRoomMapper.getByNameAndUrl(videoName, videoUrl);
    }
}
