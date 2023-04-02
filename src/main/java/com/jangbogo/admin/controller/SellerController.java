package com.jangbogo.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class SellerController {

    @GetMapping("/list/seller")
    public String sellerList () {
        return "/seller/list";
    };

    @GetMapping("/list/seller/{state}")
    public String sellerListByState (@PathVariable String state) {
//        switch ~ case: PENDINNG~ 식
        return "/seller/list";
    };
}
