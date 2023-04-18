package com.jangbogo.admin.service;

import com.jangbogo.admin.domain.Seller;
import com.jangbogo.admin.domain.SellerDtl;

public interface SellerService {

    //판매자 승인
    int approveSeller (int idx, String email) throws Exception;
    //판매자 신고
    int reportSeller (int idx, String email) throws Exception;
    //판매자 1명 조회
    Seller selectSeller (int idx) throws Exception;

    //판매자 상세 조회
    SellerDtl selectSellerDtl (Integer idx)  throws Exception;

}
