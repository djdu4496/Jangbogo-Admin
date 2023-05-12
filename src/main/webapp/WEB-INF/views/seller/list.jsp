<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <%@ include file="/WEB-INF/views/include/header.jsp" %>
    <title>관리자 | 판매자목록</title>
</head>
<body id="page-top">
<div id="wrapper">
    <%@ include file="/WEB-INF/views/include/navBar.jsp" %>
    <div id="content-wrapper" class="d-flex flex-column">
        <div id="content">
            <%@ include file="/WEB-INF/views/include/topbar.jsp" %>
            <div class="container-fluid">
                <form
                        class="d-none form-inline mr-auto d-flex mb-4 mt-lg-5"
                        action="<c:url value='/seller/list'/>"
                        method="get"
                >
                    <select
                            class="custom-select col-xl-3"
                            name="option"
                    >
                        <option value="A"  ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>이메일+브랜드명</option>
                        <option value="S" ${ph.sc.option=='S' ? "selected" : ""}>상태코드</option>
                        <option value="E" ${ph.sc.option=='E' ? "selected" : ""}>이메일</option>
                        <option value="N" ${ph.sc.option=='N' ? "selected" : ""}>브랜드명</option>
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
                                <c:when test="${seller.state_cd == 99}">
                                    승인 대기 판매자 리스트
                                </c:when>
                                <c:otherwise>
                                    판매자 리스트
                                </c:otherwise>
                            </c:choose>
                        </h6>
                        <div class="ml-2">( ${totalCnt} 명 )</div>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>번호(idx)</th>
                                    <th>이메일</th>
                                    <th>브랜드명</th>
                                    <th>대표이름</th>
                                    <th>휴대전화</th>
                                    <th>상태</th>
                                    <th>등록날짜</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="seller" items="${list}">
                                    <tr>
                                        <td class="id">${seller.idx}</td>
                                        <td class="id"><a
                                                href="<c:url value="/seller/read${ph.sc.queryString}&idx=${seller.idx}"/>">${seller.email}</a>
                                        </td>
                                        <td class="id">${seller.cpnm}</td>
                                        <td class="id">${seller.repr_nm}</td>
                                        <td class="id">${seller.mpno}</td>
                                        <td class="id">
                                            <c:choose>
                                                <c:when test="${seller.state_cd == 1}">
                                                    승인(정상)
                                                </c:when>
                                                <c:when test="${seller.state_cd == 2}">
                                                    신고 정지
                                                </c:when>
                                                <c:when test="${seller.state_cd == 3}">
                                                    탈퇴
                                                </c:when>
                                                <c:when test="${seller.state_cd == 99}">
                                                    승인 대기
                                                </c:when>
                                            </c:choose>
                                        </td>
                                        <td class="id">
                                            <fmt:formatDate value="${seller.reg_tm}" pattern="yyyy-MM-dd"
                                                            type="date"/>
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
                            <div class="pb-5 text-center">판매자가 존재하지 않습니다</div>
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
<script>

</script>
</body>
</html>
