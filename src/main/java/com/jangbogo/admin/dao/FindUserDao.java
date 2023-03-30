package com.jangbogo.admin.dao;

import com.jangbogo.admin.domain.User;

import java.util.List;
import java.util.Map;

public interface FindUserDao {

    //아이디와 이메일 조합에 존재하는 회원의 수를 가져온다.
    int checkExistingUser (User user) throws Exception;

    int updateWithTempPwd(User user) throws Exception;

    List<User> getUserList() throws Exception;

     int insertUser (User user) throws Exception;

     int getUserCnt () throws Exception;

    List<User> selectPage (Map map) throws Exception;

}
