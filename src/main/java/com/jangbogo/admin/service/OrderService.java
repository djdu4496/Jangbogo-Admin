package com.jangbogo.admin.service;

import com.jangbogo.admin.dao.OrderDao;
import com.jangbogo.admin.domain.OrderDetailDto;
import com.jangbogo.admin.domain.OrderDto;
import com.jangbogo.admin.domain.OrderHistoryDto;
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
}