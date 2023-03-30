package com.fastcampus.ch4.service;

import com.fastcampus.ch4.dao.FindUserDao;
import com.fastcampus.ch4.domain.User;
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
