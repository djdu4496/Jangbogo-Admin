package com.jangbogo.admin.controller;


import com.jangbogo.admin.domain.*;
import com.jangbogo.admin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;


    // 메서드명 : getList
    // 기   능 : 상품 전체 목록 가져오기
    // 매개변수 : SearchCondition sc, Model m, RedirectAttributes rattr
    // 반환타입 : String
    @GetMapping("/product/list")
    public String getList (SearchCondition sc, Model model, RedirectAttributes rattr) {
        List<ProductDto> list = null;                                                                                   // 변수명 : list - 저장값 : 전체 상품 목록
        try {
            int totalCnt = productService.getSearchResultCnt(sc);                                                       // 변수명 : totalCnt - 저장값 : 주문내역 목록 검색 결과 개수
            PageHandler pageHandler = new PageHandler(totalCnt, sc);                                                    // PageHandler 객체 생성(인자 - totalCnt, sc)
            list = productService.getSearchSelectPage(sc);                                                              // productService의 getSearchSelectPage메서드 호출, 반환값을 list에 저장
            if(list == null) throw new Exception("getList failed");                                                     // list 목록이 없는 경우, 예외 던지기

            model.addAttribute("totalCnt", totalCnt);                                                                   // Model에 totalCnt를 K/V로 저장
            model.addAttribute("list", list);                                                                           // Model에 list를 K/V로 저장
            model.addAttribute("ph", pageHandler);                                                                      // Model에 PageHandler를 K/V로 저장

            return "/product/list";
        } catch(Exception e) {
            e.printStackTrace();
            return "redirect:/";
        }
    }

    // 메서드명 : getRead
    // 기   능 : 상품 상세 페이지 이동
    // 반환타입 : String
    // 매개변수 : @PathVariable Integer idx
    @GetMapping("/product/read/{prod_idx}")
    public String getRead (@PathVariable Integer prod_idx, Model model, RedirectAttributes rattr) {
        ProductDetailDto productDetailDto = null;                                                                       // 변수명 : list - 저장값 : OrderDetailDto 저장소 List
        try {
            productDetailDto = productService.getProductRead(prod_idx);
            if(productDetailDto == null) throw new Exception("getProductRead failed");
            model.addAttribute("product", productDetailDto);                                               // Model에 idx를 K/V로 저장

            return "/product/read";                                                                                      // "/order/order.jsp" 뷰 이름 반환 - 뷰 렌더링
        } catch(Exception e) {                                                                                          // 에러 발생 시
            e.printStackTrace();                                                                                        // 1) 에러 내용을 로그에 출력
            return "redirect:/";                                                                                        // 2) 메인 페이지로 리다이렉트
        }
    }

    // 메서드명 : getPendingList
    // 기   능 : '승인대기' 상태인 상품 목록 가져오기
    // 반환타입 : String
    // 매개변수 : @PathVariable Integer idx
    @GetMapping("/product/list/pending")
    public String getPendingList (SearchCondition sc, Model model, RedirectAttributes rattr) {
        List<ProductDto> list = null;                                                                                   // 변수명 : list - 저장값 :  '승인대기' 상태인 상품 목록
        try {
            int totalCnt = productService.getPendingSearchResultCnt(sc);                                                // 변수명 : totalCnt - 저장값 : 주문내역 목록 검색 결과 개수
            PageHandler pageHandler = new PageHandler(totalCnt, sc);                                                    // PageHandler 객체 생성(인자 - totalCnt, sc)
            list = productService.getPendingSearchSelectPage(sc);                                                       // productService의 getPendingSearchSelectPage메서드 호출, 반환값을 list에 저장
            if(list == null) throw new Exception("getList failed");                                                     // list 목록이 없는 경우, 예외 던지기

            model.addAttribute("totalCnt", totalCnt);                                                                   // Model에 totalCnt를 K/V로 저장
            model.addAttribute("list", list);                                                                           // Model에 list를 K/V로 저장
            model.addAttribute("ph", pageHandler);                                                                      // Model에 PageHandler를 K/V로 저장
            return "/product/listPending";
        } catch(Exception e) {
            e.printStackTrace();
            return "redirect:/";
        }
    }

    // 메서드명 : getReadPending
    // 기   능 : '승인대기' 상태인 상품 상세 페이지 이동
    // 반환타입 : String
    // 매개변수 : @PathVariable Integer idx
    @GetMapping("/product/read/pending/{prod_idx}")
    public String getReadPending (@PathVariable Integer prod_idx, Model model, RedirectAttributes rattr) {
        ProductDetailDto productDetailDto = null;                                                                       // 변수명 : list - 저장값 : OrderDetailDto 저장소 List
        try {
            productDetailDto = productService.getProductRead(prod_idx);
            if(productDetailDto == null) throw new Exception("getProductRead failed");
            model.addAttribute("product", productDetailDto);                                               // Model에 idx를 K/V로 저장

            return "/product/readPending";                                                                                      // "/order/order.jsp" 뷰 이름 반환 - 뷰 렌더링
        } catch(Exception e) {                                                                                          // 에러 발생 시
            e.printStackTrace();                                                                                        // 1) 에러 내용을 로그에 출력
            return "redirect:/";                                                                                        // 2) 메인 페이지로 리다이렉트
        }
    }

}
