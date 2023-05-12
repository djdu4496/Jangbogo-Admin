<%--
  Created by IntelliJ IDEA.
  User: qpwo3
  Date: 2023-05-06
  Time: 오후 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <%@ include file="/WEB-INF/views/include/header.jsp" %>
    <title>관리자 | 상품문의내역</title>
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
                        action="<c:url value='/board/inqry/list'/>"
                        method="get"
                >
                    <select
                            class="custom-select col-xl-3"
                            name="option"
                    >
<%--                        <option value="A"  ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>이메일+브랜드명</option>--%>
                        <option value="A" ${ph.sc.option=='A' ? "selected" : ""}>전체</option>
                        <option value="W" ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>
                        <option value="P" ${ph.sc.option=='P' ? "selected" : ""}>상품이름</option>
                        <option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목</option>
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
<%--                                    승인 대기 판매자 리스트--%>
                                </c:when>
                                <c:otherwise>
                                    상품문의내역
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
                                    <th>상품이름</th>
                                    <th>작성자</th>
                                    <th>제목</th>
                                    <th>작성일자</th>
                                    <th>상품상태</th>
                                    <th>문의등록상태</th>
                                    <th>답변상태</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="inqry" items="${list}">
                                    <tr>
                                        <td class="id">${inqry.name}</td>
                                        <td class="id">${inqry.writer}</td>
                                        <c:choose>
                                            <c:when test="${inqry.res_state_cd == 1}">
                                                <td class="id"><a href="<c:url value="/board/inqry/ans/yet/${inqry.idx}"/>">${inqry.title}</a></td>
                                            </c:when>
                                            <c:when test="${inqry.res_state_cd == 2}">
                                                <td class="id"><a href="<c:url value="/board/inqry/ans/ok/${inqry.idx}"/>">${inqry.title}</a></td>
                                            </c:when>
                                            <c:when test="${inqry.state_cd == 3}">
                                                <a href="<c:url value="/board/inqry/ans/ok/${inqry.idx}"/>">${inqry.title}</a>
                                            </c:when>
                                        </c:choose>
                                        <td class="id"><fmt:formatDate value="${inqry.wrt_tm}" pattern="yyyy-MM-dd" type="date"/></td>
                                        <td class="id">
                                            <c:choose>
                                                <c:when test="${inqry.prodDetail_state_cd == 1}">
                                                    재고있음
                                                </c:when>
                                                <c:when test="${inqry.prodDetail_state_cd == 2}">
                                                    절판
                                                </c:when>
                                                <c:when test="${inqry.prodDetail_state_cd == 3}">
                                                    판매중지
                                                </c:when>
                                                <c:when test="${inqry.prodDetail_state_cd == 4}">
                                                    품절
                                                </c:when>
                                            </c:choose>
                                        </td>
                                        <td class="id">
                                            <c:choose>
                                                <c:when test="${inqry.state_cd == 1}">
                                                    정상
                                                </c:when>
                                                <c:when test="${inqry.state_cd == 2}">
                                                    관리자에 의해 삭제
                                                </c:when>
                                                <c:when test="${inqry.state_cd == 3}">
                                                    고객에 의해 삭제
                                                </c:when>
                                            </c:choose>
                                        </td>
                                        <td class="id">
                                            <c:choose>
                                                <c:when test="${inqry.res_state_cd == 1}">
                                                    답변대기
                                                </c:when>
                                                <c:when test="${inqry.res_state_cd == 2}">
                                                    답변완료
                                                </c:when>
                                            </c:choose>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@ include file="/WEB-INF/views/include/footer.jsp" %>
    </div>
</div>
<%@ include file="/WEB-INF/views/include/script.jsp" %>

<script>
    $(document).ready(function() {

    })

</script>
</body>
</html>
