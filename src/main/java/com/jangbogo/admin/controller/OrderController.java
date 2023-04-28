package com.jangbogo.admin.controller;

import com.jangbogo.admin.domain.OrderDetailDto;
import com.jangbogo.admin.domain.OrderDto;
import com.jangbogo.admin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String getList(Model model) {
        List<OrderDto> list = null;                                                                                     // 변수명 : list - 저장값 : OrderDto 저장소 List
        try {
            list = orderService.getList();                                                                              // orderService의 getList메서드 호출, 반환값을 list에 저장
            model.addAttribute("list", list);
            System.out.println("list = " + list);
            return "/order/orderList";
        } catch (Exception e) {                                                                                         // 에러 발생 시
            e.printStackTrace();                                                                                        // 1) 에러 내용을 로그에 출력
            return "redirect:/";
        }
    }

    // 메서드명 : getOrder
    // 기   능 : 주문 상세 페이지 이동
    // 반환타입 : String
    // 매개변수 : @PathVariable Integer idx, Model model
    @GetMapping("/order/{idx}")
    public String getOrder(@PathVariable Integer idx, Model model) {
        List<OrderDetailDto> list = null;                                                                                     // 변수명 : list - 저장값 : OrderDto 저장소 List
        try {
            list = orderService.getOrder();                                                                             // orderService의 getList메서드 호출, 반환값을 list에 저장
            model.addAttribute("list", list);
            System.out.println("list = " + list);
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
    public String getOrderHistory() {
        return "/order/orderHistory";
    };
}