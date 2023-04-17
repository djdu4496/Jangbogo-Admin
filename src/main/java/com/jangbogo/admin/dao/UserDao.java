package com.jangbogo.admin.dao;

import com.jangbogo.admin.domain.SearchCondition;
import com.jangbogo.admin.domain.Seller;
import com.jangbogo.admin.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    //회원 상세 조회
    User getUserByIdx (Integer idx) throws Exception;

    User getAdminByEmail (String email) throws Exception;

    int searchResultCnt (SearchCondition sc) throws Exception;

    List<User> searchSelectPage (SearchCondition sc) throws Exception;
}
