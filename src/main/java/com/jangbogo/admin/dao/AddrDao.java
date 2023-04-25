package com.jangbogo.admin.dao;

import com.jangbogo.admin.domain.Address;

import java.util.List;

public interface AddrDao {

    //회원별 배송지 리스트 조회
    List<Address> getAddrList (Integer user_idx) throws Exception;
}
