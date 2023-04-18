package com.jangbogo.admin.controller;

import com.jangbogo.admin.domain.PageHandler;
import com.jangbogo.admin.domain.SearchCondition;
import com.jangbogo.admin.domain.Seller;
import com.jangbogo.admin.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
public class SellerController {

    @Autowired
    SellerService service;

    @GetMapping("/seller/list/pending")
    public String sellerPendingList(SearchCondition sc, Model m, RedirectAttributes rattr) {
        final int PENDING = 99;
        return showSellerList(sc, PENDING, m, rattr);
    }

    //판매자 전체 리스트 조회
    @GetMapping("/seller/list")
    public String sellerList(Model m, SearchCondition sc, RedirectAttributes rattr) {
        final int ALL = 100;
        return showSellerList(sc, ALL, m, rattr);
    }

    //판매자 상세 조회
    @GetMapping("/seller/read")
    public String readSeller(Integer idx, SearchCondition sc, Model m, RedirectAttributes rattr) {
        try {
            m.addAttribute("seller", service.selectSeller(idx));
            m.addAttribute("sellerDtl", service.selectSellerDtl(idx));
            return "/seller/read";
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "EXCEPTION_ERR");
            return "redirect:/seller/list" + sc.getQueryString();
        }
    }

    //판매자 승인
    @PostMapping("/seller/approve")
    public ResponseEntity<String> approveSeller(Integer idx, String email) {
        try {
            if (service.approveSeller(idx, email) != 1) //실패
                throw new Exception("approve failed");

            return ResponseEntity.ok("APPROVE_OK");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("EXCEPTION_ERR");
        }
    }

    //판매자 신고
    @PostMapping("/seller/report")
    public ResponseEntity<String> reportSeller(Integer idx, String email) {
        try {
            if (service.reportSeller(idx, email) != 1) //실패
                throw new Exception("report failed");

            return ResponseEntity.ok("REPORT_OK");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("EXCEPTION_ERR");
        }
    }

    //판매자 리스트 조회
    public String showSellerList(SearchCondition sc, int state_cd, Model m, RedirectAttributes rattr) {
        try {
            int totalCnt = service.getSearchResultCnt(sc, state_cd);
            m.addAttribute("totalCnt", totalCnt);

            PageHandler pageHandler = new PageHandler(totalCnt, sc);

            List<Seller> list = service.getSearchSelectPage(sc, state_cd);
            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);
            return "/seller/list";

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "EXCEPTION_ERR");
            return "redirect:/";
        }
    }

}
