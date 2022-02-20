package com.bricktool.videoroom.controller;

import com.bricktool.videoroom.service.RoomService;
import com.bricktool.videoroom.util.RestResult.ResultData;
import com.bricktool.videoroom.util.RestResult.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("")
    public ResultData enterRoom(@RequestParam int id, HttpServletRequest request) {
        int userId = (int) request.getAttribute("uid");
        return ResultUtil.success(roomService.enterRoom(id, userId));
    }

    @GetMapping("/get_room_user")
    public ResultData getRoomUser(@RequestParam(value = "user_id") int userId) {
        return ResultUtil.success(roomService.getRoomUser(userId));
    }
}
