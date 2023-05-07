package com.jangbogo.admin.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class ProdInqryDto {
//    상품테이블 p
    private String name;
//    상품문의테이블 pi
    private Integer idx;  //상품문의번호
    private Integer prod_idx;
    private Integer user_idx;
    private String title;
    private String ctent;
    private String writer;
    private Integer res_state_cd; //문의 답변 상태코드 1: 답변대기 2: 답변완료
    private Integer state_cd; //등록(1) 상태인지, 삭제(3) 상태인지
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date wrt_tm;
//    상품문의답변 테이블 pia
    private String ans_ctent;
    private String ans_writer;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ans_resps_tm;
    private Integer ans_crt_idx;
    private Integer ans_upt_idx;
    private Integer ans_state_cd;

//    상품상세테이블 pd
    private Integer prodDetail_state_cd;

    public ProdInqryDto() {}
}
