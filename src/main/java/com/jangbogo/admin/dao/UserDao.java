package com.jangbogo.admin.dao;

import com.jangbogo.admin.domain.SearchCondition;
import com.jangbogo.admin.domain.Seller;
import com.jangbogo.admin.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    int insertUser (User user) throws Exception;

    User select (int idx) throws Exception;

    List<User> selectListPage (Map map) throws Exception;

    List<User> searchSelectPage (SearchCondition sc) throws Exception;

    int updateUser (User user) throws Exception;

    int deleteUser (int idx) throws Exception;
}
