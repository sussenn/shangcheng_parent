package com.itcodes.common.exception;

import com.itcodes.common.utils.Result;
import com.itcodes.common.utils.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception ex) {
        return new Result(true, StatusCode.ERROR, "服务器异常！");
    }
}