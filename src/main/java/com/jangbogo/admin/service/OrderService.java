package com.jangbogo.admin.service;

import com.jangbogo.admin.dao.OrderDao;
import com.jangbogo.admin.domain.OrderDto;
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
}