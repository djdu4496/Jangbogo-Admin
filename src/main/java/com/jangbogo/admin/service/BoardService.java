package com.jangbogo.admin.service;

import com.jangbogo.admin.domain.ProdInqryAnsDto;
import com.jangbogo.admin.domain.ProdInqryDto;
import com.jangbogo.admin.domain.ProdReviewDto;
import com.jangbogo.admin.domain.SearchCondition;

import java.util.List;

public interface BoardService {
    List<ProdReviewDto> ReviewSelectedPage(SearchCondition sc) throws Exception;
    Integer ReviewSearchResultCnt(SearchCondition sc) throws Exception;
    ProdReviewDto selectReviewDetail(Integer idx) throws Exception;

//    상품문의
    List<ProdInqryDto> showProdInqryList() throws Exception;
    Integer cntWaitingAnswer() throws Exception;
    ProdInqryDto showOneInqry(Integer idx) throws Exception;
    ProdInqryDto showAnsOKInqry(Integer idx) throws Exception;
    Integer insertInqry(ProdInqryAnsDto prodInqryAnsDto) throws Exception;
    Integer changeAnsState(Integer idx) throws Exception;
}
