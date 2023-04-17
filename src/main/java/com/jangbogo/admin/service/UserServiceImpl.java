package com.jangbogo.admin.service;

import com.jangbogo.admin.dao.UserDao;
import com.jangbogo.admin.domain.SearchCondition;
import com.jangbogo.admin.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao dao;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;


    @Override
    public User getUserByIdx (Integer idx) throws Exception {
        return dao.getUserByIdx(idx);
    }

    @Override
    public boolean verifyAdmin (String email, String pwd) throws Exception {
        User user = dao.getAdminByEmail(email);
        if (user == null) return false;
        return passwordEncoder.matches(pwd, user.getPwd()); //비밀번호 일치여부 확인
    }

    @Override
    public int getSearchResultCnt (SearchCondition sc) throws Exception {
        return dao.searchResultCnt(sc);
    }

    @Override
    public List<User> getSearchSelectPage (SearchCondition sc) throws Exception {
        return dao.searchSelectPage(sc);
    }

    @Override
    public int reportUser (Integer idx, String email) throws Exception {
        return dao.reportUser(idx, email);
    }
}
