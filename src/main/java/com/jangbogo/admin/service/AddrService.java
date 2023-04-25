package com.jangbogo.admin.service;

import com.jangbogo.admin.domain.Address;

import java.util.List;

public interface AddrService {

    //회원별 배송지 조회
    List<Address> getAddrList (Integer user_idx) throws Exception;
}
