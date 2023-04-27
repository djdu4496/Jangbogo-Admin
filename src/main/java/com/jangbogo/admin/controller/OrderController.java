package com.jangbogo.admin.controller;

import com.jangbogo.admin.domain.OrderDto;
import com.jangbogo.admin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}