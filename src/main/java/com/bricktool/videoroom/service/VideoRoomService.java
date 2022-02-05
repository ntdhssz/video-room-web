package com.bricktool.videoroom.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bricktool.videoroom.dto.IndexDTO;
import com.bricktool.videoroom.pojo.VideoRoom;
import com.bricktool.videoroom.vo.IndexVO;

import java.util.List;

public interface VideoRoomService {
    VideoRoom get(int id);
    List<VideoRoom> getList();
    IPage<IndexVO> getListFromIndex(IndexDTO indexDTO);
}
