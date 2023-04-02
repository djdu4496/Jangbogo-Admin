package com.jangbogo.admin.controller;

import com.jangbogo.admin.domain.PageHandler;
import com.jangbogo.admin.domain.User;
import com.jangbogo.admin.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    //주입
    @Autowired
    MemberServiceImpl service;

//    전체 조회.
    @GetMapping("/list/user")
    public String userList () {
        return "/user/list";
    }
//    상태별 조회.
    @GetMapping("/list/user/{state}")
    public String userListByState (@RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "10") Integer pageSize,
                            @PathVariable String state,
                            Model m, HttpServletRequest request) throws Exception{

//        int totalCnt = service.getUserCnt();
//        m.addAttribute("totalCnt", totalCnt);
//
//        PageHandler pageHandler = new PageHandler(totalCnt, page, pageSize);
//
//        if(page < 0 || page > pageHandler.getTotalPage())
//            page = 1;
//        if(pageSize < 0 || pageSize > 50)
//            pageSize = 10;
//        Map map = new HashMap();
//        map.put("offset", (page-1)*pageSize);
//        map.put("pageSize", pageSize);
//
//        List<User> list = service.selectPage(map);
//        m.addAttribute("list", list);
//        m.addAttribute("ph", pageHandler);
        return "/user/list";
    }

    @GetMapping("/list/seller")
    public String sellerList () {
        return "/seller/list";
    };

    @GetMapping("/list/seller/{state}")
    public String sellerListByState (@PathVariable String state ) {
        return "/seller/list";
    };

}
