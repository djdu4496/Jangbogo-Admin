package com.jangbogo.admin.controller;


import com.jangbogo.admin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class HomeController {

    @Autowired
    UserService service;

    @GetMapping("/login")
    public String loginView() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String email, String pwd, HttpSession session, RedirectAttributes rattr) {
            log.info("login....." + email + "....." +pwd);
        try {
            if (!service.verifyAdmin(email, pwd)) { //인증 실패
                rattr.addFlashAttribute("msg", "ADMIN_NOT_FOUND");
                return "redirect:/login";
            }
            session.setAttribute("admin", email); //세션에 어드민 이메일 정보 저장
            return "redirect:/";
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "EXCEPTION_ERR"); //에러 발생
            return "redirect:/login";
        }
    }
}
