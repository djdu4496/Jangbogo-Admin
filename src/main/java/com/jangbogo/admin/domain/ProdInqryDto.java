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
    private String name;
    private Integer idx;
    private Integer prod_idx;
    private Integer user_idx;
    private String title;
    private String ctent;
    private String writer;
    private Integer res_state_cd; //문의 답변 상태코드 1: 답변대기 2: 답변완료
    private Integer state_cd;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date wrt_tm;

    public ProdInqryDto() {}
}
