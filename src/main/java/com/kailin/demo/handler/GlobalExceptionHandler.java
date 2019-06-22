package com.kailin.demo.handler;

import com.kailin.demo.common.Result;
import com.kailin.demo.common.ResultCode;
import com.kailin.demo.common.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exceptionHandler(HttpServletRequest request, Exception e){
        log.info("访问链接{}出现异常,异常信息如下：{}",request.getRequestURI(),e);
        return ResultGenerator.genFailResult(ResultCode.INTERNAL_SERVER_ERROR,"服务器内部错误");
    }

    //当controller方法里用@Valid修饰的入参校验不同过时将抛出BindException，此处对其捕捉并统一处理
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Result handleBindException(HttpServletRequest request, BindException e) {
        log.info("访问链接{}出现异常,异常信息如下：{}",request.getRequestURI(),e);
        FieldError fieldError = e.getBindingResult().getFieldError();
//        log.info("参数上的hibernate-validator注解上的括号里的值：{}",fieldError.getDefaultMessage());
        String field = fieldError.getField();
        String errorMsg = "数据校验异常：属性"+field+"," + fieldError.getDefaultMessage();
        log.info(errorMsg);
        return ResultGenerator.genFailResult(ResultCode.CHECK_ERROR,errorMsg);
    }
}
