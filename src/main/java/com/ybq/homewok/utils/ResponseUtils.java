package com.ybq.homewok.utils;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtils {
    public static final String CHARACTER_ENCODING = "utf-8";
    public static final String CONTENT_TYPE = "application/json; charset=utf-8";
    public static void responseToJson(HttpServletResponse response, Object object) throws IOException {
        response.setCharacterEncoding(CHARACTER_ENCODING);
        response.setContentType(CONTENT_TYPE);
        response.getWriter().println(JSONObject.toJSONString(object));
    }
}
