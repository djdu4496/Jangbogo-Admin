package com.jangbogo.admin.dao;

import com.jangbogo.admin.domain.SearchCondition;
import com.jangbogo.admin.domain.Seller;
import com.jangbogo.admin.domain.SellerDtl;
import com.jangbogo.admin.domain.User;
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
        //상태를 2로 변경 (신고)
    }

    @Override
    public int approveSeller (int idx, String email) throws Exception {
        Map map = new HashMap();
        map.put("idx", idx);
        map.put("email", email);
        return session.update(nameSpace + "approveSeller", map);
        //상태를 1로 변경 (승인)
    }

    @Override
    public Seller selectSeller (Integer idx) throws Exception {
        return session.selectOne(nameSpace + "selectSeller", idx);
    }

    @Override
    public SellerDtl selectSellerDtl (Integer idx) throws Exception {
        return session.selectOne(nameSpace + "selectSellerDtl", idx);
    }

    @Override
    public int searchResultCnt (SearchCondition sc) throws Exception {
        return session.selectOne(nameSpace + "searchResultCnt", sc);
    }

    @Override
    public List<Seller> searchSelectPage (SearchCondition sc) throws Exception {
        return session.selectList(nameSpace + "searchSelectPage", sc);
    }


}
