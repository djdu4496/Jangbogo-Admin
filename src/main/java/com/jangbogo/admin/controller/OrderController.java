package com.jangbogo.admin.controller;

import com.jangbogo.admin.domain.*;
import com.jangbogo.admin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

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
        List<OrderDetailDto> list = null;                                                                               // 변수명 : list - 저장값 : OrderDetailDto 저장소 List
        try {
            list = orderService.getOrderDetail(idx);                                                                    // orderService의 getList메서드 호출, 반환값을 list에 저장
            model.addAttribute("list", list);                                                              // Model에 list를 K/V로 저장
            model.addAttribute("idx", idx);                                                                // Model에 idx를 K/V로 저장
            return "/order/order";                                                                                      // "/order/order.jsp" 뷰 이름 반환 - 뷰 렌더링
        } catch(Exception e) {                                                                                          // 에러 발생 시
            e.printStackTrace();                                                                                        // 1) 에러 내용을 로그에 출력
            return "redirect:/";                                                                                        // 2) 메인 페이지로 리다이렉트
        }
    }

    // 메서드명 : getOrderHistory
    // 기   능 : 주문 이력 페이지 이동
    // 반환타입 : String
    // 매개변수 : @PathVariable Integer idx, Model model
    @GetMapping("/order/{idx}/history")
    public String getOrderHistory(@PathVariable Integer idx, Model model) {
        List<OrderHistoryDto> list = null;                                                                              // 변수명 : list - 저장값 : OrderHistoryDto 저장소 List
        try {
            list = orderService.getOrderHistory(idx);                                                                   // orderService의 getOrderHistory메서드 호출, 반환값을 list에 저장
            model.addAttribute("list", list);                                                              // Model에 list를 K/V로 저장
            model.addAttribute("idx", idx);                                                                // Model에 idx를 K/V로 저장
            return "/order/orderHistory";                                                                               // "/order/orderHistory.jsp" 뷰 이름 반환 - 뷰 렌더링
        } catch(Exception e) {                                                                                          // 에러 발생 시
            e.printStackTrace();                                                                                        // 1) 에러 내용을 로그에 출력
            return "redirect:/order/{idx}";                                                                             // 2) 주문상세 페이지로 리다이렉트
        }
    }

    // 메서드명 : getOrderPaidList
    // 기   능 : '결제완료'된 페이지 이동
    // 반환타입 : (Model model, SearchCondition sc
    @GetMapping("/order/list/paid")
    public String getOrderPaidList(Model model, SearchCondition sc) {
        List<OrderDto> list = null;                                                                                     // 변수명 : list - 저장값 : OrderDto 저장소 List
        try {
            int totalCnt = orderService.getSearchPaidResultCnt(sc);                                                     // 변수명 : totalCnt - 저장값 : 주문내역 목록 검색 결과 개수
            PageHandler pageHandler = new PageHandler(totalCnt, sc);                                                    // PageHandler 객체 생성(인자 - totalCnt, sc)
            list = orderService.getSearchPaidSelectPage(sc);                                                            // orderService의 getSearchSelectPage메서드 호출, 반환값을 list에 저장

            model.addAttribute("totalCnt", totalCnt);                                                      // Model에 totalCnt를 K/V로 저장
            model.addAttribute("list", list);                                                              // Model에 list를 K/V로 저장
            model.addAttribute("ph", pageHandler);                                                         // Model에 PageHandler를 K/V로 저장
            return "/order/orderPaid";                                                                                  // "/order/orderPaid.jsp" 뷰 이름 반환 - 뷰 렌더링
        } catch (Exception e) {                                                                                         // 에러 발생 시
            e.printStackTrace();                                                                                        // 1) 에러 내용을 로그에 출력
            return "redirect:/";                                                                                        // 2) 메인 페이지로 리다이렉트
        }
    }


    // 메서드명 : getOrderDeliveryPreparing
    // 기   능 : '배송준비중'인 주문 목록 페이지로 이동
    // 반환타입 : String
    // 매개변수 : Model model, SearchCondition sc
    @GetMapping("/order/list/deliveryPreparing")
    public String getOrderDeliveryPreparing(Model model, SearchCondition sc) {
        List<OrderDto> list = null;                                                                                     // 변수명 : list - 저장값 : OrderDto 저장소 List
        try {
            int totalCnt = orderService.getSearchDPResultCnt(sc);                                                       // 변수명 : totalCnt - 저장값 : orderService의 getSearchDPResultCnt(sc);
            PageHandler pageHandler = new PageHandler(totalCnt, sc);                                                    // 변수명 : pageHandler - 저장값 : PageHandler 객체(인자 : totalCnt, sc);
            list = orderService.getSearchDPSelectPage(sc);                                                              // orderService의 getSearchDPSelectPage메서드 호출, 반환값을 list에 저장

            model.addAttribute("totalCnt", totalCnt);                                                      // Model에 totalCnt를 K/V로 저장
            model.addAttribute("list", list);                                                              // Model에 list를 K/V로 저장
            model.addAttribute("ph", pageHandler);                                                         // Model에 PageHandler를 K/V로 저장
            return "/order/orderDeliveryPreparing";                                                                     // "/order/orderDeliveryPreparing.jsp" 뷰 이름 반환 - 뷰 렌더링
        } catch(Exception e) {                                                                                          // 에러 발생 시
            e.printStackTrace();                                                                                        // 1) 에러 내용을 로그에 출력
            return "redirect:/";                                                                                        // 2) 메인 페이지로 리다이렉트
        }
    }

    // 메서드명 : updateOrderState
    // 기   능 : '결제완료' 상태의 주문을 '배송준비중' 상태로 수정
    // 반환타입 : ResponseEntity<String>
    // 매개변수 : @PathVariable Integer order_idx
    // 요청URL : /order/list/paid/{order_idx} Patch
    @PatchMapping("/order/list/paid/{order_idx}")
    public ResponseEntity<String> updateOrderState(@PathVariable Integer order_idx) {
        int updateOrderRowCnt = 0;                                                                                      // 변수명 : updateOrderRowCnt - 저장값 : '주문' 테이블 데이터의 주문상태코드 수정 결과
        int updateOrderDetailRowCnt = 0;                                                                                // 변수명 : updateOrderDetailRowCnt - 저장값 : '주문상세' 테이블 데이터의 주문상태코드 수정 결과
        int insertOrderHistoryRowCnt = 0;                                                                               // 변수명 : insertOrderHistoryRowCnt - 저장값 : '주문이력' 테이블 데이터의 주문상태코드 수정 결과

        List<OrderDetailDto> orderDetails = null;                                                                       // 변수명 : orderDetails - 저장값 : '주문상세' 테이블에 데이터 리스트 저장

        try {
            updateOrderRowCnt = orderService.updateOrderState(order_idx);                                               // 주문번호가 #{order_idx}에 해당하는 주문의 주문상태코드 수정 결과를 변수 updateOrderRowCnt에 저장
            if(updateOrderRowCnt == 0) throw new Exception("updateOrderState failed(ORD)");                             // 변경된 행의 개수가 0인 경우 예외를 발생시킨다.

            updateOrderDetailRowCnt = orderService.updateOrderDetailState(order_idx);                                   // 주문번호가 #{order_idx}에 해당하는 주문상세의 주문상태코드 수정 결과를 변수 updateOrderRowCnt에 저장
            if(updateOrderDetailRowCnt == 0) throw new Exception("updateOrderState failed(ORD_DTL)");                   // 변경된 행의 개수가 0인 경우 예외를 발생시킨다.

            orderDetails = orderService.getOrderDetail(order_idx);                                                      // 주문번호가 #{order_idx}에 해당하는 주문의 '주문상세' 데이터를 변수 orderDetails에 저장

            insertOrderHistoryRowCnt = orderService.insertOrderHistoryState(orderDetails);                              // 주문번호가 #{order_idx}에 해당하는 주문이력의 주문상태코드 수정 결과를 변수 updateOrderRowCnt에 저장
            if(insertOrderHistoryRowCnt == 0) throw new Exception("insertOrderState failed(ORD_HIST)");                 // 변경된 행의 개수가 0인 경우 예외를 발생시킨다.

            return new ResponseEntity<>("STATE_MOD_OK", HttpStatus.OK);                                           // 모든 update 요청 결과가 성공인 경우, 상태코드와 함께 메시지 반환
        } catch(Exception e) {                                                                                          // 에러 발생 시
            e.printStackTrace();                                                                                        // 1) 에러 내용을 로그에 출력
            return new ResponseEntity<>("STATE_MOD_ERR", HttpStatus.BAD_REQUEST);                                 // 2) update 요청 결과가 실패인 경우, 상태코드와 함께 메시지 반환
        }
    }

    // 메서드명 : deliveryForm
    // 기   능 : '운송장번호' 입력 폼으로 이동
    // 반환타입 : String
    // 매개변수 :
    // 요청URL : /order/{idx}/deliveryForm GET
    @GetMapping("/order/{idx}/deliveryForm")
    public String deliveryForm(@PathVariable int idx) {
        return "/order/deliveryForm";
    }

    // 메서드명 : addWaybillNumber
    // 기   능 : '운송장번호' #{waybill_number}를 주문번호가 #{order_idx}인 주문에 해당하는 배송 데이터에 삽입
    // 반환타입 : String
    // 매개변수 : String waybill_number, Integer idx
    @PatchMapping("/order/deliveryForm/{waybill_number}/{order_idx}")
    public ResponseEntity<String> addWaybillNumber(@PathVariable Map<String, String> pathVarsMap) {
        String waybill_number = pathVarsMap.get("waybill_number");
        String order_idx = pathVarsMap.get("order_idx");
        int rowCnt = 0;                                                                                                 // 변수명 : rowCnt - 저장값 : '배송' 테이블 데이터의 운송장번호(WYBL) 삽입 결과

        try {
            rowCnt = orderService.updateWaybillNumber(waybill_number, order_idx);                                       // 주문번호가 #{idx}에 해당하는 주문의 '배송' 데이터에 운송장번호 삽입 결과를 변수 rowCnt 저장
            if(rowCnt == 0) throw new Exception("updateWaybillNumber failed(DLVRY)");                                   // 변경된 행의 개수가 0인 경우 예외를 발생시킨다.
            return new ResponseEntity<>("WYBL_ADD_OK", HttpStatus.OK);                                            // update 요청 결과가 성공인 경우, 상태코드와 함께 메시지 반환
        } catch (Exception e) {                                                                                         // 에러 발생 시
            e.printStackTrace();                                                                                        // 1) 에러 내용을 로그에 출력
            return new ResponseEntity<>("WYBL_ADD_ERR", HttpStatus.BAD_REQUEST);                                  // 2) update 요청 결과가 실패인 경우, 상태코드와 함께 메시지 반환
        }

    }

    // 메서드명 : updateOrderStateDelivering
    // 기   능 : '배송준비중' 상태의 주문을 '배송중' 상태로 수정
    // 반환타입 : ResponseEntity<String>
    // 매개변수 : Integer order_idx
    // 요청URL : /order/delivering/{order_idx} PATCH
    @PatchMapping("/order/delivering/{order_idx}")
    public ResponseEntity<String> updateOrderStateDelivering(@PathVariable int order_idx) {
        int updateOrderRowCnt = 0;                                                                                      // 변수명 : updateOrderRowCnt - 저장값 : '주문' 테이블 데이터의 주문상태코드 수정 결과
        int updateOrderDetailRowCnt = 0;                                                                                // 변수명 : updateOrderDetailRowCnt - 저장값 : '주문상세' 테이블 데이터의 주문상태코드 수정 결과
        int insertOrderHistoryRowCnt = 0;                                                                               // 변수명 : insertOrderHistoryRowCnt - 저장값 : '주문이력' 테이블 데이터의 주문상태코드 수정 결과

        List<OrderDetailDto> orderDetails = null;

        try {
            updateOrderRowCnt = orderService.updateOrderStateDelivering(order_idx);                                     // 주문번호가 #{order_idx}에 해당하는 주문의 주문상태코드 수정 결과를 변수 updateOrderRowCnt에 저장
            if(updateOrderRowCnt == 0) throw new Exception("updateOrderState failed(ORD)");                             // 변경된 행의 개수가 0인 경우 예외를 발생시킨다.

            updateOrderDetailRowCnt = orderService.updateOrderDetailStateDelivering(order_idx);                         // 주문번호가 #{order_idx}에 해당하는 주문상세의 주문상태코드 수정 결과를 변수 updateOrderRowCnt에 저장
            if(updateOrderDetailRowCnt == 0) throw new Exception("updateOrderState failed(ORD_DTL)");                   // 변경된 행의 개수가 0인 경우 예외를 발생시킨다.

            orderDetails = orderService.getOrderDetail(order_idx);                                                      // 주문번호가 #{order_idx}에 해당하는 주문의 '주문상세' 데이터를 변수 orderDetails에 저장

            insertOrderHistoryRowCnt = orderService.insertOrderHistoryStateDelivering(orderDetails);                    // 주문번호가 #{order_idx}에 해당하는 주문이력의 주문상태코드 수정 결과를 변수 updateOrderRowCnt에 저장
            if(insertOrderHistoryRowCnt == 0) throw new Exception("insertOrderState failed(ORD_HIST)");                 // 변경된 행의 개수가 0인 경우 예외를 발생시킨다.

            return new ResponseEntity<>("STATE_MOD_OK", HttpStatus.OK);                                           // 모든 update 요청 결과가 성공인 경우, 상태코드와 함께 메시지 반환
        } catch(Exception e) {                                                                                          // 에러 발생 시
            e.printStackTrace();                                                                                        // 1) 에러 내용을 로그에 출력
            return new ResponseEntity<>("STATE_MOD_ERR", HttpStatus.BAD_REQUEST);                                 // 2) update 요청 결과가 실패인 경우, 상태코드와 함께 메시지 반환
        }
    }
}