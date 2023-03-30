package com.jangbogo.admin.service;

import com.jangbogo.admin.domain.User;

import java.util.List;
import java.util.Map;

public interface MemberService {

     List<User> getUserList() throws Exception;

     List<User> selectPage(Map map) throws Exception;

     int getUserCnt () throws Exception;

}
