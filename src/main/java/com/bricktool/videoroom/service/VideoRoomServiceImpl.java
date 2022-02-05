package com.bricktool.videoroom.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bricktool.videoroom.dto.IndexDTO;
import com.bricktool.videoroom.mapper.VideoRoomMapper;
import com.bricktool.videoroom.pojo.VideoRoom;
import com.bricktool.videoroom.vo.IndexVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VideoRoomServiceImpl implements VideoRoomService{
    @Resource
    private VideoRoomMapper videoRoomMapper;

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
}