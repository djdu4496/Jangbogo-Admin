package com.jangbogo.admin;


import com.jangbogo.admin.dao.FindUserDao;
import com.jangbogo.admin.dao.SellerDao;
import com.jangbogo.admin.domain.Seller;
import com.jangbogo.admin.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;


@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class SellerDaoTest {


    @Autowired
    SellerDao dao;

    @Test
    public void insertSeller() throws Exception {

        Seller seller = new Seller();
        int result = dao.insertSeller(seller);
        assertTrue(result == 1);
    }
}
