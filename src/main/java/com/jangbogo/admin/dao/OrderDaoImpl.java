package com.jangbogo.admin.dao;

import com.jangbogo.admin.domain.OrderDetailDto;
import com.jangbogo.admin.domain.OrderDto;
import com.jangbogo.admin.domain.OrderHistoryDto;
import com.jangbogo.admin.domain.SearchCondition;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired SqlSession session;                                                                                      // SqlSession 자동 주입

    private static String namespace="com.jangbogo.admin.dao.OrderMapper.";                                              // 대소문자 구분X

    @Override
    public List<OrderDto> getList() {                                                                                   // 메서드명 : getList
        return session.selectList(namespace + "selectList");                                                            // 기   능 : orderMapper.xml에 있는 SQL문을 실행하여 List<OrderDto>를 반환
    }                                                                                                                   // 반환타입 : List<OrderDto>

    @Override
    public List<OrderDetailDto> getOrderDetail(Integer order_idx) {                                                     // 메서드명 : getOrderDetail
        return session.selectList(namespace + "selectOrderDetails", order_idx);                                         // 기   능 : orderMapper.xml에 있는 SQL문을 실행하여 주문번호가 #{order_idx}인 주문상세 리스트 조회
    }                                                                                                                   // 반환타입 : List<OrderDetailDto> - 매개변수 : Integer idx(주문번호)

    @Override
    public List<OrderHistoryDto> getOrderHistory(Integer idx) {                                                         // 메서드명 : getOrderHistory
        return session.selectList(namespace + "selectOrderHistory", idx);                                               // 기   능 : orderMapper.xml에 있는 SQL문을 실행하여 List<OrderHistoryDto> 반환
    }                                                                                                                   // 반환타입 : List<OrderHistoryDto> - 매개변수 : Integer idx

    @Override
    public int getSearchResultCnt(SearchCondition sc) {                                                                 // 메서드명 : getSearchResultCnt
        return session.selectOne(namespace + "selectResultCnt", sc);                                                    // 기   능 : orderMapper.xml에 있는 SQL문을 실행하여 주문내역 수 조회 결과 반환
    }                                                                                                                   // 반환타입 : int - 매개변수 : SearchCondition sc

    @Override
    public int getSearchPaidResultCnt(SearchCondition sc) {                                                             // 메서드명 : getSearchPaidResultCnt
        return session.selectOne(namespace + "selectPaidResultCnt", sc);                                                // 기   능 : orderMapper.xml에 있는 SQL문을 실행하여 상태코드가 1인 주문내역 수 조회 결과 반환
    }                                                                                                                   // 반환타입 : int - 매개변수 : SearchCondition sc

    @Override
    public int getSearchDPResultCnt(SearchCondition sc) {                                                               // 메서드명 : getSearchDPResultCnt
        return session.selectOne(namespace + "selectDPResultCnt", sc);                                                  // 기   능 : orderMapper.xml에 있는 SQL문을 실행하여 상태코드가 2인 주문내역 수 조회 결과 반환
    }                                                                                                                   // 반환타입 : int  - 매개변수 : SearchCondition sc

    @Override
    public int getSearchDeliveringResultCnt(SearchCondition sc) {                                                       // 메서드명 : getSearchDeliveringResultCnt
        return session.selectOne(namespace + "selectDeliveringCnt", sc);                                                // 기   능 : orderMapper.xml에 있는 SQL문을 실행하여 상태코드가 3인 주문내역 수 조회 결과 반환
    }                                                                                                                   // 반환타입 : int  - 매개변수 : SearchCondition sc

    @Override
    public List<OrderDto> getSearchSelectedPage(SearchCondition sc) {                                                   // 메서드명 : getSearchSelectedPage
        return session.selectList(namespace + "selectSelectedPage", sc);                                                // 기   능 : orderMapper.xml에 있는 SQL문을 실행하여 주문내역 목록 조회 결과 반환
    }                                                                                                                   // 반환타입 : List<OrderDto> - 매개변수 : SearchCondition sc

    @Override
    public List<OrderDto> getPaidList(SearchCondition sc) {                                                             // 메서드명 : getPaidList
        return session.selectList(namespace + "selectPaidList", sc);                                                    // 기   능 : orderMapper.xml에 있는 SQL문을 실행하여 상태코드가 1인 주문내역 목록 조회 결과 반환
    }                                                                                                                   // 반환타입 : List<OrderDto> - 매개변수 : SearchCondition sc

    @Override
    public List<OrderDto> getSearchDPSelectPage(SearchCondition sc) {                                                   // 메서드명 : getSearchDPSelectPage
        return session.selectList(namespace + "selectDPList", sc);                                                      // 기   능 : orderMapper.xml에 있는 SQL문을 실행하여 상태코드가 2인 주문내역 목록 조회 결과 반환
    }                                                                                                                   // 반환타입 : List<OrderDto> - 매개변수 : SearchCondition sc

    @Override
    public List<OrderDto> getSearchDeliveringSelectPage(SearchCondition sc) {                                           // 메서드명 : getSearchDeliveringSelectPage
        return session.selectList(namespace + "selectDeliveringList", sc);                                              // 기   능 : orderMapper.xml에 있는 SQL문을 실행하여 상태코드가 3인 주문내역 목록 조회 결과 반환
    }                                                                                                                   // 반환타입 : List<OrderDto> - 매개변수 : SearchCondition sc

    @Override
    public int updateOrderState(Integer order_idx) {                                                                    // 메서드명 : updateOrderState
        return session.update(namespace + "updatePaidOrder", order_idx);                                                // 기   능 : orderMapper.xml에 있는 SQL문을 실행하여 상태코드가 1인 주문에 대해 상태코드 2로 수정
    }                                                                                                                   // 반환타입 : int - 매개변수 : Integer order_idx

    @Override
    public int updateOrderDetailState(Integer order_idx) {                                                              // 메서드명 : updateOrderDetailState
        return session.update(namespace + "updatePaidOrderDetail", order_idx);                                          // 기   능 : orderMapper.xml에 있는 SQL문을 실행하여 상태코드가 1인 주문상세에 대해 상태코드 2로 수정
    }                                                                                                                   // 반환타입 : int - 매개변수 : Integer order_idx

    @Override
    public int insertOrderHistoryState(List<OrderDetailDto> orderDetails) {                                             // 메서드명 : insertOrderHistoryState
        return session.insert(namespace + "insertPaidOrderHistory", orderDetails);                                      // 기   능 : orderMapper.xml에 있는 SQL문을 실행하여 상태코드가 1인 주문이력에 대해 상태코드 2로 수정한 이력 삽입
    }                                                                                                                   // 반환타입 : int - 매개변수 : List<OrderDetailDto> orderDetails

    @Override
    public int updateWaybillNumber(String waybill_number, String order_idx) {                                           // 메서드명 : insertWaybillNumber
        Map map = new HashMap();                                                                                        // 변수명 : map - 저장값 : HashMap 객체(K/V 저장소)
        map.put("waybill", waybill_number);                                                                             // map에 waybill_number를 K/V로 저장
        map.put("order_idx", order_idx);                                                                                // map에 idx를 K/V로 저장
        return session.insert(namespace + "updateWaybill", map);                                                        // 기   능 : orderMapper.xml에 있는 SQL문을 실행하여 운송장번호가 #{waybill_number} 삽입
    }                                                                                                                   // 반환타입 : int - 매개변수 : Integer waybill_number, Integer idx

    @Override
    public int updateOrderStateDelivering(int order_idx) {                                                              // 메서드명 : updateOrderStateDelivering
        return session.update(namespace + "updatePaidOrderDelivering", order_idx);                                      // 기   능 : orderMapper.xml에 있는 SQL문을 실행하여 상태코드가 2인 주문에 대해 상태코드 3로 수정
    }                                                                                                                   // 반환타입 : int - 매개변수 : Integer order_idx

    @Override
    public int updateOrderDetailStateDelivering(int order_idx) {                                                        // 메서드명 : updateOrderDetailStateDelivering
        return session.update(namespace + "updatePaidOrderDetailDelivering", order_idx);                                // 기   능 : orderMapper.xml에 있는 SQL문을 실행하여 상태코드가 2인 주문상세에 대해 상태코드 3로 수정
    }                                                                                                                   // 반환타입 : int - 매개변수 : Integer order_idx

    @Override
    public int insertOrderHistoryStateDelivering(List<OrderDetailDto> orderDetails) {                                   // 메서드명 : insertOrderHistoryStateDelivering
        return session.insert(namespace + "insertPaidOrderHistoryDelivering", orderDetails);                            // 기   능 : orderMapper.xml에 있는 SQL문을 실행하여 상태코드가 2인 주문이력에 대해 상태코드 3로 수정한 이력 삽입
    }                                                                                                                   // 반환타입 : int - 매개변수 : List<OrderDetailDto> orderDetails

    @Override
    public int updateOrderStateDeliveryCompleted(int order_idx) {                                                       // 메서드명 : updateOrderStateDeliveryCompleted
        return session.update(namespace + "updateOrderStateDeliveryCompleted", order_idx);                              // 기   능 : orderMapper.xml에 있는 SQL문을 실행하여 상태코드가 3인 주문에 대해 상태코드 4로 수정
    }                                                                                                                   // 반환타입 : int - 매개변수 : Integer order_idx

    @Override
    public int updateOrderDetailStateDeliveryCompleted(int order_idx) {                                                 // 메서드명 : updateOrderDetailStateDeliveryCompleted
        return session.update(namespace + "updateOrderDetailStateDeliveryCompleted", order_idx);                        // 기   능 : orderMapper.xml에 있는 SQL문을 실행하여 상태코드가 3인 주문에 대해 상태코드 4로 수정
    }                                                                                                                   // 반환타입 : int - 매개변수 : Integer order_idx

    @Override
    public int insertOrderHistoryStateDeliveryCompleted(List<OrderDetailDto> orderDetails) {                            // 메서드명 : insertOrderHistoryStateDeliveryCompleted
        return session.insert(namespace + "insertOrderHistoryStateDeliveryCompleted", orderDetails);                    // 기   능 : orderMapper.xml에 있는 SQL문을 실행하여 상태코드가 2인 주문이력에 대해 상태코드 3로 수정한 이력 삽입
    }                                                                                                                   // 반환타입 : int - 매개변수 : List<OrderDetailDto> orderDetails
}
