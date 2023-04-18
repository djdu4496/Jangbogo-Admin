package com.jangbogo.admin.service;


import com.jangbogo.admin.dao.AddrDao;
import com.jangbogo.admin.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddrServiceImpl implements AddrService{


    @Autowired
    AddrDao dao;

    @Override
    public List<Address> getAddrList (Integer user_idx) throws Exception {
        return dao.getAddrList(user_idx);
    }


}
