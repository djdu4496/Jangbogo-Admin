<%--
  Created by IntelliJ IDEA.
  User: jiwoo
  Date: 2023/05/04
  Time: 12:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/views/include/header.jsp" %>
    <title>관리자 | 전체상품내역</title>
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
                        action="<c:url value='/product/list'/>"
                        method="get"
                >
                    <select
                            class="custom-select col-xl-3"
                            name="option"
                    >
                        <option value="A"  ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>상품번호+상품이름</option>
                        <option value="E" ${ph.sc.option=='E' ? "selected" : ""}>상품번호</option>
                        <option value="N" ${ph.sc.option=='N' ? "selected" : ""}>상품이름</option>
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
                            '전체' 상품내역
                        </h6>
                        <div class="ml-2">( ${totalCnt} 건 )</div>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <tHead>
                                <tr>
                                    <th>상품번호</th>
                                    <th>상호(브랜드명)</th>
                                    <th>판매자상품코드</th>
                                    <th>상품이름</th>
                                    <th>상품가격</th>
                                    <th>상품할인상태</th>
                                    <th>상품할인율</th>
                                    <th>상품등록상태</th>
                                    <th>상품판매시작일</th>
                                    <th>상품판매종료일</th>
                                    <th>상품상태</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="product" items="${list}">
                                    <tr>
                                        <td class="id">${product.idx}</td>
                                        <td class="id">${product.cpnm}</td>
                                        <td class="id">${product.seler_prod_cd}</td>
                                        <td class="id">
                                            <a href="<c:url value='/product/read/${product.idx}'/>">
                                                    ${product.name}
                                            </a>
                                        </td>
                                        <td class="id">${product.prc}원</td>
                                        <td class="id">
                                            <c:choose>
                                                <c:when test="${product.dc_state_cd== 1}">
                                                    할인적용
                                                </c:when>
                                                <c:when test="${product.dc_state_cd== 2}">
                                                    할인없음
                                                </c:when>
                                            </c:choose>
                                        </td>
                                        <td class="id">${product.dc_rate}%</td>
                                        <td class="id">
                                            <c:choose>
                                                <c:when test="${product.state_cd== 1}">
                                                    재고있음
                                                </c:when>
                                                <c:when test="${product.state_cd== 2}">
                                                    절판
                                                </c:when>
                                                <c:when test="${product.state_cd== 3}">
                                                    판매자 탈퇴로 인한 판매중지
                                                </c:when>
                                                <c:when test="${product.state_cd== 4}">
                                                    품절
                                                </c:when>
                                            </c:choose>
                                        </td>
                                        <td class="id">
                                            <fmt:formatDate
                                                    value="${product.sle_start_tm}"
                                                    pattern="yyyy-MM-dd"
                                                    type="date"
                                            />
                                        </td>
                                        <td class="id">
                                            <fmt:formatDate
                                                    value="${product.sle_end_tm}"
                                                    pattern="yyyy-MM-dd"
                                                    type="date"
                                            />
                                        </td>
                                        <td class="id">
                                            <c:choose>
                                                <c:when test="${product.reg_state_cd== 1}">
                                                    대기
                                                </c:when>
                                                <c:when test="${product.reg_state_cd== 2}">
                                                    승인
                                                </c:when>
                                                <c:when test="${product.reg_state_cd== 3}">
                                                    반려
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
                                           href="<c:url value="/product/list${ph.sc.getQueryString(ph.beginPage-1)}"/>">&lt;</a>
                                    </li>
                                </c:if>
                                <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                                    <li class="page-item ${i==ph.sc.page? "active" : ""}">
                                        <a class="page-link"
                                           href="<c:url value="/product/list${ph.sc.getQueryString(i)}"/>">${i}</a>
                                    </li>
                                </c:forEach>
                                <c:if test="${ph.showNext}">
                                    <li class="page-item">
                                        <a class="page-link"
                                           href="<c:url value="/product/list${ph.sc.getQueryString(ph.endPage+1)}"/>">&gt;</a>
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
</body>
</html>
