package com.jangbogo.admin.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Auth {

    public Auth() {}

    private int idx;
    private String name; //일반/판매자/관리자
}
