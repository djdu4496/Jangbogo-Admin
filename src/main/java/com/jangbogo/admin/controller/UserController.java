package com.jangbogo.admin.controller;

import com.jangbogo.admin.domain.PageHandler;
import com.jangbogo.admin.domain.SearchCondition;
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
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService service;

    //회원 전체 조회
    @GetMapping("/user/list")
    public String userList(Model m, SearchCondition sc, RedirectAttributes rattr) {
        try {
            int totalCnt = service.getSearchResultCnt(sc);
            m.addAttribute("totalCnt", totalCnt);

            PageHandler pageHandler = new PageHandler(totalCnt, sc);

            List<User> list = service.getSearchSelectPage(sc);
            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);

            Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
            m.addAttribute("startOfToday", startOfToday.toEpochMilli());

        } catch (Exception e) {
            rattr.addFlashAttribute("msg", "EXCEPTION_ERR");
            e.printStackTrace();
            return "redirect:/";
        }
        return "/user/list";
    }

    //회원 상세 조회
    @GetMapping("/user/read/{idx}")
    public String readSeller(@PathVariable Integer idx, Model m, RedirectAttributes rattr) {
        try {
            User user = service.getUserByIdx(idx); //세션 아님
            m.addAttribute("user", user);
            return "/user/read";

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "EXCEPTION_ERR");
            return "redirect:/user/list";
        }
    }
}
