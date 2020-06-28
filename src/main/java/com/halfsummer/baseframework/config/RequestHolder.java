package com.halfsummer.baseframework.config;

import com.halfsummer.baseframework.util.ActiveUser;

import javax.servlet.http.HttpServletRequest;

/**
 * @author BestClever
 * @title: RequestHolder
 * @projectName base-framework
 * @description: 请求缓存类
 * @date 2020-05-25 10:50
 */
public class RequestHolder {

    private static final ThreadLocal<ActiveUser> userHolder = new ThreadLocal<ActiveUser>();

    private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();

    public static void add(ActiveUser activeUser) {
        userHolder.set(activeUser);
    }

    public static void add(HttpServletRequest request) {
        requestHolder.set(request);
    }

    public static ActiveUser getCurrentUser() {
        return userHolder.get();
    }

    public static HttpServletRequest getCurrentRequest() {
        return requestHolder.get();
    }

    public static void remove() {
        userHolder.remove();
        requestHolder.remove();
    }
}
