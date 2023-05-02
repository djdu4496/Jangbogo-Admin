<%--
  Created by IntelliJ IDEA.
  User: jiwoo
  Date: 2023/04/28
  Time: 5:17 PM
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
                  주문 이력 - 주문번호 : <span id="orderIdx">${idx}</span>
                </h5>
              </div>
              <div class="card-body py-5 px-5">
                <table class="table table-bordered py-md-3" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                  <tr>
                    <th>주문변경일시</th>
                    <th>주문상세번호</th>
                    <th>상품명</th>
                    <th>주문변경상태</th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="order" items="${list}">
                      <tr>
                        <td class="id">${order.chg_tm}</td>
                        <td class="id">${order.ord_dtl_idx}</td>
                        <td class="id">${order.prod_nm}</td>
                        <td class="id">
                          <c:choose>
                            <c:when test="${order.ord_state_cd== 1}">
                              주문완료
                            </c:when>
                            <c:when test="${order.ord_state_cd == 2}">
                              배송준비중
                            </c:when>
                            <c:when test="${order.ord_state_cd == 3}">
                              배송출발
                            </c:when>
                            <c:when test="${order.ord_state_cd == 4}">
                              배송완료
                            </c:when>
                            <c:when test="${order.ord_state_cd == 5}">
                              취소완료
                            </c:when>
                            <c:when test="${order.ord_state_cd == 6}">
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
                  <button class="btn btn-light px-md-4 py-md-2 mr-2"
                          id="detailBtn">
                    주문상세
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
        $("#detailBtn").click((e) => {
          let order_idx = $("#orderIdx").text();
          let url = "/order/" + order_idx;
          location.href = url;
        });

      });
    </script>
  </body>
</html>
