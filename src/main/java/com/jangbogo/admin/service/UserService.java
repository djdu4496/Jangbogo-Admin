package com.jangbogo.admin.service;

import com.jangbogo.admin.domain.User;

public interface UserService {

    //회원 상세 조회
    User getUserByIdx (Integer idx) throws Exception;
}

