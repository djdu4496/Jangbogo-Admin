<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/views/include/header.jsp" %>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
                        action="<c:url value='/board/review/list'/>"
                        method="get"
                >
                    <select
                            class="custom-select col-xl-3"
                            name="option"
                    >
                        <option value="A"  ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ''}>전체</option>
                        <option value="PW" ${ph.sc.option=='PW' ? "selected" : ''}>상품명+작성자</option>
                        <option value="P" ${ph.sc.option=='P' ? "selected" : ''}>상품명</option>
                        <option value="W" ${ph.sc.option=='W' ? "selected" : ''}>작성자</option>
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
                            상품 후기 내역
                        </h6>
                        <div class="ml-2">( ${totalCnt} 개 )</div>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <tHead>
                                <tr>
                                    <th>상품후기일련번호</th>
                                    <th>작성자명</th>
                                    <th>상품번호</th>
                                    <th>상품명</th>
                                    <th>작성내용</th>
                                    <th>공개여부</th>
                                    <th>작성일자</th>
                                    <th>수정일자</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="review" items="${list}">
                                    <tr>
                                        <td class="id">
                                            <a href="<c:url value='/board/review/list/${review.idx}${ph.sc.queryString}'/>">
                                                    ${review.idx}
                                            </a>
                                        </td>
                                        <td class="id">${review.writer}</td>
                                        <td class="id">${review.prod_idx}</td>
                                        <td class="id">${review.name}</td>
                                        <td class="id">${fn:substring(review.ctent,0 ,10 )} ...</td>
                                        <td class="id">
                                                ${review.opub_yn == 'Y' ? "공개" : "비공개"}
                                        </td>
                                        <td class="id">
                                            <fmt:formatDate value="${review.reg_tm}" pattern="yyyy-MM-dd hh:mm" type="date"/>
                                        </td>
                                        <td class="id">
                                            <fmt:formatDate value="${review.chg_tm}" pattern="yyyy-MM-dd hh:mm" type="date"/>
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
                            <div class="pb-5 text-center">후기내역이 존재하지 않습니다</div>
                        </c:when>
                        <c:otherwise>
                            <ul class="d-flex justify-content-center pagination">
                                <c:if test="${ph.showPrev}">
                                    <li class="page-item">
                                        <a class="page-link"
                                           href="<c:url value="/board/review/list${ph.sc.getQueryString(ph.beginPage-1)}"/>">&lt;</a>
                                    </li>
                                </c:if>
                                <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                                    <li class="page-item ${i==ph.sc.page? "active" : ""}">
                                        <a class="page-link"
                                           href="<c:url value="/board/review/list${ph.sc.getQueryString(i)}"/>">${i}</a>
                                    </li>
                                </c:forEach>
                                <c:if test="${ph.showNext}">
                                    <li class="page-item">
                                        <a class="page-link"
                                           href="<c:url value="/board/review/list${ph.sc.getQueryString(ph.endPage+1)}"/>">&gt;</a>
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
