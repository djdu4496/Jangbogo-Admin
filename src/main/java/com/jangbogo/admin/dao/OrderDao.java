package com.jangbogo.admin.dao;

import com.jangbogo.admin.domain.OrderDetailDto;
import com.jangbogo.admin.domain.OrderDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDao {
    @Autowired SqlSession session;                                                                                      // SqlSession 자동 주입

    private static String namespace="com.jangbogo.admin.dao.OrderMapper.";                                              // 대소문자 구분X

    public List<OrderDto> getList() {                                                                                   // 메서드명 : getList
        return session.selectList(namespace + "selectList");                                                         // 기   능 : orderMapper.xml에 있는 SQL문을 실행하여 List<OrderDto>를 반환
    }                                                                                                                   // 반환타입 : OrderDto<List>

    public List<OrderDetailDto> getOrder() {                                                                                        // 메서드명 : getOrder
        return session.selectList(namespace + "selectOrder");                                                         // 기   능 :
    }                                                                                                                   // 반환타입 : OrderDto
}
