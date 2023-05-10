package com.jangbogo.admin.dao;

import com.jangbogo.admin.domain.OrderDetailDto;
import com.jangbogo.admin.domain.OrderDto;
import com.jangbogo.admin.domain.OrderHistoryDto;
import com.jangbogo.admin.domain.SearchCondition;

import java.util.List;

public interface OrderDao {
    List<OrderDto> getList()                                                                                                                   // 반환타입 : List<OrderDto>
    ;

    List<OrderDetailDto> getOrderDetail(Integer order_idx)                                                                                                                   // 반환타입 : List<OrderDetailDto> - 매개변수 : Integer idx(주문번호)
    ;

    List<OrderHistoryDto> getOrderHistory(Integer idx)                                                                                                                   // 반환타입 : List<OrderHistoryDto> - 매개변수 : Integer idx
    ;

    int getSearchResultCnt(SearchCondition sc)                                                                                                                   // 반환타입 : int - 매개변수 : SearchCondition sc
    ;

    int getSearchPaidResultCnt(SearchCondition sc)                                                                                                                   // 반환타입 : int - 매개변수 : SearchCondition sc
    ;

    int getSearchDPResultCnt(SearchCondition sc)                                                                                                                   // 반환타입 : int  - 매개변수 : SearchCondition sc
    ;

    int getSearchDeliveringResultCnt(SearchCondition sc)                                                                                                                   // 반환타입 : int  - 매개변수 : SearchCondition sc
    ;

    List<OrderDto> getSearchSelectedPage(SearchCondition sc)                                                                                                                   // 반환타입 : List<OrderDto> - 매개변수 : SearchCondition sc
    ;

    List<OrderDto> getPaidList(SearchCondition sc)                                                                                                                   // 반환타입 : List<OrderDto> - 매개변수 : SearchCondition sc
    ;

    List<OrderDto> getSearchDPSelectPage(SearchCondition sc)                                                                                                                   // 반환타입 : List<OrderDto> - 매개변수 : SearchCondition sc
    ;

    List<OrderDto> getSearchDeliveringSelectPage(SearchCondition sc)                                                                                                                   // 반환타입 : List<OrderDto> - 매개변수 : SearchCondition sc
    ;

    int updateOrderState(Integer order_idx)                                                                                                                   // 반환타입 : int - 매개변수 : Integer order_idx
    ;

    int updateOrderDetailState(Integer order_idx)                                                                                                                   // 반환타입 : int - 매개변수 : Integer order_idx
    ;

    int insertOrderHistoryState(List<OrderDetailDto> orderDetails)                                                                                                                   // 반환타입 : int - 매개변수 : List<OrderDetailDto> orderDetails
    ;

    int updateWaybillNumber(String waybill_number, String order_idx)                                                                                                                   // 반환타입 : int - 매개변수 : Integer waybill_number, Integer idx
    ;

    int updateOrderStateDelivering(int order_idx)                                                                                                                   // 반환타입 : int - 매개변수 : Integer order_idx
    ;

    int updateOrderDetailStateDelivering(int order_idx)                                                                                                                   // 반환타입 : int - 매개변수 : Integer order_idx
    ;

    int insertOrderHistoryStateDelivering(List<OrderDetailDto> orderDetails)                                                                                                                   // 반환타입 : int - 매개변수 : List<OrderDetailDto> orderDetails
    ;

    int updateOrderStateDeliveryCompleted(int order_idx)                                                                                                                   // 반환타입 : int - 매개변수 : Integer order_idx
    ;

    int updateOrderDetailStateDeliveryCompleted(int order_idx)                                                                                                                   // 반환타입 : int - 매개변수 : Integer order_idx
    ;

    int insertOrderHistoryStateDeliveryCompleted(List<OrderDetailDto> orderDetails)                                                                                                                   // 반환타입 : int - 매개변수 : List<OrderDetailDto> orderDetails
    ;
}
