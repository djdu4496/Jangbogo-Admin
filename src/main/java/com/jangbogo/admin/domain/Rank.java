package com.jangbogo.admin.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Rank {

    public Rank () {}

    private int idx; //등급번호
    private String name; //이름
    private int cond_amount; //조건금액
    private String benefit; //혜택
    private int accml_rate; //적립율

    private int state; //1: 사용, 2: 삭제
}
