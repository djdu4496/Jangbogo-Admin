package com.jangbogo.admin.controller;

import com.jangbogo.admin.domain.*;
import com.jangbogo.admin.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    // 메서드명 : getList 후기(review)
    // 기   능 : 상품 후기 목록 가져오기
    // 매개변수 : Model model, SearchCondition sc
    // 반환타입 : String
    @GetMapping("/board/review/list")
    public String getList(Model model, SearchCondition sc) {
        List<ProdReviewDto> list = null;                                // 변수명 : list - 저장값 : OrderDto 저장소 List
        try {
            int totalCnt = boardService.ReviewSearchResultCnt(sc);      // 변수명 : totalCnt - 저장값 : 주문내역 목록 검색 결과 개수
            System.out.println("totalCnt = " + totalCnt);
            PageHandler pageHandler = new PageHandler(totalCnt, sc);    // PageHandler 객체 생성(인자 - totalCnt, sc)
//            System.out.println("pageHandler = " + pageHandler);
            list = boardService.ReviewSelectedPage(sc);                      // orderService 의 getSearchSelectPage 메서드 호출, 반환값을 list 에 저장
            System.out.println("list = " + list);

            model.addAttribute("totalCnt", totalCnt);       // Model 에 totalCnt 를 K/V로 저장
            model.addAttribute("list", list);               // Model 에 list 를 K/V로 저장
            model.addAttribute("ph", pageHandler);          // Model 에 PageHandler 를 K/V로 저장
            return "/board/reviewList";                                 // reviewList 뷰(view) 페이지로 이동
        } catch (Exception e) {                                         // 에러 발생 시
            e.printStackTrace();                                        // 1) 에러 내용을 로그에 출력
            return "redirect:/";                                        // 2) 메인 페이지로 리다이렉트
        }
    }


    // 메서드명 : getReviewDetail
    // 기   능 : 주문 상세 페이지 이동
    // 반환타입 : String
    // 매개변수 : @PathVariable Integer idx(상품후기일련번호), Model model
    @GetMapping("/board/review/list/{idx}")
    public String getReviewDetail(@PathVariable Integer idx, Model m) {
        ProdReviewDto list = null;                                                                               // 변수명 : list - 저장값 : OrderDetailDto 저장소 List
        try {
            list = boardService.selectReviewDetail(idx);                                                                    // orderService의 getList메서드 호출, 반환값을 list에 저장
            m.addAttribute("list", list);                                                                           // Model에 list를 K/V로 저장
            System.out.println("list = " + list);
            m.addAttribute("idx", idx);                                                                             // Model에 idx를 K/V로 저장

            return "/board/reviewDetail";                                                                                      // "/order/order.jsp" 뷰 이름 반환 - 뷰 렌더링
        } catch(Exception e) {                                                                                          // 에러 발생 시
            e.printStackTrace();                                                                                        // 1) 에러 내용을 로그에 출력
            return "redirect:/";                                                                                        // 2) 메인 페이지로 리다이렉트
        }
    }
//
//
//    //회원 상세 조회
//    @GetMapping("/user/read")
//    public String readUser(Integer idx, SearchCondition sc, Model m, RedirectAttributes rattr) {
//        try {
//            m.addAttribute("user", service.getUserByIdx(idx));
//            m.addAttribute("addrList", addrService.getAddrList(idx));
//            return "/user/read";
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            rattr.addFlashAttribute("msg", "EXCEPTION_ERR");
//            return "redirect:/user/list" + sc.getQueryString();
//        }
//    }

//    상품문의
    @GetMapping("/board/inqry/list")
    public String showInqryList(Model m) {

        try {
            List<ProdInqryDto> list = boardService.showProdInqryList();
            Integer totalCnt = boardService.cntWaitingAnswer();
            m.addAttribute("list", list);
            m.addAttribute("totalCnt", totalCnt);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/board/inqryList";
    }

    @GetMapping("/board/inqry/ans/yet/{idx}")
    public String showInqryAnsYet(@PathVariable Integer idx, Model m) {
//        System.out.println("idx???"+idx);
        try {
            ProdInqryDto inqry = boardService.showOneInqry(idx);
            m.addAttribute("inqry", inqry);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/board/inqryAnsYet";
    }

    @GetMapping("/board/inqry/ans/ok/{idx}")
    public String showInqryAnsOk(@PathVariable Integer idx, Model m) {
        try {
            ProdInqryDto inqry = boardService.showAnsOKInqry(idx);
            m.addAttribute("inqry", inqry);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/board/inqryAnsOk";
    }

    @PostMapping("/board/inqry/register/answer")
    public ResponseEntity<String> regAns(@RequestBody ProdInqryAnsDto prodInqryAnsDto) {
        try {
            if(boardService.insertInqry(prodInqryAnsDto) != 1) {
                return new ResponseEntity<String>("insert error", HttpStatus.BAD_REQUEST);
            }
            Integer idx = prodInqryAnsDto.getIdx();
            boardService.changeAnsState(idx);
            return new ResponseEntity<String>("insert ok", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("insert error", HttpStatus.BAD_REQUEST);
        }
    }

//    @PostMapping("/board/inqry/register/answer")
    public ResponseEntity<String> regAnswer(@RequestBody ProdInqryAnsDto prodInqryAnsDto) {
        System.out.println("???");
        try {
            if(boardService.insertInqry(prodInqryAnsDto) != 1) {
                throw new Exception("insert failed");
            }
                Integer idx = prodInqryAnsDto.getIdx();
            System.out.println("idx = " + idx);
                boardService.changeAnsState(idx);
            return new ResponseEntity<String>("insert_ok", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("insert_err", HttpStatus.BAD_REQUEST);
        }

    }

//    @PatchMapping()

}