package com.jangbogo.admin;


import com.jangbogo.admin.dao.UserDao;
import com.jangbogo.admin.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class UserDaoTest {

    @Autowired
    UserDao dao;

    @Test //ok
    public void test1() throws Exception {
       User user = dao.getUserByIdx(32); //존재하는 idx
       log.info(".....test...." + user);
       assertTrue(user != null);
    }
}
