package com.jangbogo.admin;


import com.jangbogo.admin.dao.FindUserDao;
import com.jangbogo.admin.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class FindUserDaoTest {

    @Autowired
    FindUserDao dao;


    @Test
    public void test() throws Exception {
        User user = new User();
        user.setEmail("jinvicky17@gmail.com");
        user.setId("wkdu0723");

        System.out.println("test : " + dao.checkExistingUser(user));
    }

    @Test
    public void test1() throws Exception {
        //업데이트가 안된다.
        User user = new User();
        user.setEmail("jinvicky17@gmail.com");
        user.setId("wkdu0723");
        user.setPwd("$2a$10$haUMFTK1IbyVlOBTxzukluD"); //인코딩을 했더니 패스워드가 너무 길다고 테스트를 실패하고 만다.
        dao.updateWithTempPwd(user);

    }

    @Test
    public void insertTest() throws Exception {
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setEmail("jinvicky17@gmail.com");
            user.setId(""+i);
            user.setPwd("paging test..." + i);
            dao.insertUser(user);
        }
    }

    @Test
    public void cntTest() throws Exception {
        log.info("test:: "+ dao.getUserCnt());
    }
}
