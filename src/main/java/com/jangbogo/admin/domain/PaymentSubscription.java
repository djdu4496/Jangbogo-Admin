package com.jangbogo.admin.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;


@Data
@AllArgsConstructor
@Builder
public class PaymentSubscription {

    private int idx; //정산신청번호

    private int req_amt; //신청금액

    private int req_state; //신청상태 1: 대기, 2: 승인, 3: 거절
    private int SETL_IDX; //결제, 송금번호
    private int CMPL_AMT; //정산완료금액

    private String reject_reason; //거절사유

    private Date req_date; //신청날짜
    private Date proc_date; //관리자처리날짜

}
