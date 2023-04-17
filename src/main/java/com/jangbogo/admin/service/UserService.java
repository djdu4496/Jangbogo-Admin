package com.jangbogo.admin.service;

import com.jangbogo.admin.domain.SearchCondition;
import com.jangbogo.admin.domain.User;

import java.util.List;

public interface UserService {

    //회원 상세 조회
    User getUserByIdx (Integer idx) throws Exception;

    //어드민 로그인
    boolean verifyAdmin (String email, String pwd) throws Exception;

    //회원 수 조회
    int getSearchResultCnt (SearchCondition sc) throws Exception;

    //회원 리스트 조회
    List<User> getSearchSelectPage (SearchCondition sc) throws Exception;

    //회원 신고
    int reportUser (Integer idx, String email) throws Exception;
}

