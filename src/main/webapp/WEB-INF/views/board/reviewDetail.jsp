<%--
  Created by IntelliJ IDEA.
  User: imtheKingsky
  Date: 2023/05/05
  Time: 12:01 PM
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
                            후기 상세
                        </h5>
                    </div>
                    <div class="card-body py-5 px-5">
                        <table class="table table-bordered py-md-3" id="dataTable" width="100%" cellspacing="0">
                            <tr>
                                <td class="col-3 light-blue">일련번호(idx)</td>
                                <td>${list.idx}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">주문번호</td>
                                <td>
                                    ${list.ord_idx}
                                </td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">상품번호</td>
                                <td class="id">${list.prod_idx}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">상품명</td>
                                <td class="id">${list.name}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">회원번호</td>
                                <td class="id">${list.user_idx}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">작성자</td>
                                <td class="id">${list.writer}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">이메일</td>
                                <td class="id">${list.email}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">휴대전화번호</td>
                                <td class="id">${list.mpno}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">공개여부</td>
                                <td class="id">${list.opub_yn == 'Y' ? "공개" : "비공개"}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">작성일자</td>
                                <td class="id"><fmt:formatDate value="${list.reg_tm}" pattern="yyyy-MM-dd hh:mm" type="date"/></td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">수정일자</td>
                                <td class="id">${list.upt_tm}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">작성내용</td>
                                <td class="id">${list.ctent}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">상태코드</td>
                                <td class="id">
                                    <c:choose>
                                        <c:when test="${list.state_cd == 1}">등록</c:when>
                                        <c:when test="${list.state_cd == 2}">삭제</c:when>
                                    </c:choose>
                                </td>
                            </tr>

                        </table>
                        <div class="d-flex justify-content-center mt-5">
                            <button class="btn btn-light px-md-4 py-md-2 mr-2"
                                    id="list_btn">
                                목록으로
                            </button>
<%--                            <c:if test="${list.state_cd != 2}">--%>
<%--                                <button class="btn btn-danger px-md-4 py-md-2" id="report_btn">삭제하기</button>--%>
<%--                            </c:if>--%>
                            <c:choose>
                                <c:when test="${list.state_cd == 1}">
                                    <button class="btn btn-danger px-md-4 py-md-2" id="delete_btn">삭제</button>
                                </c:when>
                                <c:when test="${list.state_cd == 2}">
                                    <button type="button" class="btn btn-primary" id="re-register_btn">재등록</button>
                                </c:when>
                            </c:choose>
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
        let redirect_url = "<c:url value='/board/review/list${searchCondition.queryString}'/>"

        // '목록으로' 버튼 클릭 시 후기 목록 창으로 되돌아간다
        $("#list_btn").click(function (e) {
            location.href = redirect_url;
        });

        // '삭제' 버튼 클릭 시
        $("#delete_btn").click(function (e) {
            e.preventDefault();
            let idx = ${list.idx};              // 상품후기일련번호 변수 선언

            if (confirm("정말로 삭제하시겠습니까?")) { // (delete_confirm) -> '정말로 삭제하시겠습니까?'
                $.ajax({
                    url: '/board/review/list/' + idx,
                    <%--data: {idx: ${user.idx}, email: "${user.email}"},--%>
                    type: 'PATCH',
                    success: function (msg) {
                        if (msg === "DELETE_OK") {
                            alert("삭제에 성공했습니다");
                            console.log("h2");
                            location.href = redirect_url;
                        }
                    },
                    error: function (err) {
                        alert(error_msg);
                    }
                }); //$.ajax
            }
        });

        // '재등록' 버튼 클릭 시
        $("#re-register_btn").click(function (e) {
            e.preventDefault();
            let idx = ${list.idx};              // 상품후기일련번호 변수 선언

            if (confirm("재등록하시겠습니까?")) { // (delete_confirm) -> '정말로 삭제하시겠습니까?'
                $.ajax({
                    url: '/board/review/list/' + idx,
                    <%--data: {idx: ${user.idx}, email: "${user.email}"},--%>
                    type: 'PATCH',
                    success: function (msg) {
                        if (msg === "REGISTER_OK") {
                            alert("재등록에 성공했습니다");
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
