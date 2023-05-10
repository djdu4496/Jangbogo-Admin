package com.jangbogo.admin.dao;

import com.jangbogo.admin.domain.ProductDetailDto;
import com.jangbogo.admin.domain.ProductDto;
import com.jangbogo.admin.domain.SearchCondition;

import java.util.List;
import java.util.Map;

public interface ProductDao {
    int getSearchResultCnt(SearchCondition sc);

    List<ProductDto> getSearchSelectPage(SearchCondition sc)                                                                                                                   // 반환타입 : List<ProductDto> - 매개변수 : SearchCondition sc
    ;

    ProductDetailDto getProductDto(Integer prod_idx)                                                                                                                   // 반환타입 : ProductDetailDto - 매개변수 : Integer prod_idx
    ;

    int getPendingSearchResultCnt(SearchCondition sc)                                                                                                                   // 반환타입 : ProductDetailDto - 매개변수 : SearchCondition sc
    ;

    List<ProductDto> getPendingSearchSelectPage(SearchCondition sc)                                                                                                                   // 반환타입 : ProductDetailDto - 매개변수 : SearchCondition sc
    ;

    int updateProductRegState(Map<Integer, Integer> pathVarsMap)                                                                                                                   // 반환타입 : int - 매개변수 : Map<Integer, Integer> pathVarsMap
    ;
}
