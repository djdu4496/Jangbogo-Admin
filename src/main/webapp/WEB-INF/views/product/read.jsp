<%--
  Created by IntelliJ IDEA.
  User: jiwoo
  Date: 2023/05/04
  Time: 1:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <%@ include file="/WEB-INF/views/include/header.jsp" %>
        <link rel="stylesheet" href="/css/color.css">
        <link rel="stylesheet" href="/css/display.css">
    </head>
    <body id="page-top">
        <div id="wrapper">
            <%@ include file="/WEB-INF/views/include/navBar.jsp" %>
            <div id="content-wrapper" class="d-flex flex-column">
                <div id="content">
                    <%@ include file="/WEB-INF/views/include/topbar.jsp" %>
                    <div class="container-md">
                        <div class="card shadow mb-4">
                            <div class="card-header py-md-4">
                                <h5 class="m-0 font-weight-bold text-primary">
                                    상품 상세
                                </h5>
                            </div>
                            <div class="card-body py-5 px-5">
                                <table class="table table-bordered py-md-3" id="dataTable" width="100%" cellspacing="0">
                                    <tr>
                                        <td class="col-3 light-blue">상품번호</td>
                                        <td>${product.idx}</td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">판매자상품코드</td>
                                        <td>${product.seler_prod_cd}</td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">상호(브랜드명)</td>
                                        <td>${product.cpnm}</td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">상품이름</td>
                                        <td class="id">${product.name}</td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">상품가격</td>
                                        <td class="id">${product.prc}</td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">상품설명</td>
                                        <td class="id">${product.ctent}</td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">상품할인상태</td>
                                        <td class="id">
                                            <c:choose>
                                                <c:when test="${product.dc_state_cd == 1}">할인적용</c:when>
                                                <c:when test="${product.dc_state_cd == 2}">할인미적용</c:when>
                                            </c:choose>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">상품할인율</td>
                                        <td class="id">${product.dc_rate}%</td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">할인적용가</td>
                                        <td class="id">${product.dc_rate * product.prc * 0.01}원</td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">상품전시상태</td>
                                        <td class="id">
                                            <c:choose>
                                                <c:when test="${product.dc_state_cd == 1}">비전시</c:when>
                                                <c:when test="${product.dc_state_cd == 2}">전시</c:when>
                                            </c:choose>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">원산지</td>
                                        <td class="id">${product.orplc}</td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">판매단위</td>
                                        <td class="id">${product.sle_unit}</td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">중량</td>
                                        <td class="id">${product.weight}</td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">제조일자</td>
                                        <td class="id">
                                            <fmt:formatDate value="${product.mft_tm}" pattern="yyyy-MM-dd" type="date"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">유통기한</td>
                                        <td class="id">
                                            <fmt:formatDate value="${product.distb_tlmt}" pattern="yyyy-MM-dd" type="date"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">주의사항</td>
                                        <td class="id">
                                            ${product.warn}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">상품판매량</td>
                                        <td class="id">
                                            ${product.sle_quty}일
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">1회상품최대구매수량</td>
                                        <td class="id">
                                            ${product.max_sle_quty}개
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">상품등록상태코드</td>
                                        <td class="id">
                                            <c:choose>
                                                <c:when test="${product.reg_state_cd == 1}">대기</c:when>
                                                <c:when test="${product.reg_state_cd == 2}">승인</c:when>
                                                <c:when test="${product.reg_state_cd == 3}">거부</c:when>
                                            </c:choose>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">상품상태</td>
                                        <td class="id">
                                            <c:choose>
                                                <c:when test="${product.state_cd == 1}">재고있음</c:when>
                                                <c:when test="${product.state_cd == 2}">절판</c:when>
                                                <c:when test="${product.state_cd == 3}">판매자 탈퇴로인한 판매중지</c:when>
                                                <c:when test="${product.state_cd == 4}">품절</c:when>
                                            </c:choose>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">보관유형</td>
                                        <td class="id">
                                            <c:choose>
                                                <c:when test="${product.sfkp_tp_state_cd == 1}">냉장</c:when>
                                                <c:when test="${product.sfkp_tp_state_cd == 2}">상온</c:when>
                                                <c:when test="${product.sfkp_tp_state_cd == 3}">냉동</c:when>
                                            </c:choose>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">상품등록일</td>
                                        <td class="id">
                                            <fmt:formatDate value="${product.create_tm}" pattern="yyyy-MM-dd" type="date"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">상품판매시작일</td>
                                        <td class="id">
                                            ${product.sle_start_tm}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">상품판매종료일</td>
                                        <td class="id">
                                            ${product.sle_end_tm}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">상품재고수량</td>
                                        <td class="id">
                                            ${product.inv_quty}개
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">상품안내사항</td>
                                        <td class="id">
                                            ${product.guid}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">배송유형</td>
                                        <td class="id">
                                            <c:choose>
                                                <c:when test="${product.dlvry_type_cd == 1}">냉장</c:when>
                                                <c:when test="${product.dlvry_type_cd == 2}">상온</c:when>
                                                <c:when test="${product.dlvry_type_cd == 3}">냉동</c:when>
                                            </c:choose>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">배송포장</td>
                                        <td class="id">
                                            <c:choose>
                                                <c:when test="${product.pack_state_cd == 1}">종이박스</c:when>
                                                <c:when test="${product.pack_state_cd == 2}">아이스박스</c:when>
                                            </c:choose>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">배송방식</td>
                                        <td class="id">
                                            <c:choose>
                                                <c:when test="${product.dlvry_mthd_state_cd == 1}">택배</c:when>
                                                <c:when test="${product.dlvry_mthd_state_cd == 2}">픽업</c:when>
                                                <c:when test="${product.dlvry_mthd_state_cd == 3}">퀵</c:when>
                                            </c:choose>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="col-3 light-blue">배송주의사항</td>
                                        <td class="id">
                                            ${product.dlvry_mthd_warn}
                                        </td>
                                    </tr>
                                    <tr>
                                    <td class="col-3 light-blue">배송비정책</td>
                                    <td class="id">
                                        ${product.dexp_poli}
                                    </td>
                                    </tr>
                                    <td class="col-3 light-blue">배송업체</td>
                                    <td class="id">
                                        ${product.dlvry_vend}
                                    </td>
                                    </tr>
                                    <td class="col-3 light-blue">출고예상기한</td>
                                    <td class="id">
                                        ${product.tlmt}일
                                    </td>
                                    </tr>
                                    <td class="col-3 light-blue">배송비</td>
                                    <td class="id">
                                        ${product.dexp}원
                                    </td>
                                    </tr>
                                </table>
                                <div class="d-flex justify-content-center mt-5">
                                    <button class="btn btn-light px-md-4 py-md-2 mr-2"
                                            id="listBtn">
                                        목록으로
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%@ include file="/WEB-INF/views/include/footer.jsp" %>
            </div>
        </div>
        <%@ include file="/WEB-INF/views/include/script.jsp" %>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>

        <script>
            $(document).ready(function () {
                let redirect_url = "<c:url value='/product/list${searchCondition.queryString}'/>"

                $("#listBtn").click(function (e) {
                    location.href = redirect_url;
                });
            });
        </script>
    </body>
</html>
