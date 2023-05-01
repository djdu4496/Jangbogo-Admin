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

    // 메서드명 : getOrder
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

    // 메서드명 : getSearchSelectPage
    // 기   능 : orderDao의 getSearchSelectPage메서드 호출
    // 반환타입 : List<OrderDto>
    // 매개변수 : SearchCondition sc
    public List<OrderDto> getSearchSelectPage(SearchCondition sc) { return orderDao.getSearchSelectedPage(sc);}

    // 메서드명 : getOrderPaidList
    // 기   능 : orderDao의 getOrderPaidList메서드 호출
    // 반환타입 : List<OrderDto>
    // 매개변수 : SearchCondition sc
    public List<OrderDto> getOrderPaidList(SearchCondition sc) { return orderDao.getPaidList(sc); }
}