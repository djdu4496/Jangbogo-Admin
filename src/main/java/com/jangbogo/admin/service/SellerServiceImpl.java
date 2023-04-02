package com.jangbogo.admin.service;

import com.jangbogo.admin.dao.SellerDao;
import com.jangbogo.admin.domain.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
