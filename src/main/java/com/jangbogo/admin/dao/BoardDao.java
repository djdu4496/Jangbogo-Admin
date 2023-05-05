package com.jangbogo.admin.dao;

import com.jangbogo.admin.domain.ProdReviewDto;
import com.jangbogo.admin.domain.SearchCondition;

import java.util.List;

public interface BoardDao {
    List<ProdReviewDto> ReviewSelectedPage(SearchCondition sc) throws Exception;

    Integer ReviewSearchResultCnt(SearchCondition sc) throws Exception;

    ProdReviewDto selectReviewDetail(Integer idx) throws Exception;
    Integer toDeleteState(Integer idx) throws Exception;
    Integer toRegisterState(Integer idx) throws Exception;
    Integer checkState(Integer idx) throws Exception;
}
