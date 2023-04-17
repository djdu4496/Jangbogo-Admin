package com.jangbogo.admin.dao;

import com.jangbogo.admin.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
