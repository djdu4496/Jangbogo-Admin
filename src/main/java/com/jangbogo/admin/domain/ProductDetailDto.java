package com.jangbogo.admin.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@AllArgsConstructor
@Builder
public class ProductDetailDto {

    public ProductDetailDto () {}
    // iv
    private Integer idx;                                                                                                // 상품번호 IDX - `PRODUCT` TABLE(PK)
    private Integer seler_prod_cd;                                                                                      // 판매자상품코드 SELER_PROD_CD
    private String name;                                                                                                // 상품이름 NAME
    private Integer prc;                                                                                                // 상품가격 PRC
    private String ctent;                                                                                               // 상품설명 CTENT
    private Integer dc_state_cd;                                                                                        // 상품할인상태코드 DC_STATE_CD
    private Integer dc_rate;                                                                                            // 상품할인율 DC_RATE
    private Integer dsply_state_cd;
    // 상품전시상태코드 DSPLY_STATE_CD - `PRODUCT` TABLE (FIN)

    private String upload_path; //상품 썸네일

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


}
