package com.bricktool.videoroom.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bricktool.videoroom.dto.IndexDTO;
import com.bricktool.videoroom.vo.IndexVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService {
    private final VideoRoomServiceImpl videoRoomService;

    public IndexService(VideoRoomServiceImpl videoRoomService) {
        this.videoRoomService = videoRoomService;
    }

    public IPage<IndexVO> index(IndexDTO indexDTO) {
        IPage<IndexVO> iPage= videoRoomService.getListFromIndex(indexDTO);
        for (IndexVO indexVO : iPage.getRecords()) {
            indexVO.setWatching(videoRoomService.getWatching(indexVO.getId()));
        }
        return iPage;
    }
}
