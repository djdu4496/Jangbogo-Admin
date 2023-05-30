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

    @Override
    public ProdReviewDto selectReviewDetail(Integer idx) throws Exception {
        return boardDao.selectReviewDetail(idx);
    }

    @Override
    public Integer toDeleteState(Integer idx) throws Exception {
        return boardDao.toDeleteState(idx);
    }

    @Override
    public Integer toRegisterState(Integer idx) throws Exception {
        return boardDao.toRegisterState(idx);
    }
    @Override
    public Integer checkState(Integer idx) throws Exception {
        return boardDao.checkState(idx);
    }


//    상품문의
    @Override
    public List<ProdInqryDto> showProdInqryList(SearchCondition sc) throws Exception {
        return boardDao.showProdInqryList(sc);
    }
    @Override
    public Integer selectResultCnt(SearchCondition sc) throws Exception {
        return boardDao.getSearchResultCnt(sc);
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
    public Integer updateAnswer(ProdInqryAnsDto prodInqryAnsDto) throws Exception {
        return boardDao.updateAnswer(prodInqryAnsDto);
    }
    public Integer updateAnsTbCode(Integer idx) throws Exception {
        return boardDao.updateAnsTbCode(idx);
    }
    public Integer updateInqryTbCode(Integer idx) throws Exception {
        return boardDao.updateInqryTbCode(idx);
    }
}
