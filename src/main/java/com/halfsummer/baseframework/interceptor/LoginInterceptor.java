package com.halfsummer.baseframework.interceptor;


import cn.hutool.core.util.StrUtil;
import com.halfsummer.baseframework.enums.CommonEnum;
import com.halfsummer.baseframework.result.ResultDataUtil;
import com.halfsummer.baseframework.util.Audience;
import com.halfsummer.baseframework.util.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author BestClever
 * @title: LoginInterceptor
 * @projectName
 * @description: TODO
 * @date 2020-05-28 11:07
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    private static final String START_TIME = "requestStartTime";

    /**
     * 在控制器执行之前完成业务逻辑操作
     * 方法的返回值决定逻辑是否继续执行， true，表示继续执行， false, 表示不再继续执行。
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        long start = System.currentTimeMillis();
        request.setAttribute(START_TIME,start);
        String contextPath = request.getServletContext().getContextPath();
        String requestURI = request.getRequestURI();
        // 判断当前用户是否已经登陆
        HttpSession session = request.getSession();
        request.setCharacterEncoding("utf-8"); // 设置编码为utf初-8
        response.setContentType("text/html;charset=utf-8");
        String token = request.getHeader("token");
        Claims claims = JwtTokenUtil.parseJWT(token, Audience.getAudience().getBase64Secret());

        //判断用户的权限
        String userid = claims.get("userId").toString();
        if (StrUtil.isBlank(userid)) {
            String path = session.getServletContext().getContextPath();
            String requestType = request.getHeader("X-Requested-With");
            // Ajax请求会话过期处理
            if (StringUtils.isNotEmpty(requestType) && requestType.equalsIgnoreCase("XMLHttpRequest")) {
                response.setHeader("sessionStatus", "sessionTimeOut");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);//没有权限
                this.responseOutWithJson(response,ResultDataUtil.createFail(CommonEnum.SIGNATURE_NOT_MATCH).setData(path + "/login.html"));
                return false;
            }
            response.sendRedirect(path + "/login.html");
            return false;
        }else {
            return true;
        }
    }

    /**
     * 在控制器执行完毕之后执行的逻辑操作
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }

    /**
     * 在完成视图渲染之后，执行此方法。
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        String url = request.getRequestURI().toString();
        long start = (long) request.getAttribute(START_TIME);
        long end = System.currentTimeMillis();
        log.info("request finished. url:{},cost:{}",url,end-start);
    }


    public void responseOutWithJson(HttpServletResponse response,
                                    Object responseObject) {
        //将实体对象转换为JSON Object转换
        JSONObject responseJSONObject = JSONObject.fromObject(responseObject);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(responseJSONObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

}