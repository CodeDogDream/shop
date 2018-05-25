package com.dream.login.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dream on 2018/4/11.
 *
 * @author Dream
 */
public class ResponseUtils {
    private static Logger logger = LoggerFactory.getLogger(ResponseUtils.class);

    public static Map<String, Object> getBasicResponse(int code, String message, Object data) {
        Map<String, Object> modelMap = new HashMap<>(3);
        modelMap.put("code", code);
        modelMap.put("msg", message);
        if (data != null) {
            modelMap.put("data", data);
        }
        logger.error(modelMap.toString());
        return modelMap;
    }

    public static Map<String, Object> getPageResponse(int code, String message,
                                                      Object data, int totalPage,
                                                      long totalNum) {
        Map<String, Object> response = getBasicResponse(code, message, data);
        response.put("totalPage", totalPage);
        response.put("totalNum", totalNum);
        logger.error(response.toString());
        return response;
    }
}
