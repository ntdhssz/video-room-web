package com.bricktool.videoroom.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(Object object) {
        super(object.toString());
    }
}
