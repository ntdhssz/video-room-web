package com.bricktool.videoroom.service.database;

import com.bricktool.videoroom.pojo.ChooseVideo;
import com.bricktool.videoroom.pojo.WatchHistory;

public interface WatchHistoryService {
    WatchHistory get(int userId, int roomId);
    void insert(int userId, int roomId);
    void update(int watchHistoryId);
}
