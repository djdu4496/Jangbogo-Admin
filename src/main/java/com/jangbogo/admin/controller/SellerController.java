package com.jangbogo.admin.controller;

import com.jangbogo.admin.domain.SearchCondition;
import com.jangbogo.admin.domain.User;
import com.jangbogo.admin.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SellerController {

    @Autowired
    SellerService service;

    @GetMapping("/seller/list/pending")
    public String pendingListView(Model m) {
        m.addAttribute("seller", "seller"); //대기자 리스트만 출력
        return "/seller/list";
    }

    @GetMapping("/seller/list")
    public String AllListView(Model m) {
        m.addAttribute("seller", "seller"); //대기자 리스트만 출력
        return "/seller/list";
    }

    @GetMapping("/seller/read")
    public String readSeller(Integer idx, SearchCondition sc, Model m, RedirectAttributes rattr) throws Exception {

        m.addAttribute("seller", service.selectSeller(idx));
//        판매자 선택 정보도 가져와야 한다. sellerDetail
        return "/seller/read";
    }

//    @GetMapping("/user/read")
//    public String readUser(Integer idx, SearchCondition sc, Model m, RedirectAttributes rattr) {
//        try {
//            User user = service.getUserByIdx(idx); //세션 아님
//            m.addAttribute("user", user);
//            return "/user/read";
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            rattr.addFlashAttribute("msg", "EXCEPTION_ERR");
//            return "redirect:/user/list" + sc.getQueryString();
//        }
//    }

    //판매자 승인
    @PostMapping("/seller/approve")
    public ResponseEntity<String> approveSeller(Integer idx, String email) {
        //세션 안쓰니 직접 idx, email 받기
        try {
            if (service.approveSeller(idx, email) != 1) //실패
                throw new Exception("approve failed");

            return ResponseEntity.ok("APPROVE_OK");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("EXCEPTION_ERR");
        }
    }

}
