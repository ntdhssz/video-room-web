package com.bricktool.videoroom.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bricktool.videoroom.dto.IndexDTO;
import com.bricktool.videoroom.pojo.VideoRoom;
import com.bricktool.videoroom.vo.IndexVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VideoRoomMapper {
    VideoRoom get(int id);
    void insert(VideoRoom videoRoom);
    void update(VideoRoom videoRoom);
    void delete(int id);
    List<VideoRoom> getList();
    List<VideoRoom> getUserRoomList(int userId);
    List<VideoRoom> getWatchHistory(int userId);
    IPage<IndexVO> getListFromIndex(Page<VideoRoom> page, int type, String keyword);
}