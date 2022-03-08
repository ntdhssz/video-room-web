package com.bricktool.videoroom.service.database;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bricktool.videoroom.dto.IndexDTO;
import com.bricktool.videoroom.mapper.VideoRoomMapper;
import com.bricktool.videoroom.pojo.VideoRoom;
import com.bricktool.videoroom.util.Redis.RedisKey;
import com.bricktool.videoroom.util.Redis.RedisUtil;
import com.bricktool.videoroom.vo.IndexVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VideoRoomServiceImpl implements VideoRoomService{
    @Resource
    private VideoRoomMapper videoRoomMapper;

    private final RedisUtil redisUtil;

    public VideoRoomServiceImpl(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    @Override
    public VideoRoom get(int id) {
        return videoRoomMapper.get(id);
    }

    @Override
    public int insert(VideoRoom videoRoom) {
        videoRoomMapper.insert(videoRoom);
        return videoRoom.getId();
    }

    @Override
    public void update(VideoRoom videoRoom) {
        videoRoomMapper.update(videoRoom);
    }

    @Override
    public void delete(int id) {
        videoRoomMapper.delete(id);
    }

    @Override
    public List<VideoRoom> getList() {
        return videoRoomMapper.getList();
    }

    @Override
    public List<VideoRoom> getUserRoomList(int userId) {
        return videoRoomMapper.getUserRoomList(userId);
    }

    @Override
    public List<VideoRoom> getWatchHistory(int userId) {
        return videoRoomMapper.getWatchHistory(userId);
    }

    @Override
    public IPage<IndexVO> getListFromIndex(IndexDTO indexDTO) {
        Page<VideoRoom> page = new Page<>(indexDTO.getPage(), indexDTO.getPageSize());
        return videoRoomMapper.getListFromIndex(page, indexDTO.getType(), indexDTO.getKeyword());
    }

    public int getWatching(int id) {
        String watchingKey = RedisKey.ROOM_WATCHING.getKey() + id;
        Object watchingNumOj = redisUtil.get(watchingKey);
        int watchingNum = 0;
        if (watchingNumOj != null) {
            watchingNum = (int) watchingNumOj;
        }
        return watchingNum;
    }
}
