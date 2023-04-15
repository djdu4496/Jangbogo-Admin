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
        User user = (User)session.getAttribute("user"); //TODO:: 추후 개발 예정

        if(user == null || user.getAuth_idx()  != 3) { //권한 3: 관리자
            resp.sendRedirect("/admin/login");
            return false;
        }
        return true;
    }
}
