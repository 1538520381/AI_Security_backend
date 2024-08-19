package com.AI_Security.AI_Security_server.handler;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.AI_Security.AI_Security_server.entity.result.R;
import com.AI_Security.AI_Security_server.exception.CustomerException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Persolute
 * @version 1.0
 * @description 全局异常处理器
 * @email 1538520381@qq.com
 * @date 2024/04/29 12:07
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
public class GlobalExceptionHandler {
    static Log log = LogFactory.get(GlobalExceptionHandler.class);

    @ExceptionHandler(CustomerException.class)
    public R exceptionHandler(CustomerException e) {
        e.printStackTrace();
        log.error(e.getMessage());
        return R.error(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public R exceptionHandler(Exception e) {
        e.printStackTrace();
        log.error(e.getMessage());
        return R.error("未知错误");
    }
}
