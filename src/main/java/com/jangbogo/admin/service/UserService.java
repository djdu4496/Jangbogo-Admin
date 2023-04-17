package com.jangbogo.admin.service;

import com.jangbogo.admin.domain.User;

public interface UserService {

    //회원 상세 조회
    User getUserByIdx (Integer idx) throws Exception;

    //어드민 로그인
    boolean verifyAdmin (String email, String pwd) throws Exception;
}

