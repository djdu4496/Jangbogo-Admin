package com.jangbogo.admin.dao;

import com.jangbogo.admin.domain.SearchCondition;
import com.jangbogo.admin.domain.Seller;

import java.util.List;
import java.util.Map;

public interface SellerDao {

    //판매자 신고.
    int reportSeller (int idx, String email) throws Exception;

    //판매자 승인.
    int approveSeller (int idx, String email) throws Exception;

    //판매자 상세 조회.
    Seller selectSeller (int idx) throws Exception;

    List<Seller> selectListPage (Map map) throws Exception;

    List<Seller> searchSelectPage (SearchCondition sc) throws Exception;

}
