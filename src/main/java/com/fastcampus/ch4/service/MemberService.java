package com.fastcampus.ch4.service;

import com.fastcampus.ch4.domain.User;

import java.util.List;
import java.util.Map;

public interface MemberService {

     List<User> getUserList() throws Exception;

     List<User> selectPage(Map map) throws Exception;

     int getUserCnt () throws Exception;

}
