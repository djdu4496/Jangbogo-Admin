package com.jangbogo.admin.controller;

import com.jangbogo.admin.domain.PageHandler;
import com.jangbogo.admin.domain.SearchCondition;
import com.jangbogo.admin.domain.User;
import com.jangbogo.admin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
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
            log.info("....." + sc.getOffset() + sc);

            List<User> list = service.getSearchSelectPage(sc);
            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);

//            Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
//            m.addAttribute("startOfToday", startOfToday.toEpochMilli());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/user/list";
    }

    //회원 상세 조회
    @GetMapping("/user/read")
    public String readUser(Integer idx, SearchCondition sc, Model m, RedirectAttributes rattr) {
        try {
            User user = service.getUserByIdx(idx); //세션 아님
            m.addAttribute("user", user);
            return "/user/read";

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "EXCEPTION_ERR");
            return "redirect:/user/list" + sc.getQueryString();
        }
    }


    //회원 신고
    @PostMapping("/user/report")
    public ResponseEntity<String> reportUser(Integer idx, String email) {
        try {
            if (service.reportUser(idx, email) != 1)
                throw new Exception("report failed");

            return ResponseEntity.ok("REPORT_OK");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("ERROR");
        }
    }
}
