package com.jangbogo.admin.dao;

import com.jangbogo.admin.domain.Address;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AddrDaoImpl implements AddrDao {

    @Autowired
    SqlSession session;

    private static String nameSpace = "com.jangbogo.admin.dao.AddrMapper.";

    @Override
    public List<Address> getAddrList (Integer user_idx) throws Exception{
        return session.selectList(nameSpace + "getAddrList", user_idx);
    }


}
