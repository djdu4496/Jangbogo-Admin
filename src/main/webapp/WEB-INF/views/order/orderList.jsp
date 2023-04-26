<%--
  Created by IntelliJ IDEA.
  User: jiwoo
  Date: 2023/04/26
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/views/include/header.jsp" %>
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
                        action="<c:url value='/user/list'/>"
                        method="get"
                >
                    <select
                            class="custom-select col-xl-3"
                            name="option"
                    >
                        <option value="A"  ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>주문자명 + 주문번호</option>
                        <option value="S" ${ph.sc.option=='S' ? "selected" : ""}>주문자명</option>
                        <option value="E" ${ph.sc.option=='E' ? "selected" : ""}>주문번호</option>
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
                            <c:choose>
                                <c:when test="${user.state_cd == 2}">
                                    신고된 회원 리스트
                                </c:when>
                                <c:otherwise>
                                    주문 리스트
                                </c:otherwise>
                            </c:choose>
                        </h6>
                        <div class="ml-2">( ${totalCnt} 명 )</div>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <tr>
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
                                        <td class="id">${order.idx}</td>
                                        <td class="id"><a
                                                href="<c:url value="/user/read${ph.sc.queryString}&idx=${user.idx}"/>">${user.email}</a>
                                        </td>
                                        <td class="id">${user.nick_nm}</td>
                                        <td class="id">${user.mpno}</td>
                                        <td class="id">
                                            <c:choose>
                                                <c:when test="${user.state_cd == 1}">
                                                    승인
                                                </c:when>
                                                <c:when test="${user.state_cd == 2}">
                                                    신고 정지
                                                </c:when>
                                                <c:when test="${user.state_cd == 3}">
                                                    탈퇴
                                                </c:when>
                                            </c:choose>
                                        </td>
                                        <td class="id">
                                            <fmt:formatDate value="${user.reg_tm}" pattern="yyyy-MM-dd" type="date"/>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <%--  end of card-body  --%>
                    <c:choose>
                        <c:when test="${totalCnt == null || totalCnt == 0}">
                            <div class="pb-5 text-center">회원이 존재하지 않습니다</div>
                        </c:when>
                        <c:otherwise>
                            <ul class="d-flex justify-content-center pagination">
                                <c:if test="${ph.showPrev}">
                                    <li class="page-item">
                                        <a class="page-link"
                                           href="<c:url value="/user/list${ph.sc.getQueryString(ph.beginPage-1)}"/>">&lt;</a>
                                    </li>
                                </c:if>
                                <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                                    <li class="page-item ${i==ph.sc.page? "active" : ""}">
                                        <a class="page-link"
                                           href="<c:url value="/user/list${ph.sc.getQueryString(i)}"/>">${i}</a>
                                    </li>
                                </c:forEach>
                                <c:if test="${ph.showNext}">
                                    <li class="page-item">
                                        <a class="page-link"
                                           href="<c:url value="/user/list${ph.sc.getQueryString(ph.endPage+1)}"/>">&gt;</a>
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
