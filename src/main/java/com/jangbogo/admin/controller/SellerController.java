package com.jangbogo.admin.controller;

import com.jangbogo.admin.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SellerController {

    @Autowired
    SellerService service;

    @GetMapping("/list/seller")
    public String sellerList (Model m) {

        return "/seller/list";
    };

    @GetMapping("/list/seller/{state}")
    public String sellerListByState (@PathVariable String state) {
//        switch ~ case: PENDINNG~ 식
        return "/seller/list";
    };

    @GetMapping("/read/seller/{idx}")
    public String readSeller (@PathVariable int idx, Model m) throws Exception {

        m.addAttribute("seller",service.selectSeller(idx));
//        판매자 선택 정보도 가져와야 한다. sellerOption
        return "/seller/read";
    }

    @GetMapping("/read/seller")
    public String readSeller2 ( Model m) throws Exception {

        m.addAttribute("seller",service.selectSeller(6));
//        판매자 선택 정보도 가져와야 한다. sellerOption
        return "/seller/read";
    }

}
