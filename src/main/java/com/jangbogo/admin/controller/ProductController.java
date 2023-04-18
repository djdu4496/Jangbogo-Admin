package com.jangbogo.admin.controller;


import com.jangbogo.admin.domain.SearchCondition;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {

    //승인 대기 상품 리스트
    @GetMapping("/product/list/pending")
    public String productPendingList (SearchCondition sc, Model m, RedirectAttributes rattr) {
        return "";
    }

    //상품 전체 리스트
    @GetMapping("/product/list")
    public String productList (SearchCondition sc, Model m, RedirectAttributes rattr) {
        return "";
    }

    //상품 상세
    @GetMapping("/product/read")
    public String productRead (Integer prod_idx, Model m, RedirectAttributes rattr) {
        return "";
    }
}
