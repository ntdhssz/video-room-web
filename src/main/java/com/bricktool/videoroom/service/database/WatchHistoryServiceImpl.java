package com.bricktool.videoroom.service.database;

import com.bricktool.videoroom.mapper.WatchHistoryMapper;
import com.bricktool.videoroom.pojo.WatchHistory;
import org.springframework.stereotype.Service;

@Service
public class WatchHistoryServiceImpl implements WatchHistoryService{
    private final WatchHistoryMapper watchHistoryMapper;

    public WatchHistoryServiceImpl(WatchHistoryMapper watchHistoryMapper) {
        this.watchHistoryMapper = watchHistoryMapper;
    }

    @Override
    public WatchHistory get(int userId, int roomId) {
        return watchHistoryMapper.get(userId, roomId);
    }

    @Override
    public void insert(int userId, int roomId) {
        watchHistoryMapper.insert(userId, roomId);
    }

    @Override
    public void update(int watchHistoryId) {
        watchHistoryMapper.update(watchHistoryId);
    }
}
