package com.jangbogo.admin.service;

import com.jangbogo.admin.dao.UserDao;
import com.jangbogo.admin.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao dao;


    @Override
    public User getUserByIdx (Integer idx) throws Exception {
        return dao.getUserByIdx(idx);
    }
}
