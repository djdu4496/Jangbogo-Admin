package com.jangbogo.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//판매자의 정산신청 리스트, 내역, 출금이력 조회

public class SubscriptionController {

    @GetMapping("/subs/list")
    public String showSubsList () {
        return "subsList";
    }

    @GetMapping("/subs/read/{bno}")
    public String showSubsDetail (@PathVariable int bno) {
        return "subsDetail";
    }

    @GetMapping("/subs/history/list")
    public String showSubsHistoryList () {
        return "";
    }




}
