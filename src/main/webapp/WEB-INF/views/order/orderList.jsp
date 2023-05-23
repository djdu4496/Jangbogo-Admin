<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/views/include/header.jsp" %>
    <script src="/js/order/format.js"></script>
    <title>관리자 | 전체주문내역</title>
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
                        action="<c:url value='/order/list'/>"
                        method="get"
                >
                    <select
                            class="custom-select col-xl-3"
                            name="option"
                    >
                        <option value="A"  ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>주문번호+주문자명</option>
                        <option value="N" ${ph.sc.option=='N' ? "selected" : ""}>주문번호</option>
                        <option value="E" ${ph.sc.option=='E' ? "selected" : ""}>주문자명</option>
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
                            '전체' 주문내역
                        </h6>
                        <div class="ml-2">( ${totalCnt} 건 )</div>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <tHead>
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
                                        <td class="id" id="ord_tm" data-time="${order.ord_tm}">${order.ord_tm}</td>
                                            <%--                                                <fmt:formatDate value="${order.ord_tm}" pattern="yyyy-MM-dd" type="time"/>--%>
                                        <td class="id">
                                            <a href="<c:url value='/order/${order.idx}'/>">
                                                    ${order.idx}
                                            </a>
                                        </td>
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
                                                <c:when test="${order.state_cd == 2}">
                                                    배송준비중
                                                </c:when>
                                                <c:when test="${order.state_cd == 3}">
                                                    배송중
                                                </c:when>
                                                <c:when test="${order.state_cd == 4}">
                                                    배송완료
                                                </c:when>
                                                <c:when test="${order.state_cd == 5}">
                                                    취소완료
                                                </c:when>
                                                <c:when test="${order.state_cd == 6}">
                                                    환불완료
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
                                           href="<c:url value="/order/list${ph.sc.getQueryString(i)}"/>">${i}</a>
                                    </li>
                                </c:forEach>
                                <c:if test="${ph.showNext}">
                                    <li class="page-item">
                                        <a class="page-link"
                                           href="<c:url value="/order/list${ph.sc.getQueryString(ph.endPage+1)}"/>">&gt;</a>
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<script>
    $(document).ready(function () {
        let date = $("#ord_tm").data("time");

        let now24Date = moment(new Date(date)).format("YYYY-MM-DD hh:mm:ss");
        $("#ord_tm").html(now24Date);
    });
</script>
</body>
</html>
