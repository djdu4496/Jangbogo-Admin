package com.jangbogo.admin.domain;

import java.util.Date;

public class OrderDetailDto {
    // iv
    private Date ord_tm;                                                                                                // 주문날짜 ORD_TM
    private Integer idx;                                                                                                // 주문상세번호 IDX - PK
    private Integer ord_idx;                                                                                            // 주문번호  ORD_IDX
    private String ordr_nm;                                                                                             // 주문자이름 ORDR_NM
    private Integer prod_idx;                                                                                           // 상품번호 PROD_IDX
    private String prod_nm;                                                                                             // 주문상품명 CONCAT(PROD_NM, ' 외 ', PLIST_TOT)
    private Integer prod_qty;                                                                                           // 주문상품개수 PROD_QTY
    private Integer prod_prc;                                                                                           // 주문상품가격 PROD_PRC
    private Integer tot_amt;                                                                                            // 주문총금액 TOT_AMT
    private Integer setl_mn_cd;                                                                                         // 결제수단코드 SETL_MN_CD
    private Integer state_cd;                                                                                           // 주문상태코드 STATE_CD
    private Integer prod_late_state_cd;                                                                                 //  PROD_LATE_STATE_CD
    private Date crt_tm;                                                                                                // 최초등록일자 CRT_TM
    private Integer crt_idx;                                                                                            // 최초등록자식별번호 CRT_IDX
    private Date upt_tm;                                                                                                // 최종수정일자 UPT_TM
    private Integer upt_idx;                                                                                            // 최종수정자식별번호 UPT_IDX

    // constructor
    public OrderDetailDto() {};                                                                                         // 기본생성자

    // getter & setter
    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public Date getOrd_tm() {
        return ord_tm;
    }

    public void setOrd_tm(Date ord_tm) {
        this.ord_tm = ord_tm;
    }

    public Integer getOrd_idx() {
        return ord_idx;
    }

    public void setOrd_idx(Integer ord_idx) {
        this.ord_idx = ord_idx;
    }

    public String getOrdr_nm() {
        return ordr_nm;
    }

    public void setOrdr_nm(String ordr_nm) {
        this.ordr_nm = ordr_nm;
    }

    public Integer getProd_idx() {
        return prod_idx;
    }

    public void setProd_idx(Integer prod_idx) {
        this.prod_idx = prod_idx;
    }

    public String getProd_nm() {
        return prod_nm;
    }

    public void setProd_nm(String prod_nm) {
        this.prod_nm = prod_nm;
    }

    public Integer getProd_qty() {
        return prod_qty;
    }

    public void setProd_qty(Integer prod_qty) {
        this.prod_qty = prod_qty;
    }

    public Integer getProd_prc() {
        return prod_prc;
    }

    public void setProd_prc(Integer prod_prc) {
        this.prod_prc = prod_prc;
    }

    public Integer getTot_amt() {
        return tot_amt;
    }

    public void setTot_amt(Integer tot_amt) {
        this.tot_amt = tot_amt;
    }

    public Integer getSetl_mn_cd() {
        return setl_mn_cd;
    }

    public void setSetl_mn_cd(Integer setl_mn_cd) {
        this.setl_mn_cd = setl_mn_cd;
    }

    public Integer getState_cd() {
        return state_cd;
    }

    public void setState_cd(Integer state_cd) {
        this.state_cd = state_cd;
    }

    public Date getCrt_tm() {
        return crt_tm;
    }

    public void setCrt_tm(Date crt_tm) {
        this.crt_tm = crt_tm;
    }

    public Integer getCrt_idx() {
        return crt_idx;
    }

    public void setCrt_idx(Integer crt_idx) {
        this.crt_idx = crt_idx;
    }

    public Date getUpt_tm() {
        return upt_tm;
    }

    public void setUpt_tm(Date upt_tm) {
        this.upt_tm = upt_tm;
    }

    public Integer getUpt_idx() {
        return upt_idx;
    }

    public void setUpt_idx(Integer upt_idx) {
        this.upt_idx = upt_idx;
    }


    // toString

    @Override
    public String toString() {
        return "{" +
                "idx=" + idx +
                ", ord_tm=" + ord_tm +
                ", ord_idx=" + ord_idx +
                ", ordr_nm='" + ordr_nm + '\'' +
                ", prod_idx=" + prod_idx +
                ", prod_nm='" + prod_nm + '\'' +
                ", prod_qty=" + prod_qty +
                ", prod_prc=" + prod_prc +
                ", tot_amt=" + tot_amt +
                ", setl_mn_cd=" + setl_mn_cd +
                ", state_cd=" + state_cd +
                ", crt_tm=" + crt_tm +
                ", crt_idx=" + crt_idx +
                ", upt_tm=" + upt_tm +
                ", upt_idx=" + upt_idx +
                '}';
    }
}
