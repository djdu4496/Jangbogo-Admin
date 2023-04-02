package com.jangbogo.admin.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@AllArgsConstructor
@Builder
public class User {

    public User() {}

    private int idx; //번호

    private int auth_idx;
    private int rank_idx;

    private String email; //이메일
    private String nick; //닉네임
    private String pwd; //비번
    private String mpno; //휴대전화
    private Date birth; //생일

    private boolean is_agreed;  //개인정보동의여부
    private boolean is_markt_agreed;  //마케팅수신동의여부

    private int login_type; //0: 일반, 1:네이버, 2:카카오

    private boolean SOCIAL_YN; // Y/N => boolean 가능?

    private int state;  //회원상태코드 1: 정상, 2: 신고, 3: 탈퇴, 4: 휴면 MemberState

    @DateTimeFormat()
    private Date PWD_UPT_TM; //비번변경날짜

    private Date LAST_LOGIN_TM; //최종로그인날짜

    private int decl_cnt; //신고당한횟수





}
