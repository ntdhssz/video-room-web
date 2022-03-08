package com.bricktool.videoroom.service;

import com.bricktool.videoroom.dto.CreateRoomDTO;
import com.bricktool.videoroom.dto.UpdateRoomDTO;
import com.bricktool.videoroom.exception.BusinessException;
import com.bricktool.videoroom.exception.BusinessExceptionCode;
import com.bricktool.videoroom.pojo.ChooseVideo;
import com.bricktool.videoroom.pojo.User;
import com.bricktool.videoroom.pojo.VideoRoom;
import com.bricktool.videoroom.pojo.WatchHistory;
import com.bricktool.videoroom.service.database.ChooseVideoServiceImpl;
import com.bricktool.videoroom.service.database.UserServiceImpl;
import com.bricktool.videoroom.service.database.VideoRoomServiceImpl;
import com.bricktool.videoroom.service.database.WatchHistoryServiceImpl;
import com.bricktool.videoroom.vo.MyRoomListVO;
import com.bricktool.videoroom.vo.RoomUserVO;
import com.bricktool.videoroom.vo.RoomVO;
import com.bricktool.videoroom.vo.WatchHistoryVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final VideoRoomServiceImpl videoRoomService;
    private final UserServiceImpl userService;
    private final ChooseVideoServiceImpl chooseRoomService;
    private final WatchHistoryServiceImpl watchHistoryService;

    public RoomService(VideoRoomServiceImpl videoRoomService,
                       UserServiceImpl userService,
                       ChooseVideoServiceImpl chooseRoomService,
                       WatchHistoryServiceImpl watchHistoryService) {
        this.videoRoomService = videoRoomService;
        this.userService = userService;
        this.chooseRoomService = chooseRoomService;
        this.watchHistoryService = watchHistoryService;
    }

    public void enterRoom(int userId, int roomId) {
        WatchHistory watchHistory = watchHistoryService.get(userId, roomId);
        if (watchHistory == null) {
            watchHistoryService.insert(userId, roomId);
        } else {
            watchHistoryService.update(watchHistory.getId());
        }
    }

    public RoomVO getRoomInfo(int id) {
        VideoRoom videoRoom = videoRoomService.get(id);
        if (videoRoom.getAuditStatus() !=1 && videoRoom.getPlayStatus() != 1) {
            throw new BusinessException(BusinessExceptionCode.ROOM_NOT_ALLOW_ENTER.toString());
        }

        return new RoomVO(videoRoom);
    }

    public RoomUserVO getRoomUser(int userId) {
        User user = userService.get(userId);
        return new RoomUserVO(user);
    }

    public MyRoomListVO getUserRoomList(int userId) {
        MyRoomListVO myRoomListVO = new MyRoomListVO();
        myRoomListVO.setRoomList(videoRoomService.getUserRoomList(userId));
        myRoomListVO.setChooseVideoList(getChooseVideoList());
        return myRoomListVO;
    }

    public WatchHistoryVO getWatchHistory(int userId) {
        WatchHistoryVO watchHistoryVO = new WatchHistoryVO();
        watchHistoryVO.setRoomList(videoRoomService.getWatchHistory(userId));
        watchHistoryVO.setChooseVideoList(getChooseVideoList());
        return watchHistoryVO;
    }

    public List<ChooseVideo> getChooseVideoList() {
        return chooseRoomService.getList();
    }

    public int createRoom(int userId, CreateRoomDTO createRoomDTO) {
        String videoName = createRoomDTO.getVideoName();
        String videoUrl = createRoomDTO.getVideoUrl();
        ChooseVideo chooseVideo = chooseRoomService.getByNameAndUrl(videoName, videoUrl);
        if (chooseVideo == null) {
            ChooseVideo newChooseVideo = new ChooseVideo(createRoomDTO);
            chooseRoomService.insert(newChooseVideo);
            createRoomDTO.setChooseVideo(newChooseVideo.getId());
        } else {
            createRoomDTO.setChooseVideo(chooseVideo.getId());
        }
        VideoRoom videoRoom = new VideoRoom(userId, createRoomDTO);

        return videoRoomService.insert(videoRoom);
    }

    public void updateRoom(int id, int userId, UpdateRoomDTO updateRoomDTO) {
        VideoRoom videoRoom = videoRoomService.get(id);

        if (videoRoom == null) {
            throw new BusinessException(BusinessExceptionCode.ROOM_NOT_EXIST.toString());
        }

        if (videoRoom.getUserId() != userId) {
            throw new BusinessException(BusinessExceptionCode.ROOM_NOT_ALLOW_EDIT.toString());
        }

        String videoName = updateRoomDTO.getVideoName();
        String videoUrl = updateRoomDTO.getVideoUrl();
        ChooseVideo chooseVideo = chooseRoomService.getByNameAndUrl(videoName, videoUrl);
        if (chooseVideo == null) {
            ChooseVideo newChooseVideo = new ChooseVideo(updateRoomDTO);
            chooseRoomService.insert(newChooseVideo);
            updateRoomDTO.setChooseVideo(newChooseVideo.getId());
        } else {
            updateRoomDTO.setChooseVideo(chooseVideo.getId());
        }

        videoRoom.setTitle(updateRoomDTO.getTitle());
        videoRoom.setType(updateRoomDTO.getType());
        videoRoom.setChooseVideo(updateRoomDTO.getChooseVideo());

        videoRoomService.update(videoRoom);
    }

    public void deleteRoom(int id, int userId) {
        VideoRoom videoRoom = videoRoomService.get(id);
        if (videoRoom == null) {
            throw new BusinessException(BusinessExceptionCode.ROOM_NOT_EXIST.toString());
        }

        if (videoRoom.getUserId() != userId) {
            throw new BusinessException(BusinessExceptionCode.ROOM_NOT_ALLOW_EDIT.toString());
        }

        videoRoomService.delete(id);
    }
}
