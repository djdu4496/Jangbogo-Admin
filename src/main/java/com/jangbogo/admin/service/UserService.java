package com.jangbogo.admin.service;

import com.jangbogo.admin.domain.SearchCondition;
import com.jangbogo.admin.domain.User;

import java.util.List;

public interface UserService {

    //회원 상세 조회
    User getUserByIdx (Integer idx) throws Exception;

    //어드민 로그인
    boolean verifyAdmin (String email, String pwd) throws Exception;

    int getSearchResultCnt (SearchCondition sc) throws Exception;

    List<User> getSearchSelectPage (SearchCondition sc) throws Exception;
}

