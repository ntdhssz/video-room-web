package com.bricktool.videoroom.util.RestResult;

public class ResultUtil {
    public static ResultData success() {
        return new ResultData(true, 200, "success", null);
    }

    public static ResultData success(String message) {
        return new ResultData(true, 200, message, null);
    }

    public static ResultData success(Object object) {
        return new ResultData(true, 200, "success", object);
    }

    public static ResultData success(String message, Object object) {
        return new ResultData(true, 200, message, object);
    }
    public static ResultData error() {
        return new ResultData(false, 500, "error", null);
    }

    public static ResultData error(String message) {
        return new ResultData(false, 500, message, null);
    }
}
