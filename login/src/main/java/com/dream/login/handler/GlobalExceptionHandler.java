package com.dream.login.handler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Dream on 2018/3/26.
 *
 * @author Dream
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(value = Exception.class)
    public Map<String,Object> getError(Exception e){
        logger.error(e.getMessage());
        Map<String,Object> model= new HashMap<>(5);
        model.put("msg",e.getMessage());
        model.put("error","UnKnowException");
        model.put("code",-1);
        return model;
    }

}
