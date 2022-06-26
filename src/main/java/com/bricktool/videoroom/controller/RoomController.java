package com.bricktool.videoroom.controller;

import com.bricktool.videoroom.dto.CreateRoomDTO;
import com.bricktool.videoroom.dto.UpdateRoomDTO;
import com.bricktool.videoroom.service.RoomService;
import com.bricktool.videoroom.util.RestResult.ResultData;
import com.bricktool.videoroom.util.RestResult.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/enter/{id}")
    public ResultData enterRoom(@PathVariable int id, HttpServletRequest request) {
        int userId = (int) request.getAttribute("uid");
        roomService.enterRoom(userId, id);
        return ResultUtil.success(roomService.getRoomInfo(id));
    }

    @PostMapping
    public ResultData createRoom(@RequestBody CreateRoomDTO createRoomDTO, HttpServletRequest request) {
        int userId = (int) request.getAttribute("uid");
        return ResultUtil.success(roomService.createRoom(userId, createRoomDTO));
    }

    @GetMapping("/{id}")
    public ResultData getRoomInfo(@PathVariable int id) {
        return ResultUtil.success(roomService.getRoomInfo(id));
    }

    @PutMapping("/{id}")
    public ResultData updateRoom(@PathVariable int id,
                                 @RequestBody UpdateRoomDTO updateRoomDTO,
                                 HttpServletRequest request) {
        int userId = (int) request.getAttribute("uid");
        roomService.updateRoom(id, userId, updateRoomDTO);
        return ResultUtil.success();
    }

    @DeleteMapping("/{id}")
    public ResultData deleteRoom(@PathVariable int id, HttpServletRequest request) {
        int userId = (int) request.getAttribute("uid");
        roomService.deleteRoom(id, userId);
        return ResultUtil.success();
    }

    @GetMapping("/my")
    public ResultData getUserRoomList(HttpServletRequest request) {
        int userId = (int) request.getAttribute("uid");
        return ResultUtil.success(roomService.getUserRoomList(userId));
    }

    @GetMapping("/history")
    public ResultData getWatchHistory(HttpServletRequest request) {
        int userId = (int) request.getAttribute("uid");
        return ResultUtil.success(roomService.getWatchHistory(userId));
    }

    @GetMapping("/user/{userId}")
    public ResultData getRoomUser(@PathVariable int userId) {
        return ResultUtil.success(roomService.getRoomUser(userId));
    }

    @GetMapping("/videos")
    public ResultData getChooseVideoList() {
        return ResultUtil.success(roomService.getChooseVideoList());
    }
}
