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
                        <option value="S" ${ph.sc.option=='S' ? "selected" : ""}>상태코드</option>
                        <option value="E" ${ph.sc.option=='E' ? "selected" : ""}>작성자</option>
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
<%--                                    승인 대기 판매자 리스트--%>
                                </c:when>
                                <c:otherwise>
                                    정상 문의 답변 대기
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
                    <%--  end of card-body  --%>
<%--                    <c:choose>--%>
<%--                        <c:when test="${totalCnt == null || totalCnt == 0}">--%>
<%--                            <div class="pb-5 text-center">판매자가 존재하지 않습니다</div>--%>
<%--                        </c:when>--%>
<%--                        <c:otherwise>--%>
<%--                            <ul class="d-flex justify-content-center pagination">--%>
<%--                                <c:if test="${ph.showPrev}">--%>
<%--                                    <li class="page-item">--%>
<%--                                        <a class="page-link"--%>
<%--                                           href="<c:url value="/user/list${ph.sc.getQueryString(ph.beginPage-1)}"/>">&lt;</a>--%>
<%--                                    </li>--%>
<%--                                </c:if>--%>
<%--                                <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">--%>
<%--                                    <li class="page-item ${i==ph.sc.page? "active" : ""}">--%>
<%--                                        <a class="page-link"--%>
<%--                                           href="<c:url value="/user/list${ph.sc.getQueryString(i)}"/>">${i}</a>--%>
<%--                                    </li>--%>
<%--                                </c:forEach>--%>
<%--                                <c:if test="${ph.showNext}">--%>
<%--                                    <li class="page-item">--%>
<%--                                        <a class="page-link"--%>
<%--                                           href="<c:url value="/user/list${ph.sc.getQueryString(ph.endPage+1)}"/>">&gt;</a>--%>
<%--                                    </li>--%>
<%--                                </c:if>--%>
<%--                            </ul>--%>
<%--                        </c:otherwise>--%>
<%--                    </c:choose>--%>
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
