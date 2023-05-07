package com.jangbogo.admin.domain;

import java.util.Date;

public class ProductDto {
    // iv + 상품판매시작일, 상품가격, 상품판매종료일, 상품등록일, 재고수량
    private Integer idx;                                                                                                // 상품번호 IDX - `PRODUCT` TABLE(PK)
    private Integer seler_idx;                                                                                          // 판매자번호 SELER_IDX - `PRODUCT` TABLE(FK)
    private Integer seler_prod_cd;                                                                                      // 판매자상품코드 SELER_PROD_CD - `PRODUCT` TABLE
    private String name;                                                                                                // 상품이름 NAME - `PRODUCT` TABLE
    private Integer prc;                                                                                                // 상품가격 PRC - `PRODUCT` TABLE
    private Integer dc_state_cd;                                                                                        // 상품할인상태코드 DC_STATE_CD - `PRODUCT` TABLE
    private Integer dc_rate;                                                                                            // 상품할인율 - DC_RATE - `PRODUCT` TABLE (FIN)
    private Integer reg_state_cd;                                                                                       // 상품등록상태코드 REG_STATE_CD - `PROD_DTL` TABLE
    private Integer state_cd;                                                                                           // 상품상태코드 STATE_CD - `PROD_DTL` TABLE
    private Date sle_start_tm;                                                                                          // 상품판매시작일 SLE_START_TM - `PROD_DTL` TABLE
    private Date sle_end_tm;                                                                                            // 상품판매종료일 SLE_END_TM - `PROD_DTL` TABLE
    private Date create_tm;                                                                                             // 상품등록일 CREATE_TM - `PROD_DTL` TABLE (FIN)
    private String cpnm;                                                                                                // 상호(브랜드명) CPNM - `SELER` TABLE

    // constructor
    public ProductDto() {}                                                                                              // 기본생성자

    // getter & setter
    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public Integer getSeler_idx() {
        return seler_idx;
    }

    public void setSeler_idx(Integer seler_idx) {
        this.seler_idx = seler_idx;
    }

    public Integer getSeler_prod_cd() {
        return seler_prod_cd;
    }

    public void setSeler_prod_cd(Integer seler_prod_cd) {
        this.seler_prod_cd = seler_prod_cd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrc() {
        return prc;
    }

    public void setPrc(Integer prc) {
        this.prc = prc;
    }

    public Integer getDc_state_cd() {
        return dc_state_cd;
    }

    public void setDc_state_cd(Integer dc_state_cd) {
        this.dc_state_cd = dc_state_cd;
    }

    public Integer getDc_rate() {
        return dc_rate;
    }

    public void setDc_rate(Integer dc_rate) {
        this.dc_rate = dc_rate;
    }

    public Integer getReg_state_cd() {
        return reg_state_cd;
    }

    public void setReg_state_cd(Integer reg_state_cd) {
        this.reg_state_cd = reg_state_cd;
    }

    public Integer getState_cd() {
        return state_cd;
    }

    public void setState_cd(Integer state_cd) {
        this.state_cd = state_cd;
    }

    public Date getSle_start_tm() {
        return sle_start_tm;
    }

    public void setSle_start_tm(Date sle_start_tm) {
        this.sle_start_tm = sle_start_tm;
    }

    public Date getSle_end_tm() {
        return sle_end_tm;
    }

    public void setSle_end_tm(Date sle_end_tm) {
        this.sle_end_tm = sle_end_tm;
    }

    public Date getCreate_tm() {
        return create_tm;
    }

    public void setCreate_tm(Date create_tm) {
        this.create_tm = create_tm;
    }

    public String getCpnm() {
        return cpnm;
    }

    public void setCpnm(String cpnm) {
        this.cpnm = cpnm;
    }

    // toString
    @Override
    public String toString() {
        return "ProductDto{" +
                "idx=" + idx +
                ", seler_idx=" + seler_idx +
                ", seler_prod_cd=" + seler_prod_cd +
                ", name='" + name + '\'' +
                ", prc=" + prc +
                ", dc_state_cd=" + dc_state_cd +
                ", dc_rate=" + dc_rate +
                ", reg_state_cd=" + reg_state_cd +
                ", state_cd=" + state_cd +
                ", sle_start_tm=" + sle_start_tm +
                ", sle_end_tm=" + sle_end_tm +
                ", create_tm=" + create_tm +
                ", cpnm='" + cpnm + '\'' +
                '}';
    }
}
