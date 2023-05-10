package com.jangbogo.admin.service;

import com.jangbogo.admin.domain.OrderDetailDto;
import com.jangbogo.admin.domain.OrderDto;
import com.jangbogo.admin.domain.OrderHistoryDto;
import com.jangbogo.admin.domain.SearchCondition;

import java.util.List;

public interface OrderService {
    // 메서드명 : getList
    // 기   능 : OrderDao의 getList메서드 호출 - 전체주문조회
    // 반환타입 : List<OrderDto>
    public List<OrderDto> getList();

    // 메서드명 : getOrderDetail
    // 기   능 : orderDao의 getOrderDetail 호출 - 주문상세조회
    // 반환타입 : List<OrderDetailDto>
    // 매개변수 : Integer order_idx
    public List<OrderDetailDto> getOrderDetail(Integer order_idx);

    // 메서드명 : getOrderHistory
    // 기   능 : OrderDao의 getOrder메서드 호출 - 주문이력조회
    // 반환타입 : List<OrderHistoryDto>
    // 매개변수 : Integer idx
    public List<OrderHistoryDto> getOrderHistory(Integer idx);

    // 메서드명 : getSearchResultCnt
    // 기   능 : OrderDao의 getSearchResultCnt메서드 호출 - '전체주문' 검색결과목록 수 조회
    // 반환타입 : int
    // 매개변수 : SearchCondition sc
    public int getSearchResultCnt(SearchCondition sc);

    // 메서드명 : getSearchPaidResultCnt
    // 기   능 : OrderDao의 getSearchResultCnt메서드 호출 - '결제완료 상태인 주문' 검색결과목록 수 조회
    // 반환타입 : int
    // 매개변수 : SearchCondition sc
    public int getSearchPaidResultCnt(SearchCondition sc);

    // 메서드명 : getSearchDPResultCnt
    // 기   능 : orderDao의 getSearchDPResultCnt 호출 - '배송준비중 상태인 주문' 검색결과목록 수 조회
    // 반환타입 : int
    // 매개변수 : SearchCondition sc
    public int getSearchDPResultCnt(SearchCondition sc);

    // 메서드명 : getSearchDeliveringResultCnt
    // 기   능 : orderDao의 getSearchDeliveringResultCnt 호출 - '배송중 상태인 주문' 검색결과목록 수 조회
    // 반환타입 : int
    // 매개변수 : SearchCondition sc
    public int getSearchDeliveringResultCnt(SearchCondition sc);

    // 메서드명 : getSearchSelectPage
    // 기   능 : orderDao의 getSearchSelectPage메서드 호출 - '전체주문' 검색결과목록 조회
    // 반환타입 : List<OrderDto>
    // 매개변수 : SearchCondition sc
    public List<OrderDto> getSearchSelectPage(SearchCondition sc);

    // 메서드명 : getSearchPaidSelectPage
    // 기   능 : orderDao의 getPaidList메서드 호출 - '결제완료 상태인 주문' 검색결과목록 조회
    // 반환타입 : List<OrderDto>
    // 매개변수 : SearchCondition sc
    public List<OrderDto> getSearchPaidSelectPage(SearchCondition sc);

    // 메서드명 : getSearchDPSelectPage
    // 기   능 : orderDao의 getSearchDPSelectPage메서드 호출 - '배송준비중 상태인 주문' 검색결과목록 조회
    // 반환타입 : List<OrderDto>
    // 매개변수 : SearchCondition sc
    public List<OrderDto> getSearchDPSelectPage(SearchCondition sc);

    // 메서드명 : getSearchDeliveringSelectPage
    // 기   능 : orderDao의 getSearchDeliveringSelectPage메서드 호출 - '배송중 상태인 주문' 검색결과목록 조회
    // 반환타입 : List<OrderDto>
    // 매개변수 : SearchCondition sc
    public List<OrderDto> getSearchDeliveringSelectPage(SearchCondition sc);

    // 메서드명 : updateOrderState
    // 기   능 : orderDao의 updateOrderState 호출 - '결제완료 상태인 주문'을 '배송준비중 상태인 주문'으로 수정 요청
    // 반환타입 : int
    // 매개변수 : Integer order_idx
    public int updateOrderState(Integer order_idx);

    // 메서드명 : updateOrderDetailState
    // 기   능 : orderDao의 updateOrderDetailState 호출 -  '결제완료 상태인 주문상세'을 '배송준비중 상태인 주문상세'로 수정 요청
    // 반환타입 : int
    // 매개변수 : Integer order_idx
    public int updateOrderDetailState(Integer order_idx);

    // 메서드명 : insertOrderHistoryState
    // 기   능 : orderDao의 insertOrderHistoryState 호출 -  '결제완료 상태인 주문이력'을 '배송준비중 상태인 주문이력'로 수정 이력 삽입
    // 반환타입 : int
    // 매개변수 : List<OrderDetailDto>
    public int insertOrderHistoryState(List<OrderDetailDto> orderDetails);

    // 메서드명 : updateOrderStateDelivering
    // 기   능 : orderDao의 updateOrderStateDelivering 호출 - '배송준비중 상태인 주문'을 '배송중 상태인 주문'으로 수정 요청
    // 반환타입 : int
    // 매개변수 : Integer order_idx
    public int updateOrderStateDelivering(int order_idx);

    // 메서드명 : updateOrderDetailStateDelivering
    // 기   능 : orderDao의 updateOrderDetailStateDelivering 호출 - '배송준비중 상태인 주문'을 '배송중 상태인 주문'으로 수정 요청
    // 반환타입 : int
    // 매개변수 : Integer order_idx
    public int updateOrderDetailStateDelivering(int order_idx);

    // 메서드명 : insertOrderHistoryStateDelivering
    // 기   능 : orderDao의 insertOrderHistoryStateDelivering 호출 - '배송준비중 상태인 주문'을 '배송중 상태인 주문'으로 수정 이력 삽입
    // 반환타입 : int
    // 매개변수 : Integer order_idx
    public int insertOrderHistoryStateDelivering(List<OrderDetailDto> orderDetails);

    // 메서드명 : updateOrderStateDeliveryCompleted
    // 기   능 : orderDao의 updateOrderStateDeliveryCompleted 호출 - '배송중 상태인 주문'을 '배송완료 상태인 주문'으로 수정 요청
    // 반환타입 : int
    // 매개변수 : Integer order_idx
    public int updateOrderStateDeliveryCompleted(int order_idx);

    // 메서드명 : updateOrderDetailStateDeliveryCompleted
    // 기   능 : orderDao의 updateOrderDetailStateDeliveryCompleted 호출 - '배송중 상태인 주문'을 '배송완료 상태인 주문'으로 수정 요청
    // 반환타입 : int
    // 매개변수 : Integer order_idx
    public int updateOrderDetailStateDeliveryCompleted(int order_idx);

    // 메서드명 : insertOrderHistoryStateDeliveryCompleted
    // 기   능 : orderDao의 insertOrderHistoryStateDeliveryCompleted 호출 - '배송중 상태인 주문'을 '배송완료 상태인 주문'으로 수정 이력 삽입
    // 반환타입 : int
    // 매개변수 : Integer order_idx
    public int insertOrderHistoryStateDeliveryCompleted(List<OrderDetailDto> orderDetails);

    // 메서드명 : updateWaybillNumber
    // 기   능 : orderDao의 updateWaybillNumber 호출 -  운송장번호 #{waybill_number}를 '배송'테이블 데이터에 삽입
    // 반환타입 : int
    // 매개변수 : String waybill_number, String order_idx
    public int updateWaybillNumber(String waybill_number, String order_idx);
}
