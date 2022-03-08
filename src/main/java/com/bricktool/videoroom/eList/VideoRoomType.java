package com.bricktool.videoroom.eList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum VideoRoomType {
    GENERIC("0", "泛型"),
    MOVIE("1", "电影"),
    ANIMATION("2", "动画");

    private final String type;
    private final String typeText;

    VideoRoomType(String type, String typeText) {
        this.type = type;
        this.typeText = typeText;
    }

    public String getType() {
        return this.type;
    }

    public String getTypeText() {
        return this.typeText;
    }

    public static List<Map<String, String>> toList() {
        List<Map<String, String>> list = new ArrayList<>();
        for (VideoRoomType item: VideoRoomType.values()) {
            Map<String, String> map = new HashMap<>();
            map.put("type", item.getType());
            map.put("typeText", item.getTypeText());
            list.add(map);
        }
        return list;
    }
}
