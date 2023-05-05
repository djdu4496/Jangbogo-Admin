package com.jangbogo.admin.service;

import com.jangbogo.admin.dao.BoardDao;
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


}
