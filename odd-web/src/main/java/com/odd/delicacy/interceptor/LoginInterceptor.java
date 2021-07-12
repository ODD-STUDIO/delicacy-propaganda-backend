package com.odd.delicacy.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {


    /**
     * 前置处理
     *
     * @param request
     * @param response
     * @param handler
     * @return true : 放行  false 拦截
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 先获取session对象
        HttpSession session = request.getSession();
        // 获取session中存放的数据
        String adminName = (String) session.getAttribute("adminName");
        // 判断是否为null
        if (adminName == null) {
            // 说明没有登录
            // 重定向到登录页面
            response.sendRedirect("/back/admin/login");
            return false;
        }
        // 已经登录
        return true;
    }
}

