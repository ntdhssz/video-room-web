package com.bricktool.videoroom.mapper;

import com.bricktool.videoroom.pojo.WatchHistory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WatchHistoryMapper {
    WatchHistory get(int userId, int roomId);
    void insert(int userId, int roomId);
    void update(int watchHistoryId);
}
