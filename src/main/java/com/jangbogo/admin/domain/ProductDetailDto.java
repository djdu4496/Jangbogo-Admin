package com.jangbogo.admin.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ProductDetailDto {
    // iv
    private Integer idx;                                                                                                // 상품번호 IDX - `PRODUCT` TABLE(PK)
    private Integer seler_prod_cd;                                                                                      // 판매자상품코드 SELER_PROD_CD
    private String name;                                                                                                // 상품이름 NAME
    private Integer prc;                                                                                                // 상품가격 PRC
    private String ctent;                                                                                               // 상품설명 CTENT
    private Integer dc_state_cd;                                                                                        // 상품할인상태코드 DC_STATE_CD
    private Integer dc_rate;                                                                                            // 상품할인율 DC_RATE
    private Integer dsply_state_cd;                                                                                     // 상품전시상태코드 DSPLY_STATE_CD - `PRODUCT` TABLE (FIN)

    private String orplc;                                                                                               // 상품상세.원산지 ORPLC
    private String sle_unit;                                                                                            // 상품상세.판매단위 SLE_UNIT
    private String weight;                                                                                              // 상품상세.중량 WEIGHT
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date mft_tm;                                                                                                // 상품상세.제조일자 MFT_TM
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date distb_tlmt;                                                                                            // 상품상세.유통기한 DISTB_TLMT
    private String warn;                                                                                                // 상품상세.주의사항 WARN
    private Integer sle_quty;                                                                                           // 상품상세.상품판매량 SLE_QUTY
    private Integer max_sle_quty;                                                                                       // 상품상세.1회상품최대구매수량 MAX_SLE_QUTY
    private Integer reg_state_cd;                                                                                       // 상품상세.상품등록상태코드 REG_STATE_CD
    private Integer state_cd;                                                                                           // 상품상세.상품상태코드 STATE_CD
    private Integer sfkp_tp_state_cd;                                                                                   // 상품상세.보관유형상태코드 SFKP_TP_STATE_CD
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date create_tm;                                                                                             // 상품상세.상품등록일 CREATE_TM
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date sle_start_tm;                                                                                          // 상품상세.상품판매시작일 SLE_START_TM
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date sle_end_tm;                                                                                            // 상품상세.상품판매종료일  SLE_END_TM
    private Integer inv_quty;                                                                                           // 상품상세.상품재고수량 INV_QUTY
    private String guid;                                                                                                // 상품상세.상품안내사항 GUID

    private String cpnm;                                                                                                // 판매자.상호(브랜드명) CPNM

    private Integer dlvry_type_cd;                                                                                      // 배송방식.배송유형코드 DLVRY_TYPE_CD
    private Integer pack_state_cd;                                                                                      // 배송방식.배송포장코드 PACK_STATE_CD
    private Integer dlvry_mthd_state_cd;                                                                                // 배송방식.배송방식상태코드 STATE_CD
    private String dlvry_mthd_warn;                                                                                     // 배송방식.배송주의사항 WARN
    private String dexp_poli;                                                                                           // 배송방식.배송비정책 DEXP_POLI
    private String dlvry_vend;                                                                                          // 배송방식.배송업체 DLVRY_VEND
    private Integer tlmt;                                                                                               // 배송방식.출고예상기한 TLMT
    private Integer dexp;                                                                                               // 배송방식.배송비 DEXP

    // constructor
    public ProductDetailDto() {}                                                                                        // 기본생성자

    // getter & setter


    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
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

    public Integer getPrc() { return prc;}

    public void setPrc(Integer prc) {
        this.prc = prc;
    }

    public String getCtent() {
        return ctent;
    }

    public void setCtent(String ctent) {
        this.ctent = ctent;
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

    public Integer getDsply_state_cd() {
        return dsply_state_cd;
    }

    public void setDsply_state_cd(Integer dsply_state_cd) {
        this.dsply_state_cd = dsply_state_cd;
    }

    public String getOrplc() {
        return orplc;
    }

    public void setOrplc(String orplc) {
        this.orplc = orplc;
    }

    public String getSle_unit() {
        return sle_unit;
    }

    public void setSle_unit(String sle_unit) {
        this.sle_unit = sle_unit;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Date getMft_tm() {
        return mft_tm;
    }

    public void setMft_tm(Date mft_tm) {
        this.mft_tm = mft_tm;
    }

    public Date getDistb_tlmt() {
        return distb_tlmt;
    }

    public void setDistb_tlmt(Date distb_tlmt) {
        this.distb_tlmt = distb_tlmt;
    }

    public String getWarn() {
        return warn;
    }

    public void setWarn(String warn) {
        this.warn = warn;
    }

    public Integer getSle_quty() {
        return sle_quty;
    }

    public void setSle_quty(Integer sle_quty) {
        this.sle_quty = sle_quty;
    }

    public Integer getMax_sle_quty() {
        return max_sle_quty;
    }

    public void setMax_sle_quty(Integer max_sle_quty) {
        this.max_sle_quty = max_sle_quty;
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

    public Integer getSfkp_tp_state_cd() {
        return sfkp_tp_state_cd;
    }

    public void setSfkp_tp_state_cd(Integer sfkp_tp_state_cd) {
        this.sfkp_tp_state_cd = sfkp_tp_state_cd;
    }

    public Date getCreate_tm() {
        return create_tm;
    }

    public void setCreate_tm(Date create_tm) {
        this.create_tm = create_tm;
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

    public Integer getInv_quty() {
        return inv_quty;
    }

    public void setInv_quty(Integer inv_quty) {
        this.inv_quty = inv_quty;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCpnm() {
        return cpnm;
    }

    public void setCpnm(String cpnm) {
        this.cpnm = cpnm;
    }

    public Integer getDlvry_type_cd() {
        return dlvry_type_cd;
    }

    public void setDlvry_type_cd(Integer dlvry_type_cd) {
        this.dlvry_type_cd = dlvry_type_cd;
    }

    public Integer getPack_state_cd() {
        return pack_state_cd;
    }

    public void setPack_state_cd(Integer pack_state_cd) {
        this.pack_state_cd = pack_state_cd;
    }

    public Integer getDlvry_mthd_state_cd() {
        return dlvry_mthd_state_cd;
    }

    public void setDlvry_mthd_state_cd(Integer dlvry_mthd_state_cd) {
        this.dlvry_mthd_state_cd = dlvry_mthd_state_cd;
    }

    public String getDlvry_mthd_warn() {
        return dlvry_mthd_warn;
    }

    public void setDlvry_mthd_warn(String dlvry_mthd_warn) {
        this.dlvry_mthd_warn = dlvry_mthd_warn;
    }

    public String getDexp_poli() {
        return dexp_poli;
    }

    public void setDexp_poli(String dexp_poli) {
        this.dexp_poli = dexp_poli;
    }

    public String getDlvry_vend() {
        return dlvry_vend;
    }

    public void setDlvry_vend(String dlvry_vend) {
        this.dlvry_vend = dlvry_vend;
    }

    public Integer getTlmt() {
        return tlmt;
    }

    public void setTlmt(Integer tlmt) {
        this.tlmt = tlmt;
    }

    public Integer getDexp() {
        return dexp;
    }

    public void setDexp(Integer dexp) {
        this.dexp = dexp;
    }

    // toString
    @Override
    public String toString() {
        return "{" +
                "idx=" + idx +
                ", seler_prod_cd=" + seler_prod_cd +
                ", name='" + name + '\'' +
                ", prc=" + prc +
                ", ctent='" + ctent + '\'' +
                ", dc_state_cd=" + dc_state_cd +
                ", dc_rate=" + dc_rate +
                ", dsply_state_cd=" + dsply_state_cd +
                ", orplc='" + orplc + '\'' +
                ", sle_unit='" + sle_unit + '\'' +
                ", weight='" + weight + '\'' +
                ", mft_tm=" + mft_tm +
                ", distb_tlmt=" + distb_tlmt +
                ", warn='" + warn + '\'' +
                ", sle_quty=" + sle_quty +
                ", max_sle_quty=" + max_sle_quty +
                ", reg_state_cd=" + reg_state_cd +
                ", state_cd=" + state_cd +
                ", sfkp_tp_state_cd=" + sfkp_tp_state_cd +
                ", create_tm=" + create_tm +
                ", sle_start_tm=" + sle_start_tm +
                ", sle_end_tm=" + sle_end_tm +
                ", inv_quty=" + inv_quty +
                ", guid='" + guid + '\'' +
                ", cpnm='" + cpnm + '\'' +
                ", dlvry_type_cd=" + dlvry_type_cd +
                ", pack_state_cd=" + pack_state_cd +
                ", dlvry_mthd_state_cd=" + dlvry_mthd_state_cd +
                ", dlvry_mthd_warn='" + dlvry_mthd_warn + '\'' +
                ", dexp_poli='" + dexp_poli + '\'' +
                ", dlvry_vend='" + dlvry_vend + '\'' +
                ", tlmt=" + tlmt +
                ", dexp=" + dexp +
                '}';
    }
}
