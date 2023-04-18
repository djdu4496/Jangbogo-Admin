package com.jangbogo.admin;


import com.jangbogo.admin.dao.SellerDao;
import com.jangbogo.admin.domain.Seller;
import com.jangbogo.admin.domain.SellerDtl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class SellerDaoTest {

    @Autowired
    SellerDao dao;

    @Test //OK
    public void reportSeller() throws Exception {
        int result = dao.reportSeller(6, "jinvicky1007");
        log.info("result=" + result);
    }

    @Test //OK
    public void approveSeller() throws Exception {
        int result = dao.approveSeller(6, "jinvicky1007");
        log.info("result=" + result);
    }

    @Test //OK
    public void selectSeller() throws Exception {
        Seller result = dao.selectSeller(6);
        log.info("result=" + result);
    }
    @Test //OK
    public void selectSellerDtl() throws Exception {
        SellerDtl result = dao.selectSellerDtl(6);
        log.info("result=" + result.toString());
    }
}
