package com.example.demo.exception;


import com.example.demo.domain.Result;
import com.example.demo.enums.ResultEnum;
import com.example.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof GlobalException) {
            GlobalException ex = (GlobalException) e;
            return ResultUtil.error(ex.getRe());
        } else {
            logger.error("[系统异常]{}", e);
            return ResultUtil.error(ResultEnum.UNKNOW_ERROR);
        }

    }
}
