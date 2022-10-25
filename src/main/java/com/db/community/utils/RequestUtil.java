package com.db.community.utils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {

    public static Integer getUserId(HttpServletRequest request){
        return (Integer) request.getAttribute("userId");
    }
}
