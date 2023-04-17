package com.jangbogo.admin.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SellerDtl {//판매자선택정보

    private String guid_nm;  //안내담당자이름
    private String guid_email;  //안내담당자이메일

    private String cllr_nm; //고객센터담당자이름
    private String cllr_tellno;  //고객센터전화번호

    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date reg_tm; //등록날짜
}
