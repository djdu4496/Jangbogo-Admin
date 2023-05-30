package com.jangbogo.admin.dao;

import com.jangbogo.admin.domain.ProdInqryAnsDto;
import com.jangbogo.admin.domain.ProdInqryDto;
import com.jangbogo.admin.domain.ProdReviewDto;
import com.jangbogo.admin.domain.SearchCondition;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDaoImpl implements BoardDao {

    @Autowired
    SqlSession session;

    private static String nameSpace ="com.jangbogo.admin.dao.BoardMapper.";

    @Override
    public List<ProdReviewDto> ReviewSelectedPage(SearchCondition sc) throws Exception {
        return session.selectList( nameSpace + "ReviewSelectedPage", sc);
    }

    @Override
    public Integer ReviewSearchResultCnt(SearchCondition sc) throws Exception {
        return session.selectOne( nameSpace + "ReviewSearchResultCnt", sc);
    }

    @Override
    public ProdReviewDto selectReviewDetail(Integer idx) throws Exception {
        return session.selectOne( nameSpace + "selectReviewDetail", idx);
    }

    @Override
    public Integer toDeleteState(Integer idx) throws Exception {
        return session.update( nameSpace + "toDeleteState", idx);
    }

    @Override
    public Integer toRegisterState(Integer idx) throws Exception {
        return session.update( nameSpace + "toRegisterState", idx);
    }

    @Override
    public Integer checkState(Integer idx) throws Exception {
        return session.selectOne( nameSpace + "checkState", idx);
    }

//    상품 문의
    @Override
    public List<ProdInqryDto> showProdInqryList(SearchCondition sc) throws Exception {
        return session.selectList(nameSpace + "selectProdInqryPage", sc);
    }
    @Override
    public int getSearchResultCnt(SearchCondition sc) {                                                                 // 메서드명 : getSearchResultCnt
        return session.selectOne(nameSpace + "selectResultCnt", sc);                                                 // 기   능 : boardMapper.xml에 있는 SQL문을 실행하여 주문내역 수 조회 결과 반환
    }

    public Integer cntWaitingAnswer() throws Exception {
        return session.selectOne(nameSpace + "cntWaitingAnswer");
    }

    public ProdInqryDto showOneInqry(Integer idx) throws Exception {
        return session.selectOne(nameSpace + "showOneInqry", idx);
    }

    public ProdInqryDto showAnsOKInqry(Integer idx) throws Exception {
        return session.selectOne(nameSpace + "showAnsOKInqry", idx);
    }

    public Integer insertInqry(ProdInqryAnsDto prodInqryAnsDto) throws Exception {
        return session.insert(nameSpace + "insertInqry", prodInqryAnsDto);
    }

    public Integer changeAnsState(Integer idx) throws Exception {
        return session.update(nameSpace + "changeAnsState", idx);
    }

    public Integer updateAnswer(ProdInqryAnsDto prodInqryAnsDto) throws Exception {
        return session.update(nameSpace + "updateAnswer", prodInqryAnsDto);
    }

    public Integer updateAnsTbCode(Integer idx) throws Exception {
        return session.update(nameSpace + "updateAnsTbCode", idx);
    }

    public Integer updateInqryTbCode(Integer idx) throws Exception {
        return session.update(nameSpace + "updateInqryTbCode", idx);
    }
}
