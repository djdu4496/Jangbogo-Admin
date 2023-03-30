package com.jangbogo.admin.dao;


import com.jangbogo.admin.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class FindUserDaoImpl implements FindUserDao {

    //sqlSession을 주입받는다.
    @Autowired
    SqlSession session;

    String nameSpace = "com.fastcampus.ch4.dao.FindUserMapper."; //mapper 파일의 경로를 저장한다. 마지막에 .필수

    @Override
    public int checkExistingUser (User user) throws Exception {
        return session.selectOne(nameSpace + "checkExistingUser", user);
    }

    @Override
    public int updateWithTempPwd (User user) throws Exception {
        return session.update(nameSpace +"updateWithTempPwd", user);
    }

    @Override
    public List<User> getUserList () throws Exception {
        return session.selectList(nameSpace + "getUserList");
    }

    @Override
    public int insertUser (User user) throws Exception {
        return session.insert(nameSpace +"insertUser", user);
    }

    @Override
    public int getUserCnt () throws Exception {
        return session.selectOne(nameSpace +"getUserCnt");
    }

    @Override
    public List<User> selectPage (Map map) throws Exception {
        return session.selectList(nameSpace + "selectPage", map);
    }

}
