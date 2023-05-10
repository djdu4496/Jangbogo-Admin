package com.jangbogo.admin.service;

import com.jangbogo.admin.dao.ProductDao;
import com.jangbogo.admin.domain.ProductDetailDto;
import com.jangbogo.admin.domain.ProductDto;
import com.jangbogo.admin.domain.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;

    // 메서드명 : getSearchResultCnt
    // 기   능 : ProductDao의 getSearchResultCnt메서드 호출 - '전체상품' 검색결과목록 수 조회
    // 반환타입 : int
    // 매개변수 : SearchCondition sc
    @Override
    public int getSearchResultCnt(SearchCondition sc) { return productDao.getSearchResultCnt(sc);}

    // 메서드명 : getSearchSelectPage
    // 기   능 : ProductDao의 getSearchSelectPage메서드 호출 - 전체상품조회
    // 반환타입 : List<ProductDto>
    // 매개변수 : SearchCondition sc
    @Override
    public List<ProductDto> getSearchSelectPage(SearchCondition sc) {return productDao.getSearchSelectPage(sc);}

    // 메서드명 : getPendingSearchSelectPage
    // 기   능 : ProductDao의 getPendingSearchSelectPage메서드 호출 - 승인대기 상태인 '상품' 검색결과목록 수 조회
    // 반환타입 : List<ProductDto>
    // 매개변수 : SearchCondition sc
    @Override
    public List<ProductDto> getPendingSearchSelectPage(SearchCondition sc) { return productDao.getPendingSearchSelectPage(sc);}

    // 메서드명 : getPendingSearchResultCnt
    // 기   능 : ProductDao의 getPendingSearchResultCnt메서드 호출 - 승인대기 상태인 '상품' 검색결과목록 수 조회
    // 반환타입 : int
    // 매개변수 : SearchCondition sc
    @Override
    public int getPendingSearchResultCnt(SearchCondition sc) { return productDao.getPendingSearchResultCnt(sc);}

    // 메서드명 : getProductRead
    // 기   능 : ProductDao의 getProductRead메서드 호출 - '상품'상세 조회
    // 반환타입 : ProductDetailDto
    // 매개변수 : Integer prod_idx - 상품번호
    @Override
    public ProductDetailDto getProductRead(Integer prod_idx) { return productDao.getProductDto(prod_idx);}

    // 메서드명 : updateProductRegState
    // 기   능 : ProductDao의 updateProductRegState 호출 -  상품번호 #{prod_idx}에 해당하는 상품의 상품상태코드를 #{reg_state_cd}로 변경
    // 반환타입 : int
    // 매개변수 : Map<Integer, Integer> pathVarsMap - Integer prod_idx (상품번호), reg_state_cd (상품상태코드)
    @Override
    public int updateProductRegState(Map<Integer, Integer> pathVarsMap) { return productDao.updateProductRegState(pathVarsMap);}
}
