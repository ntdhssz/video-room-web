package com.bricktool.videoroom.service;

import com.bricktool.videoroom.exception.BusinessException;
import com.bricktool.videoroom.exception.BusinessExceptionCode;
import com.bricktool.videoroom.pojo.User;
import com.bricktool.videoroom.pojo.VideoRoom;
import com.bricktool.videoroom.vo.RoomVO;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    private final VideoRoomServiceImpl videoRoomService;
    private final UserServiceImpl userService;

    public RoomService(VideoRoomServiceImpl videoRoomService, UserServiceImpl userService) {
        this.videoRoomService = videoRoomService;
        this.userService = userService;
    }

    public RoomVO enterRoom(int id, int userId) {
        VideoRoom videoRoom = videoRoomService.get(id);
        if (videoRoom.getAuditStatus() !=1 && videoRoom.getPlayStatus() != 1) {
            throw new BusinessException(BusinessExceptionCode.ROOM_NOT_ALLOW_ENTER.toString());
        }
        RoomVO roomVO = new RoomVO();
        roomVO.setId(videoRoom.getId());
        roomVO.setUserId(videoRoom.getUserId());
        roomVO.setTitle(videoRoom.getTitle());
        roomVO.setCreatedAt(videoRoom.getCreatedAt());
        roomVO.setVideoUrl(videoRoom.getVideoUrl());
        User user =userService.get(userId);
        roomVO.setNickName(user.getNickName());
        return roomVO;
    }
}
