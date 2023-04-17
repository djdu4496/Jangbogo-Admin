package com.jangbogo.admin.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class HomeController {

    @GetMapping("/login")
    public String loginView() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String email, String pwd, HttpSession session, RedirectAttributes rattr) {
        try {

            log.info("login....." + email + "....." +pwd);


            session.setAttribute("admin", "admin"); //세션에 어드민 정보 저장
            return "redirect:/";
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "EXCEPTION_ERR"); //에러 발생
            return "redirect:/login";
        }
    }
}
