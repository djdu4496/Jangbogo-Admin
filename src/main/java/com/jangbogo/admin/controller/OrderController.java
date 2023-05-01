package com.jangbogo.admin.controller;

import com.jangbogo.admin.domain.*;
import com.jangbogo.admin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    // 메서드명 : getList
    // 기   능 : 주문 목록 가져오기
    // 매개변수 : Model model
    // 반환타입 : String
    @GetMapping("/order/list")
    public String getList(Model model, SearchCondition sc) {
        List<OrderDto> list = null;                                                                                     // 변수명 : list - 저장값 : OrderDto 저장소 List
        try {
            int totalCnt = orderService.getSearchResultCnt(sc);                                                         // 변수명 : totalCnt - 저장값 : 주문내역 목록 검색 결과 개수
            PageHandler pageHandler = new PageHandler(totalCnt, sc);                                                    // PageHandler 객체 생성(인자 - totalCnt, sc)
            list = orderService.getSearchSelectPage(sc);                                                                // orderService의 getSearchSelectPage메서드 호출, 반환값을 list에 저장

            model.addAttribute("totalCnt", totalCnt);                                                      // Model에 totalCnt를 K/V로 저장
            model.addAttribute("list", list);                                                              // Model에 list를 K/V로 저장
            model.addAttribute("ph", pageHandler);                                                         // Model에 PageHandler를 K/V로 저장
            return "/order/orderList";
        } catch (Exception e) {                                                                                         // 에러 발생 시
            e.printStackTrace();                                                                                        // 1) 에러 내용을 로그에 출력
            return "redirect:/";                                                                                        // 2) 메인 페이지로 리다이렉트
        }
    }

    // 메서드명 : getOrder
    // 기   능 : 주문 상세 페이지 이동
    // 반환타입 : String
    // 매개변수 : @PathVariable Integer idx, Model model
    @GetMapping("/order/{idx}")
    public String getOrder(@PathVariable Integer idx, Model model) {
        List<OrderDetailDto> list = null;                                                                               // 변수명 : list - 저장값 : OrderDto 저장소 List
        try {
            list = orderService.getOrder();                                                                             // orderService의 getList메서드 호출, 반환값을 list에 저장
            model.addAttribute("list", list);
            model.addAttribute("idx", idx);
            return "/order/order";
        } catch(Exception e) {
            e.printStackTrace();
            return "redirect:/";
        }
    }

    // 메서드명 : getOrderHistory
    // 기   능 : 주문 이력 페이지 이동
    // 반환타입 : String
    // 매개변수 :
    @GetMapping("/order/{idx}/history")
    public String getOrderHistory(@PathVariable Integer idx, Model model) {
        List<OrderHistoryDto> list = null;                                                                              // 변수명 : list - 저장값 : OrderHistoryDto 저장소 List
        try {
            list = orderService.getOrderHistory(idx);
            model.addAttribute("list", list);
            model.addAttribute("idx", idx);
            return "/order/orderHistory";
        } catch(Exception e) {
            e.printStackTrace();
            return "redirect:/order/{idx}";
        }
    }

    // 메서드명 : getOrderPaidList
    // 기   능 : '결제완료'된 페이지 이동
    // 반환타입 : String
    @GetMapping("/order/list/paid")
    public String getOrderPaidList(Model model, SearchCondition sc) {
        List<OrderDto> list = null;                                                                                     // 변수명 : list - 저장값 : OrderDto 저장소 List
        try {
            int totalCnt = orderService.getSearchPaidResultCnt(sc);                                                     // 변수명 : totalCnt - 저장값 : 주문내역 목록 검색 결과 개수
            PageHandler pageHandler = new PageHandler(totalCnt, sc);                                                    // PageHandler 객체 생성(인자 - totalCnt, sc)
            list = orderService.getSearchPaidSelectPage(sc);                                                                // orderService의 getSearchSelectPage메서드 호출, 반환값을 list에 저장

            model.addAttribute("totalCnt", totalCnt);                                                      // Model에 totalCnt를 K/V로 저장
            model.addAttribute("list", list);                                                              // Model에 list를 K/V로 저장
            model.addAttribute("ph", pageHandler);                                                         // Model에 PageHandler를 K/V로 저장
            return "/order/orderPaid";
        } catch (Exception e) {                                                                                         // 에러 발생 시
            e.printStackTrace();                                                                                        // 1) 에러 내용을 로그에 출력
            return "redirect:/";                                                                                        // 2) 메인 페이지로 리다이렉트
        }
    }
    // 메서드명 : updateOrderState
    // 기   능 : '결제완료' 상태의 주문을 '배송준비중' 상태로 수정
    // 반환타입 :
    @PatchMapping("/order/list/paid/{order_idx}")
    public ResponseEntity<String> updateOrderState(@PathVariable int order_idx) {
        int updateOrderRowCnt = 0;
        int updateOrderDetailRowCnt = 0;
        int insertOrderHistoryRowCnt = 0;

        List<OrderDetailDto> orderDetails = null;                                                                       // 변수명 : orderDetails - 저장값 : '주문상세' 테이블에 데이터 리스트 저장

        try {
            updateOrderRowCnt = orderService.updateOrderState(order_idx);
            if(updateOrderRowCnt == 0) throw new Exception("updateOrderState failed(ORD)");

            updateOrderDetailRowCnt = orderService.updateOrderDetailState(order_idx);
            if(updateOrderDetailRowCnt == 0) throw new Exception("updateOrderState failed(ORD_DTL)");

            orderDetails = orderService.getOrderDetail(order_idx);

            insertOrderHistoryRowCnt = orderService.insertOrderHistoryState(orderDetails);
            if(insertOrderHistoryRowCnt == 0) throw new Exception("insertOrderState failed(ORD_HIST)");

            return new ResponseEntity<>("STATE_MOD_OK", HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("STATE_MOD_ERR", HttpStatus.BAD_REQUEST);
        }
    }

}