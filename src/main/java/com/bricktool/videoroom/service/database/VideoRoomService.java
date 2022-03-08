package com.bricktool.videoroom.service.database;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bricktool.videoroom.dto.IndexDTO;
import com.bricktool.videoroom.pojo.VideoRoom;
import com.bricktool.videoroom.vo.IndexVO;

import java.util.List;

public interface VideoRoomService {
    VideoRoom get(int id);
    int insert(VideoRoom videoRoom);
    void update(VideoRoom videoRoom);
    void delete(int id);
    List<VideoRoom> getList();
    List<VideoRoom> getUserRoomList(int userId);
    List<VideoRoom> getWatchHistory(int userId);
    IPage<IndexVO> getListFromIndex(IndexDTO indexDTO);
}
