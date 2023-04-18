package com.jangbogo.admin.dao;

import com.jangbogo.admin.domain.SearchCondition;
import com.jangbogo.admin.domain.Seller;
import com.jangbogo.admin.domain.SellerDtl;

import java.util.List;
import java.util.Map;

public interface SellerDao {

    //판매자 신고.
    int reportSeller (int idx, String email) throws Exception;

    //판매자 승인.
    int approveSeller (int idx, String email) throws Exception;

    //판매자 상세 조회.
    Seller selectSeller (Integer idx) throws Exception;

    //판매자 상세 조회
    SellerDtl selectSellerDtl (Integer idx) throws Exception;


}
