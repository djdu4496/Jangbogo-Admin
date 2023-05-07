package com.jangbogo.admin.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

//@Data
//@AllArgsConstructor
//@Builder
public class ProdInqryAnsDto {
    private Integer idx; //상품문의번호
    private String ctent;
    private String writer;

    public ProdInqryAnsDto() {}

    public ProdInqryAnsDto(Integer idx, String ctent, String writer) {
        this.idx = idx;
        this.ctent = ctent;
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "ProdInqryAnsDto{" +
                "idx=" + idx +
                ", ctent='" + ctent + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public String getCtent() {
        return ctent;
    }

    public void setCtent(String ctent) {
        this.ctent = ctent;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
