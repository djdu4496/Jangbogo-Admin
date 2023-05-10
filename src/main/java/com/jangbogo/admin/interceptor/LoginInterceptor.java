package com.jangbogo.admin.interceptor;

import com.jangbogo.admin.domain.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle (HttpServletRequest req, HttpServletResponse resp, Object obj) throws Exception {
        HttpSession session = req.getSession();
        String admin = (String)session.getAttribute("admin");
        if(session == null || admin == null) { // 세션이 없거나 admin에 저장된 이메일 값이 없는 경우
            resp.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
