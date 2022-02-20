package com.bricktool.videoroom.service;

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
    public List<VideoRoom> getList() {
        return videoRoomMapper.getList();
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
