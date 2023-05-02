<%--
  Created by IntelliJ IDEA.
  User: jiwoo
  Date: 2023/05/01
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/views/include/header.jsp" %>
    <style>
        .card-header {
            position: relative;
        }
        #deliveringBtn {
            position: absolute;
            right: 0;
            margin-right: 20px;
            border: none;
            padding: 6px 10px;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
    <script src = "/js/order/format.js"></script>
</head>
<body>
    <div id="wrapper">
        <%@ include file="/WEB-INF/views/include/navBar.jsp" %>
        <div id="content-wrapper" class="d-flex flex-column">
            <div id="content">
                <%@ include file="/WEB-INF/views/include/topbar.jsp" %>
                <div class="container-fluid">
                    <form
                            class="d-none form-inline mr-auto d-flex mb-4 mt-lg-5"
                            action="<c:url value='/order/list/paid'/>"
                            method="get"
                    >
                        <select
                                class="custom-select col-xl-3"
                                name="option"
                        >
                            <option value="A"  ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>전체</option>
                            <option value="E" ${ph.sc.option=='E' ? "selected" : ""}>주문자명</option>
                            <option value="N" ${ph.sc.option=='N' ? "selected" : ""}>주문번호</option>
                        </select>
                        <div class="input-group col-md-5">
                            <input type="text"
                                   name="keyword"
                                   class="form-control border-1 small"
                                   placeholder="검색어를 입력해 주세요"
                                   aria-label="Search" aria-describedby="basic-addon2"
                                   value="${ph.sc.keyword}"
                            >
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="submit">
                                    <i class="fas fa-search fa-sm"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                    <div class="card shadow mb-4">
                        <div class="card-header py-3 d-flex align-items-center">
                            <h6 class="m-0 font-weight-bold text-primary">
                                결제완료주문조회
                            </h6>
                            <div class="ml-2">( ${totalCnt} 건 )</div>
                            <button type="button" class="btn-danger" id="deliveringBtn">배송준비중 처리</button>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <tHead>
                                    <tr>
                                        <th>선택</th>
                                        <th>주문일자</th>
                                        <th>주문번호(idx)</th>
                                        <th>주문자명</th>
                                        <th>상품명</th>
                                        <th>주문총금액</th>
                                        <th>결제방법</th>
                                        <th>주문상태</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="order" items="${list}">
                                        <tr>
                                            <td class="id">
                                                <input type="checkbox" />
                                            </td>
                                            <td class="id">${order.ord_tm}</td>
                                            <td class="id data-oid">${order.idx}</td>
                                            <td class="id">${order.ordr_nm}</td>
                                            <td class="id">${order.prod_nm}</td>
                                            <td class="id">${order.tot_amt}원</td>
                                            <td class="id">
                                                    ${order.setl_mn_cd == 1 ? "카카오페이" : "네이버페이"}
                                            </td>
                                            <td class="id">
                                                <c:choose>
                                                    <c:when test="${order.state_cd== 1}">
                                                        결제완료
                                                    </c:when>
                                                </c:choose>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <%--  end of card-body  --%>
                        <c:choose>
                            <c:when test="${list == null || list.size() == 0}">
                                <div class="pb-5 text-center">주문내역이 존재하지 않습니다</div>
                            </c:when>
                            <c:otherwise>
                                <ul class="d-flex justify-content-center pagination">
                                    <c:if test="${ph.showPrev}">
                                        <li class="page-item">
                                            <a class="page-link"
                                               href="<c:url value="/order/list${ph.sc.getQueryString(ph.beginPage-1)}"/>">&lt;</a>
                                        </li>
                                    </c:if>
                                    <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                                        <li class="page-item ${i==ph.sc.page? "active" : ""}">
                                            <a class="page-link"
                                               href="<c:url value="/order/list/paid${ph.sc.getQueryString(i)}"/>">${i}</a>
                                        </li>
                                    </c:forEach>
                                    <c:if test="${ph.showNext}">
                                        <li class="page-item">
                                            <a class="page-link"
                                               href="<c:url value="/order/list/paid${ph.sc.getQueryString(ph.endPage+1)}"/>">&gt;</a>
                                        </li>
                                    </c:if>
                                </ul>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
            <%@ include file="/WEB-INF/views/include/footer.jsp" %>
        </div>
    </div>
    <%@ include file="/WEB-INF/views/include/script.jsp" %>
    <script>
        $(document).ready(() => {
            $("#deliveringBtn").click((e) => {                                                                          // 체크된 주문에 대해 '배송준비중' 처리
                                                                                                                        // 1. 변수 선언
                let length = $("#dataTable tBody").children().length;                                                   // 변수명 : length - 저정값 : 테이블 행 개수
                let isAnyBoxChecked = false;                                                                            // 변수명 : isAnyBoxChecked - 저장값 : 전체 체크박스 중 하나라도 체크드 상태인지 여부
                                                                                                                        // 2. 메서드 정의
                const checkAnyBoxChecked = () => {                                                                      // 메서드명 : checkAnyBoxChecked
                    for(let i = 0; i < length; i++) {                                                                   // 기   능 : (1) 각 자식 요소들의 체크드 여부를 확인 (2) 하나라도 체크드 상태면 isAnyBoxChecked에 true 저장
                        let isInputChecked = $("#dataTable tBody tr").children()[i * 8].children[0].checked;            // 변수명 : isInputChecked - 저장값 : 테이블의 i * 8 번째 td에 속한 input의 checked속성
                        if(isInputChecked) {                                                                            // isInputChecked이 참인 경우
                            isAnyBoxChecked = true                                                                      // isAnyBoxChecked에 true를 저장
                        }
                    }
                }

                const handleDeliveryPrepareBtn = () => {                                                                // 메서드명 : handleDeliveryPrepareBtn
                    for(let i = 0; i < length; i++) {                                                                   // 기   능 : 버튼 '클릭' 이벤트 발생 시, 주문 관련 테이블의 데이터들이 갖고 있는 '주문상태코드'를 1에서 2로 수정
                        let isInputChecked = $("#dataTable tBody tr").children()[i * 8].children[0].checked;            // 변수명 : isInputChecked - 저장값 : 테이블의 i * 8 번째 td에 속한 input의 checked속성
                        if(isInputChecked) {                                                                            // isInputChecked이 참인 경우
                            let orderIdx = $("#dataTable tBody tr").children()[i * 8 + 2].textContent;                  // 변수명 : orderIdx - 저장값 : 테이블의 i * 8 + 2번째 td에 속한 주문번호
                            $.ajax({                                                                                    // $.ajax() start
                                type:'PATCH',                                                                           // 요청 메서드
                                url: '/order/list/deliveryPreparing/'+ orderIdx,                                        // 요청 URI, 주문번호(order_idx)를 파라미터에 담아 요청
                                success : (result) => {                                                                 // 서버로부터 성공 응답이 도착하면 호출될 함수.
                                    location.reload();
                                },
                                error : () => {                                                                         // 서버로부터 실패 응답이 도착하면 호출될 함수
                                    alert("error");
                                }
                            });                                                                                         // $.ajax() end
                        }
                    }
                }
                                                                                                                        // 3. 메서드 호출
                checkAnyBoxChecked();                                                                                   // 3.1    체크된 체크박스가 있는지 확인, 없으면 핸들러 함수 호출 안 함
                if(isAnyBoxChecked) {                                                                                   // 3.2    체크된 체크박스가 하나 이상인 경우
                    if(!confirm("선택된 주문들의 상태를 '배송중' 처리하시겠습니까?")) return;                                        // 3.2.1 '배송중'처리 의사를 재확인
                    handleDeliveryPrepareBtn();                                                                         // 3.2.2  핸들러 함수 호출 - 체크된 주문들의 상태코드를 1에서 2로 수정
                }
            })
        })
    </script>
</body>
</html>