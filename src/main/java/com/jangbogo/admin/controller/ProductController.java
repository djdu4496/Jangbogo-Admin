package com.jangbogo.admin.controller;


import com.jangbogo.admin.domain.*;
import com.jangbogo.admin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;


    // 메서드명 : getList
    // 기   능 : 상품 전체 목록 가져오기
    // 매개변수 : SearchCondition sc, Model m, RedirectAttributes rattr
    // 반환타입 : String
    @GetMapping("/product/list")
    public String getList(SearchCondition sc, Model model, RedirectAttributes rattr) {
        List<ProductDto> list = null;                                                                                   // 변수명 : list - 저장값 : 전체 상품 목록
        try {
            int totalCnt = productService.getSearchResultCnt(sc);                                                       // 변수명 : totalCnt - 저장값 : 주문내역 목록 검색 결과 개수
            PageHandler pageHandler = new PageHandler(totalCnt, sc);                                                    // PageHandler 객체 생성(인자 - totalCnt, sc)
            list = productService.getSearchSelectPage(sc);                                                              // productService의 getSearchSelectPage메서드 호출, 반환값을 list에 저장
            if (list == null)
                throw new Exception("getList failed");                                                     // list 목록이 없는 경우, 예외 던지기

            model.addAttribute("totalCnt", totalCnt);                                                                   // Model에 totalCnt를 K/V로 저장
            model.addAttribute("list", list);                                                                           // Model에 list를 K/V로 저장
            model.addAttribute("ph", pageHandler);                                                                      // Model에 PageHandler를 K/V로 저장

            return "/product/list";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/";
        }
    }

    // 메서드명 : getRead
    // 기   능 : 상품 상세 페이지 이동
    // 반환타입 : String
    // 매개변수 : @PathVariable Integer idx
    @GetMapping("/product/read/{prod_idx}")
    public String getRead(@PathVariable Integer prod_idx, Model model, RedirectAttributes rattr) {
        ProductDetailDto productDetailDto = null;                                                                       // 변수명 : list - 저장값 : OrderDetailDto 저장소 List
        try {
            productDetailDto = productService.getProductRead(prod_idx);
            if (productDetailDto == null) throw new Exception("getProductRead failed");
            model.addAttribute("product", productDetailDto);
            // Model에 idx를 K/V로 저장
            //product files 저장
            model.addAttribute("fileList", productService.selectPdFiles(prod_idx));
            return "/product/read";                                                                                   // "/order/order.jsp" 뷰 이름 반환 - 뷰 렌더링
        } catch (
                Exception e) {                                                                                          // 에러 발생 시
            e.printStackTrace();
            // 1) 에러 내용을 로그에 출력
            rattr.addFlashAttribute("msg", "EXCEPTION_ERR");
            return "redirect:/";                                                                                        // 2) 메인 페이지로 리다이렉트
        }
    }

    // 메서드명 : getPendingList
    // 기   능 : '승인대기' 상태인 상품 목록 가져오기
    // 반환타입 : String
    // 매개변수 : @PathVariable Integer idx
    @GetMapping("/product/list/pending")
    public String getPendingList(SearchCondition sc, Model model, RedirectAttributes rattr) {
        List<ProductDto> list = null;                                                                                   // 변수명 : list - 저장값 :  '승인대기' 상태인 상품 목록
        try {
            int totalCnt = productService.getPendingSearchResultCnt(sc);                                                // 변수명 : totalCnt - 저장값 : 주문내역 목록 검색 결과 개수
            PageHandler pageHandler = new PageHandler(totalCnt, sc);                                                    // PageHandler 객체 생성(인자 - totalCnt, sc)
            list = productService.getPendingSearchSelectPage(sc);                                                       // productService의 getPendingSearchSelectPage메서드 호출, 반환값을 list에 저장
            if (list == null)
                throw new Exception("getList failed");                                                     // list 목록이 없는 경우, 예외 던지기

            model.addAttribute("totalCnt", totalCnt);                                                                   // Model에 totalCnt를 K/V로 저장
            model.addAttribute("list", list);                                                                           // Model에 list를 K/V로 저장
            model.addAttribute("ph", pageHandler);                                                                      // Model에 PageHandler를 K/V로 저장
            return "/product/listPending";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/";
        }
    }

    // 메서드명 : getReadPending
    // 기   능 : '승인대기' 상태인 상품 상세 페이지 이동
    // 반환타입 : String
    // 매개변수 : @PathVariable Integer idx
    @GetMapping("/product/read/pending/{prod_idx}")
    public String getReadPending(@PathVariable Integer prod_idx, Model model, RedirectAttributes rattr) {
        ProductDetailDto productDetailDto = null;                                                                       // 변수명 : list - 저장값 : OrderDetailDto 저장소 List
        try {
            productDetailDto = productService.getProductRead(prod_idx);
            if (productDetailDto == null) throw new Exception("getProductRead failed");
            model.addAttribute("product", productDetailDto);                                                            // Model에 '상품상세' 객체를 K/V로 저장
            model.addAttribute("prod_idx", prod_idx);
            // Model에 '상품번호'를 K/V로 저장

            //product files 저장
            model.addAttribute("fileList", productService.selectPdFiles(prod_idx));
            return "/product/readPending";                                                                              // "/order/order.jsp" 뷰 이름 반환 - 뷰 렌더링
        } catch (
                Exception e) {                                                                                          // 에러 발생 시
            e.printStackTrace();                                                                                        // 1) 에러 내용을 로그에 출력
            return "redirect:/";                                                                                        // 2) 메인 페이지로 리다이렉트
        }
    }

    // 메서드명 : updateProductPending
    // 기   능 : '승인대기(1)' 상태인 상품의 상태를 '승인완료(2)' 또는 '승인반려(3)' 상태로 수정
    // 반환타입 : ResponseEntity<String>
    // 매개변수 : Map<Integer, Integer> pathVarsMap - Integer prod_idx (상품번호), reg_stae_cd (상품상태)
    // 요청URL : /product/approve/{prod_idx} PATCH
    @PatchMapping("/product/update/{prod_idx}/{reg_state_cd}")
    public ResponseEntity<String> updateProductPending(@PathVariable Map<Integer, Integer> pathVarsMap) {
        int rowCnt = 0;
        try {
            rowCnt = productService.updateProductRegState(pathVarsMap);                                                 // 상품번호 #{prod_idx}에 해당하는 상품의 상품상태코드를 #{reg_state_cd}로 변경 후 변경 있는 행의 수를 rowCnt에 저
            if (rowCnt == 0)
                throw new Exception("updateProductRegState failed(PROD_DTL)");                              // 변경된 행의 개수가 0인 경우 예외를 발생시킨다.
            return new ResponseEntity<>("MOD_REG_STATE_CD_OK", HttpStatus.OK);                                          // update 요청 결과가 성공인 경우, 상태코드와 함께 메시지 반환
        } catch (Exception e) {
            e.printStackTrace();                                                                                        // 1) 에러 내용을 로그에 출력
            return new ResponseEntity<>("MOD_REG_STATE_CD_ERR", HttpStatus.BAD_REQUEST);                                // 2) update 요청 결과가 실패인 경우, 상태코드와 함께 메시지 반환
        }
    }
}
