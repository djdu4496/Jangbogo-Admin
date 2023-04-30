package com.jangbogo.admin.dao;

import com.jangbogo.admin.domain.OrderDetailDto;
import com.jangbogo.admin.domain.OrderDto;
import com.jangbogo.admin.domain.OrderHistoryDto;
import com.jangbogo.admin.domain.SearchCondition;
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
    }                                                                                                                   // 반환타입 : List<OrderDto>

    public List<OrderDetailDto> getOrder() {                                                                            // 메서드명 : getOrder
        return session.selectList(namespace + "selectOrder");                                                        // 기   능 : orderMapper.xml에 있는 SQL문을 실행하여 OrderDto 반환
    }                                                                                                                   // 반환타입 : List<OrderDetailDto>

    public List<OrderHistoryDto> getOrderHistory(Integer idx) {                                                         // 메서드명 : getOrderHistory
        return session.selectList(namespace + "selectOrderHistory", idx);                                            // 기   능 : orderMapper.xml에 있는 SQL문을 실행하여 List<OrderHistoryDto> 반환
    }                                                                                                                   // 반환타입 : List<OrderHistoryDto> - 매개변수 : Integer idx

    public int getSearchResultCnt(SearchCondition sc) {                                                                 // 메서드명 : getSearchResultCnt
        return session.selectOne(namespace + "selectResultCnt", sc);                                                 // 기   능 : orderMapper.xml에 있는 SQL문을 실행하여 주문내역 수 조회 결과 반환
    }                                                                                                                   // 반환타입 : int - 매개변수 : SearchCondition sc

    public List<OrderDto> getSearchSelectedPage(SearchCondition sc) {                                                   // 메서드명 : getSearchSelectedPage
        return session.selectList(namespace + "selectSelectedPage", sc);                                             // 기   능 : orderMapper.xml에 있는 SQL문을 실행하여 주문내역 목록 조회 결과 반환
    }                                                                                                                   // 반환타입 : List<OrderDto> - 매개변수 : SearchCondition sc

}
