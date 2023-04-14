package com.jangbogo.admin.controller;

import com.jangbogo.admin.domain.User;
import com.jangbogo.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    //주입
//    @Autowired
//    MemberServiceImpl service;

    @Autowired
    UserService service;

    //회원 전체 조회
    @GetMapping("/list/user")
    public String userList() {
        return "/user/list";
    }


    //회원 상세 조회
    @GetMapping("/read/user/{idx}")
    public String readSeller(@PathVariable Integer idx, Model m, RedirectAttributes rattr) {
        try {
            User user = service.getUserByIdx(idx); //세션 아님
            m.addAttribute("user", user);
            return "/user/read";

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "EXCEPTION_ERR");
            return "redirect:/list/user";
        }
    }
}
