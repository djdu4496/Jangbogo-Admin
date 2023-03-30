package com.jangbogo.admin.service;

import com.jangbogo.admin.dao.FindUserDao;
import com.jangbogo.admin.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    FindUserDao dao;

    @Override
    public List<User> getUserList () throws Exception {
        return dao.getUserList();
    }

    @Override
    public List<User> selectPage(Map map) throws Exception {
        return dao.selectPage(map);
    }

    @Override
    public int getUserCnt () throws Exception {
        return dao.getUserCnt();
    }
}
