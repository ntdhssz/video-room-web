package com.bricktool.videoroom.exception;

import com.bricktool.videoroom.util.RestResult.ResultData;
import com.bricktool.videoroom.util.RestResult.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class BusinessExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResultData handler(BusinessException e) {
        return ResultUtil.error(e.getMessage());
    }
}
