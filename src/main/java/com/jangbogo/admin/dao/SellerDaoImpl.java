package com.jangbogo.admin.dao;

import com.jangbogo.admin.domain.SearchCondition;
import com.jangbogo.admin.domain.Seller;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SellerDaoImpl implements SellerDao{

    @Autowired
    SqlSession session;

    private static String nameSpace = "com.jangbogo.admin.dao.SellerMapper.";

    @Override
    public int reportSeller (int idx, String email) throws Exception {
        Map map = new HashMap();
        map.put("idx", idx);
        map.put("email", email);
        return session.update(nameSpace + "reportSeller", map);
        //상태를 3로 변경 (신고)
    }

    @Override
    public int approveSeller (int idx, String email) throws Exception {
        Map map = new HashMap();
        map.put("idx", idx);
        map.put("email", email);
        return session.update(nameSpace + "approveSeller", map);
        //상태를 2로 변경 (승인)
    }

    @Override
    public Seller selectSeller (int idx) throws Exception {
        return session.selectOne(nameSpace + "selectSeller", idx);
    }

//    TODO:: 추가 구현
    @Override
    public List<Seller> selectListPage (Map map) throws Exception {
        return session.selectList(nameSpace + "selectListPage", map);
    }

    @Override
    public List<Seller> searchSelectPage (SearchCondition sc) throws Exception {
        return session.selectList(nameSpace +"searchSelectPage", sc);
    }

}
