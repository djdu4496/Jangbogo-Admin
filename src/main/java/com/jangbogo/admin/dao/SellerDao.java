package com.jangbogo.admin.dao;

import com.jangbogo.admin.domain.SearchCondition;
import com.jangbogo.admin.domain.Seller;

import java.util.List;
import java.util.Map;

public interface SellerDao {
//    crud 순

    int insertSeller (Seller seller) throws Exception;

    Seller select (int idx) throws Exception;

    List<Seller> selectListPage (Map map) throws Exception;

    List<Seller> searchSelectPage (SearchCondition sc) throws Exception;

    int updateSeller (Seller seller) throws Exception;

    int deleteSeller (int idx) throws Exception;

}
