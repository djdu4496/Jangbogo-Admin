package com.jangbogo.admin;


import com.jangbogo.admin.dao.UserDao;
import com.jangbogo.admin.domain.SearchCondition;
import com.jangbogo.admin.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class UserDaoTest {

    @Autowired
    UserDao dao;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Test //ok
    public void test1() throws Exception {
       User user = dao.getUserByIdx(32); //존재하는 idx
       log.info(".....test...." + user);
       assertTrue(user != null);
    }

    @Test //ok
    public void test2() throws Exception {
        User admin = dao.getAdminByEmail("jinvicky@naver.com"); //존재하는 idx
        log.info(".....test...." + admin);
        assertTrue(admin != null);
    }

    @Test //ok
    public void test3() throws Exception {
        log.info("...encode...." + passwordEncoder.encode("test1007"));
        //$2a$10$WX7vUbgBA8K5kPaeFGa.VeZ3RUOsZO0MhxbsISjbM7kD0X1ai6rOi
    }

    @Test //ok
    public void test4() throws Exception {
        SearchCondition sc = new SearchCondition();
//        sc.setOption("E");
//        sc.setKeyword("");
        int cnt = dao.searchResultCnt(sc);

        log.info("cnt...." + cnt);
        assertTrue(cnt != 0);
        //검색 조건 없을 때 전체, 있을 때 부분 테스트 ok
    }

    @Test
    public void test5() throws Exception {
        SearchCondition sc = new SearchCondition();
        sc.setPage(1);
        sc.setPageSize(10);
        List<User> list = dao.searchSelectPage(sc);
        log.info("list...."+ list +"....length ..." + list.size()); //ok
    }

    @Test
    public void test6() throws Exception {
        int result = dao.reportUser(62, "test995@naver.com");
        log.info("result..." + result);
        assertTrue(result != 0);
    }
}
