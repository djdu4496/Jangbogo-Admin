package com.jangbogo.admin.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class Seller {

    public Seller() {} //기본 생성자

    private int idx; //번호
    private int auth_idx; //권한번호 1:사용자, 2:판매자 3:관리자

    private String email; //이메일
    private String company_name; //회사이름
    private String repr_name; //대표이름

    private String pwd; //비밀번호

    private String mobile_num; //휴대전화
    private String repr_tell_num; //회사대표전화 ??

    private int type; //사업자유형 1:개인사업, 2:법인사업

    private String biz_num; //사업자번호
    private String sale_biz_num; //통신판매업신고번호

    private String postcode; //우편번호
    private String address; //기본주소
    private String address_detail;

    private String bank_name; //은행이름
    private String bank_num; //계좌번호
    private String bank_owner; //주인이름

    private boolean is_agreed; //판매자동의여부

    private String banner_img_url;  //브랜드배너파일경로
    private String img_url;  //브랜드프로필파일경로

    private String content;  //브랜드내용

    private int subs_cnt; //팔로워수

    private int state;  //상태코드; MemberState

    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date reg_date; //등록날짜
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date aprv_date; //승인날짜
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date up_date; //수정날짜
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date pwd_up_date;  //비번변경날짜
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date last_login_date;  //최종로그인날짜


    //TODO:: 판매자상세 iv 추가
}
