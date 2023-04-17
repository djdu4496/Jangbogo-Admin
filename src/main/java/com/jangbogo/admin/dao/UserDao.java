package com.jangbogo.admin.dao;

import com.jangbogo.admin.domain.SearchCondition;
import com.jangbogo.admin.domain.Seller;
import com.jangbogo.admin.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    //회원 상세 조회
    User getUserByIdx (Integer idx) throws Exception;

    //관리자 로그인
    User getAdminByEmail (String email) throws Exception;

    //회원 수 조회 (검색 적용)
    int searchResultCnt (SearchCondition sc) throws Exception;

    //회원 수 10개 단위 페이징 + 검색 조회
    List<User> searchSelectPage (SearchCondition sc) throws Exception;

    //회원 신고하기
    int reportUser (Integer idx, String email) throws Exception;
}
