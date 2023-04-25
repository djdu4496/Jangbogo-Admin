package com.jangbogo.admin;


import com.jangbogo.admin.dao.UserDao;
import com.jangbogo.admin.domain.SearchCondition;
import com.jangbogo.admin.domain.User;
import com.jangbogo.admin.service.UserService;
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
public class UserServiceTest {

    @Autowired
    UserService service;

    @Test //ok
    public void test1() throws Exception {
        User user = service.getUserByIdx(32); //존재하는 idx
        log.info(".....test...." + user);
        assertTrue(user != null);
    }

    @Test //ok
    public void test2() throws Exception {
        boolean result = service.verifyAdmin("jinvicky@naver.com", "test1007");
        log.info("....." + result);
        assertTrue(result);
    }

    @Test //ok
    public void test3() throws Exception {
        SearchCondition sc = new SearchCondition();
        sc.setOption("E");
        sc.setKeyword("test");
        int cnt = service.getSearchResultCnt(sc);

        log.info("cnt...." + cnt);
        assertTrue(cnt != 0);
        //검색 조건 없을 때 전체, 있을 때 부분 테스트 ok
    }

    @Test
    public void test4() throws Exception {
        int result = service.reportUser(156, "test9999@naver.com");
        log.info("result..."+ result);
    }
}
