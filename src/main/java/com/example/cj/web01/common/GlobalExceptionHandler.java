package com.example.cj.web01.common;

import com.example.cj.web01.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ResponseUtil.Response handleException(Throwable throwable) {
        if (throwable instanceof Web01Exception) {
            logger.warn(throwable.getMessage(), throwable);
            return ResponseUtil.buildFail(throwable.getMessage());
        }
        logger.error(throwable.getMessage(), throwable);
        return ResponseUtil.buildError(throwable.getMessage());
    }
}
