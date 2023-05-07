package com.jangbogo.admin.service;

import com.jangbogo.admin.dao.BoardDao;
import com.jangbogo.admin.domain.ProdInqryAnsDto;
import com.jangbogo.admin.domain.ProdInqryDto;
import com.jangbogo.admin.domain.ProdReviewDto;
import com.jangbogo.admin.domain.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardDao boardDao;



    @Override
    public List<ProdReviewDto> ReviewSelectedPage(SearchCondition sc) throws Exception {
        return boardDao.ReviewSelectedPage(sc);
    }

    @Override
    public Integer ReviewSearchResultCnt(SearchCondition sc) throws Exception {
        return boardDao.ReviewSearchResultCnt(sc);
    }

    public ProdReviewDto selectReviewDetail(Integer idx) throws Exception {
        return boardDao.selectReviewDetail(idx);
    }


//    상품문의
    public List<ProdInqryDto> showProdInqryList() throws Exception {
        return boardDao.showProdInqryList();
    }
    public Integer cntWaitingAnswer() throws Exception {
        return boardDao.cntWaitingAnswer();
    }
    public ProdInqryDto showOneInqry(Integer idx) throws Exception{
        return boardDao.showOneInqry(idx);
    }
    public ProdInqryDto showAnsOKInqry(Integer idx) throws Exception {
        return boardDao.showAnsOKInqry(idx);
    }
    public Integer insertInqry(ProdInqryAnsDto prodInqryAnsDto) throws Exception {
        return boardDao.insertInqry(prodInqryAnsDto);
    }
    public Integer changeAnsState(Integer idx) throws Exception {
        return boardDao.changeAnsState(idx);
    }
}
