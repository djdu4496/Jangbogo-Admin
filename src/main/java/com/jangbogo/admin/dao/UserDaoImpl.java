package com.jangbogo.admin.dao;

import com.jangbogo.admin.domain.SearchCondition;
import com.jangbogo.admin.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    SqlSession session;

    private static String nameSpace ="com.jangbogo.admin.dao.UserMapper.";

    @Override
    public User getUserByIdx (Integer idx) throws Exception {
        return session.selectOne( nameSpace + "getUserByIdx", idx);
    }

    @Override
    public User getAdminByEmail (String email) throws Exception {
        return session.selectOne(nameSpace + "getAdminByEmail", email);
    }

    @Override
    public int searchResultCnt (SearchCondition sc) throws Exception {
        return session.selectOne(nameSpace + "searchResultCnt", sc);
    }

    @Override
    public List<User> searchSelectPage (SearchCondition sc) throws Exception {
        return session.selectList(nameSpace + "searchSelectPage", sc);
    }

    @Override
    public int reportUser (Integer idx, String email) throws Exception {
        Map map = new HashMap();
        map.put("idx", idx);
        map.put("email", email);
        return session.update(nameSpace + "reportUser", map);
    }
}
