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
                <select
                        class="custom-select col-xl-3"
                        aria-label="select example"
                >
                    <option selected>제목</option>
                    <option value="1"></option>
                    <option value="2">Two</option>
                </select>
                <form
                        id=""
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search"
                >
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
                            DataTables Example
                        </h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <tr>
                                    <th>번호(idx)</th>
                                    <th>이메일</th>
                                    <th>닉네임</th>
                                    <th>휴대전화</th>
                                    <th>등록날짜</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="user" items="${list}">
                                    <tr>
                                        <td class="id">${user.idx}</td>
                                        <td class="id">${user.email}</td>
                                        <td class="id">${user.nick_nm}</td>
                                        <td class="id">${user.mpno}</td>
                                        <td class="id">${user.reg_tm}</td>
                                            <%--                                        500에러. 추후 수정--%>
                                            <%--                                        <c:choose>--%>
                                            <%--                                            <c:when test="${user.reg_tm >= startOfToday}">--%>
                                            <%--                                                <td class="id">--%>
                                            <%--                                                    <fmt:formatDate--%>
                                            <%--                                                            value="${user.reg_tm}"--%>
                                            <%--                                                            pattern="HH:mm"--%>
                                            <%--                                                            type="time"--%>
                                            <%--                                                    />--%>
                                            <%--                                                </td>--%>
                                            <%--                                            </c:when>--%>
                                            <%--                                            <c:otherwise>--%>
                                            <%--                                                <td class="id">--%>
                                            <%--                                                    <fmt:formatDate--%>
                                            <%--                                                            value="${user.reg_tm}"--%>
                                            <%--                                                            pattern="yyyy-MM-dd"--%>
                                            <%--                                                            type="date"--%>
                                            <%--                                                    />--%>
                                            <%--                                                </td>--%>
                                            <%--                                            </c:otherwise>--%>
                                            <%--                                        </c:choose>--%>
                                    </tr>
                                </c:forEach>
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
                            <li class="page-link">
                                <a href="<c:url value='/user/list?page=${i}'/>">${i}</a>
                            </li>
                        </c:forEach>
                        <c:if test="${ph.showNext}">
                            <li class="page-link rounded-right">
                                <a
                                        class="page"
                                        href="<c:url value='/user/list?page=${ph.endPage+1}'/>">&gt;
                                </a>
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
<script>

</script>
</body>
</html>
