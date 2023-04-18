package com.jangbogo.admin.service;

import com.jangbogo.admin.dao.SellerDao;
import com.jangbogo.admin.domain.SearchCondition;
import com.jangbogo.admin.domain.Seller;
import com.jangbogo.admin.domain.SellerDtl;
import com.jangbogo.admin.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService{

    @Autowired
    SellerDao dao;

    @Override
    public int approveSeller (int idx, String email) throws Exception {
        return dao.approveSeller(idx, email);
    }

    @Override
    public int reportSeller (int idx, String email) throws Exception {
        return dao.reportSeller(idx, email);
    }

    @Override
    public Seller selectSeller (int idx) throws Exception {
        return dao.selectSeller(idx);
    }

    @Override
    public SellerDtl selectSellerDtl (Integer idx) throws Exception {
        return dao.selectSellerDtl(idx);
    }

    @Override
    public int getSearchResultCnt (SearchCondition sc) throws Exception {
        return dao.searchResultCnt(sc);
    }

    @Override
    public List<Seller> getSearchSelectPage (SearchCondition sc) throws Exception {
        return dao.searchSelectPage(sc);
    }
}
