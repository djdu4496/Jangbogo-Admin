<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            전체주문조회
                        </h6>
                        <div class="ml-2">( ${list.size()} 건 )</div>
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
                                            <td class="id">${order.ord_tm}</td>
                                            <td class="id">
                                                <a href="<c:url value='/order/${order.idx}'/>">
                                                    ${order.idx}
                                                </a>
                                            </td>
                                            <td class="id">${order.ordr_nm}</td>
                                            <td class="id">${order.prod_nm}</td>
                                            <td class="id">${order.tot_amt}</td>
                                            <td class="id">
                                                    ${order.setl_mn_cd == 1 ? "카카오페이" : "네이버페이"}
                                            </td>
                                            <td class="id">
                                                <c:choose>
                                                    <c:when test="${order.state_cd== 1}">
                                                        주문완료
                                                    </c:when>
                                                    <c:when test="${order.state_cd == 2}">
                                                        배송준비중
                                                    </c:when>
                                                    <c:when test="${order.state_cd == 3}">
                                                        배송출발
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
                </div>
            </div>
        </div>
        <%@ include file="/WEB-INF/views/include/footer.jsp" %>
    </div>
</div>
<%@ include file="/WEB-INF/views/include/script.jsp" %>
</body>
</html>
