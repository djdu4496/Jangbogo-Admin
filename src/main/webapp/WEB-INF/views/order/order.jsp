<%--
  Created by IntelliJ IDEA.
  User: jiwoo
  Date: 2023/04/28
  Time: 2:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
    <head>
        <%@ include file="/WEB-INF/views/include/header.jsp" %>
        <link rel="stylesheet" href="/css/color.css">
        <link rel="stylesheet" href="/css/display.css">
        <title>관리자 | 주문상세내역</title>
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
                                    주문 상세 - 주문번호 : <span id="orderIdx">${idx}</span> | 주문총금액 <span id="orderTotalAmt"><fmt:formatNumber value="${list[0].tot_amt}" pattern="#,###"/></span>원
                                </h5>
                            </div>
                            <div class="card-body py-5 px-5">
                                <table class="table table-bordered py-md-3" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                    <tr>
                                        <th>결제완료일시</th>
                                        <th>주문자명</th>
                                        <th>상품명</th>
                                        <th>주문상품단가</th>
                                        <th>주문상품개수</th>
                                        <th>주문총금액</th>
                                        <th>결제방법</th>
                                        <th>주문상태</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="order" items="${list}">
                                                <tr>
                                                    <td class="id" id="ord_tm" data-time="${order.ord_tm}">${order.ord_tm}</td>
                                                    <td class="id">${order.ordr_nm}</td>
                                                    <td class="id">${order.prod_nm}</td>
                                                    <td class="id"><fmt:formatNumber value="${order.prod_prc}" pattern="#,###"/>원</td>
                                                    <td class="id">${order.prod_qty}개</td>
                                                    <td class="id"><fmt:formatNumber value="${order.prod_prc * order.prod_qty}" pattern="#,###"/>원</td>
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
                                <c:if test="${empty list}">
                                    <div class="pb-5 text-center">주문 정보가 없습니다</div>
                                </c:if>
                                <div class="d-flex justify-content-center mt-5">
                                    <button class="btn btn-danger px-md-4 py-md-2 mr-2" id="history_btn">주문이력</button>
                                    <button class="btn btn-light px-md-4 py-md-2 mr-2"
                                            id="list_btn">
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
            $(document).ready(() => {
                let date = $("#ord_tm").data("time");

                let now24Date = moment(new Date(date)).format("YYYY-MM-DD hh:mm:ss");
                $("#ord_tm").html(now24Date);

                let redirect_url = "<c:url value='/order/list'/>"
                $("#history_btn").click((e) => {
                    let order_idx = $("#orderIdx").text();
                    let url = "/order/" + order_idx + "/history";
                    location.href = url;
                });

                $("#list_btn").click(function (e) {
                    location.href = redirect_url;
                });

            });
        </script>
    </body>
</html>