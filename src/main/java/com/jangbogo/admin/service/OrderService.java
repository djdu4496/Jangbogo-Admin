package com.jangbogo.admin.service;

import com.jangbogo.admin.dao.OrderDao;
import com.jangbogo.admin.domain.OrderDetailDto;
import com.jangbogo.admin.domain.OrderDto;
import com.jangbogo.admin.domain.OrderHistoryDto;
import com.jangbogo.admin.domain.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired OrderDao orderDao;

    // 메서드명 : getList
    // 기   능 : OrderDao의 getList메서드 호출
    // 반환타입 : List<OrderDto>
    // 매개변수 :
    public List<OrderDto> getList() {
        return orderDao.getList();
    }

    // 메서드명 : getOrder
    // 기   능 : OrderDao의 getOrder메서드 호출
    // 반환타입 : List<OrderDto>
    public List<OrderDetailDto> getOrder() { return orderDao.getOrder();}

    // 메서드명 : getOrderHistory
    // 기   능 : OrderDao의 getOrder메서드 호출
    // 반환타입 : List<OrderDto>
    // 매개변수 : Integer idx
    public List<OrderHistoryDto> getOrderHistory(Integer idx) {
        return orderDao.getOrderHistory(idx);
    }

    // 메서드명 : getSearchResultCnt
    // 기   능 : OrderDao의 getSearchResultCnt메서드 호출
    // 반환타입 : int
    // 매개변수 : SearchCondition sc
    public int getSearchResultCnt(SearchCondition sc) { return orderDao.getSearchResultCnt(sc); }

    // 메서드명 : getSearchPaidResultCnt
    // 기   능 : OrderDao의 getSearchResultCnt메서드 호출
    // 반환타입 : int
    // 매개변수 : SearchCondition sc
    public int getSearchPaidResultCnt(SearchCondition sc) { return orderDao.getSearchPaidResultCnt(sc); }


    // 메서드명 : getSearchSelectPage
    // 기   능 : orderDao의 getSearchSelectPage메서드 호출
    // 반환타입 : List<OrderDto>
    // 매개변수 : SearchCondition sc
    public List<OrderDto> getSearchSelectPage(SearchCondition sc) { return orderDao.getSearchSelectedPage(sc);}

    // 메서드명 : getSearchPaidSelectPage
    // 기   능 : orderDao의 getOrderPaidList메서드 호출
    // 반환타입 : List<OrderDto>
    // 매개변수 : SearchCondition sc
    public List<OrderDto> getSearchPaidSelectPage(SearchCondition sc) { return orderDao.getPaidList(sc); }

    // 메서드명 : updateOrderState
    // 기   능 : orderDao의 updateOrderState 호출
    // 반환타입 : int
    // 매개변수 : Integer order_idx
    public int updateOrderState(Integer order_idx) {return orderDao.updateOrderState(order_idx);}

    // 메서드명 : updateOrderDetailState
    // 기   능 : orderDao의 updateOrderDetailState 호출
    // 반환타입 : int
    // 매개변수 : Integer order_idx
    public int updateOrderDetailState(Integer order_idx) {return orderDao.updateOrderDetailState(order_idx);}

    // 메서드명 : insertOrderHistoryState
    // 기   능 : orderDao의 insertOrderHistoryState 호출
    // 반환타입 : int
    // 매개변수 : List<OrderDetailDto>
    public int insertOrderHistoryState(List<OrderDetailDto> orderDetails) {return orderDao.insertOrderHistoryState(orderDetails);}

    // 메서드명 : getOrderDetail
    // 기   능 : orderDao의 getOrderDetail 호출
    // 반환타입 : List<OrderDetailDto>
    // 매개변수 : Integer order_idx
    public List<OrderDetailDto> getOrderDetail(Integer order_idx) {
        return orderDao.getOrderDetail(order_idx);
    }
}