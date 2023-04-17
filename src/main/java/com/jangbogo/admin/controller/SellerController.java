package com.jangbogo.admin.controller;

import com.jangbogo.admin.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SellerController {

    @Autowired
    SellerService service;

    @GetMapping("/seller/list/pending")
    public String pendingListView (Model m) {
        m.addAttribute("seller", "seller"); //대기자 리스트만 출력
        return "/seller/list";
    }

    @GetMapping("/seller/list")
    public String AllListView (Model m) {
        m.addAttribute("seller", "seller"); //대기자 리스트만 출력
        return "/seller/list";
    }

    @GetMapping("/seller/read/{idx}")
    public String readSeller (@PathVariable Integer idx, Model m) throws Exception {

        m.addAttribute("seller",service.selectSeller(idx));
//        판매자 선택 정보도 가져와야 한다. sellerDetail
        return "/seller/read";
    }


}
