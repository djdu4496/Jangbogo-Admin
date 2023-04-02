<%--
  Created by IntelliJ IDEA.
  User: namgungjin
  Date: 2023/02/19
  Time: 6:08 PM
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
        <!-- Main Content -->
        <div id="content">
            <%@ include file="/WEB-INF/views/include/topbar.jsp" %>

            <div class="container-fluid">
                <select
                        class="custom-select col-xl-3"
                        aria-label="select example"
                >
                    <option value="0">제목</option>
                    <option value="1"></option>
                    <option value="2">Two</option>
                </select>
                <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                    <div class="input-group">
                        <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                               aria-label="Search" aria-describedby="basic-addon2">
                        <div class="input-group-append">
                            <button class="btn btn-primary" type="button">
                                <i class="fas fa-search fa-sm"></i>
                            </button>
                        </div>
                    </div>
                </form>
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">
                            판매자 리스트
                        </h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <tr>
                                    <%--                                    리스트는 관리자가 당장 볼 것들로 조회. 나머지는 상세에서--%>
                                    <th>IDX</th>
                                    <th>EMAIL</th>
                                    <th>NICKNAME</th>
                                    <th>STATE_CD</th>
                                    <th>REG_TM</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%--                                <c:forEach var="userDto" items="${list}">--%>
                                <tr>
                                    <a href="/read/seller/100">
                                        <td class="id">${userDto.id}100</td>
                                    </a>
                                    <a href="/read/seller/100">
                                        <td class="id">${userDto.pwd}jinvicky</td>
                                    </a>
                                    <td class="id">${userDto.email}jin</td>
<%--                                        code에 따른 String 처리 필요 0: 대기--%>
                                    <td class="id">${userDto.email}대기</td>
                                    <td class="id">${userDto.email}2023/03/23</td>
                                </tr>
                                <%--                                </c:forEach>--%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <%--  end of card-body  --%>
                    <ul class="d-flex justify-content-center pagination">
                        <c:if test="${ph.showPrev}">
                            <li class="page-link rounded-left"><a class="page-link" href="#">Previous</a></li>
                        </c:if>
                        <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                            <li class="page-link"><a href="<c:url value="/user/list?page=${i}"/>">${i}</a></li>
                        </c:forEach>
                        <c:if test="${ph.showNext}">
                            <li class="page-link rounded-right"><a class="page"
                                                                   href="<c:url value="/user/list?page=${ph.endPage+1}"/>">&gt;</a>
                            </li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </div>
        <%@ include file="/WEB-INF/views/include/footer.jsp" %>

    </div>
</div>

<%@ include file="/WEB-INF/views/include/script.jsp" %>
</body>
</html>
