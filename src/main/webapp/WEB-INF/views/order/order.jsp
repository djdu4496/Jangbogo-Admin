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
        <title>Title</title>
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
                                주문 상세
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
                                    <th>주문상품금액</th>
                                    <th>주문총금액</th>
                                    <th>결제방법</th>
                                    <th>주문상태</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="order" items="${list}">
                                        <tr>
                                            <td class="id">${order.ord_tm}</td>
                                            <td class="id">${order.ordr_nm}</td>
                                            <td class="id">${order.prod_nm}</td>
                                            <td class="id">${order.prod_prc}원</td>
                                            <td class="id">${order.prod_qty}개</td>
                                            <td class="id">${order.prod_prc * order.prod_qty}원</td>
                                            <td class="id">${order.tot_amt}원</td>
                                            <td class="id">${order.setl_mn_cd}</td>
                                            <td class="id">${order.state_cd}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <c:if test="${empty list}">
                                <div class="pb-5 text-center">주문 정보가 없습니다</div>
                            </c:if>
                            <div class="d-flex justify-content-center mt-5">
                                <button class="btn btn-primary px-md-4 py-md-2 mr-2" id="history_btn">주문이력</button>
                                <button class="btn btn-light px-md-4 py-md-2 mr-2"
                                        id="list_btn">
                                    목록으로
                                </button>
                                <c:if test="${user.state_cd != 2}">
                                    <button class="btn btn-danger px-md-4 py-md-2" id="report_btn">신고하기</button>
                                </c:if>
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
            let redirect_url = "<c:url value='/user/list${searchCondition.queryString}'/>"

            $("#list_btn").click(function (e) {
                location.href = redirect_url;
            });

            $("#report_btn").click(function (e) {
                e.preventDefault();

                if (confirm(report_confirm)) {
                    $.ajax({
                        url: '/user/report',
                        data: {idx: ${user.idx}, email: "${user.email}"},
                        type: 'POST',
                        success: function (msg) {
                            if (msg === "REPORT_OK") {
                                alert(report_ok);
                                location.href = redirect_url;
                            }
                        },
                        error: function (err) {
                            alert(error_msg);
                        }
                    }); //$.ajax
                }
            });
        });
    </script>
    </body>
</html>
