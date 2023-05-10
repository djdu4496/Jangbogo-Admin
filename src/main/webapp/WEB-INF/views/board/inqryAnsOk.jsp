<%--
  Created by IntelliJ IDEA.
  User: qpwo3
  Date: 2023-05-06
  Time: 오후 4:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                            문의 내용
                        </h5>
                    </div>
                    <div class="card-body py-5 px-5">
                        <table class="table table-bordered py-md-3" id="dataTable" width="100%" cellspacing="0">
                            <tr>
                                <td class="col-3 light-blue idx" data-idx="${inqry.idx}">상품문의번호</td>
                                <td>${inqry.idx}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue prod_idx" data-prod_idx="${inqry.prod_idx}">상품번호</td>
                                <td>${inqry.prod_idx}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">회원번호</td>
                                <td>${inqry.user_idx}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">문의 제목</td>
                                <td>${inqry.title}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">문의 내용</td>
                                <td class="id">${inqry.ctent}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">문의 작성자</td>
                                <td class="id">${inqry.writer}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">문의 답변 상태</td>
                                <c:choose>
                                    <c:when test="${inqry.res_state_cd == 1}">
                                        <td class="id">답변대기</td>
                                    </c:when>
                                    <c:when test="${inqry.res_state_cd == 2}">
                                        <td class="id">답변완료</td>
                                    </c:when>
                                </c:choose>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">문의 작성일자</td>
                                <td class="id">
                                    <fmt:formatDate value="${inqry.wrt_tm}" pattern="yyyy-MM-dd" type="date"/>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">문의답변 작성자</td>
                                <td class="id" id="ans_writer">${inqry.ans_writer}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">문의답변 작성내용</td>
                                <td class="id" id="ans_ctent">${inqry.ans_ctent}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">문의 답변작성 날짜</td>
                                <td class="id">
                                    <fmt:formatDate value="${inqry.ans_resps_tm}" pattern="yyyy-MM-dd" type="date"/>
                                </td>
                            </tr>
                        </table>
                        <div class="d-flex justify-content-center mt-5">
                            <button class="btn btn-light px-md-4 py-md-2 mr-2"
                                    id="listBtn">
                                목록으로
                            </button>
                            <c:choose>
                                <c:when test="${inqry.state_cd == 1}">
                                    <button class="btn btn-facebook px-md-4 py-md-2 mr-2"
                                            id="updateBtn">
                                        수정
                                    </button>
                                    <button class="btn btn-facebook px-md-4 py-md-2 mr-2"
                                            id="removeBtn">
                                        삭제
                                    </button>
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
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>

<script>



    $(document).ready(function() {
        $("#listBtn").click(function(e) {
            location.href = "/board/inqry/list";
        })

        $("#updateBtn").click(function(e) {
            e.preventDefault();
            let writer = $("#ans_writer").text();
            let ctent = $("#ans_ctent").text();
            console.log(writer);
            console.log(ctent);

            let idx = $(".idx").data("idx");
            location.href="<c:url value='/board/inqry/updatePage/"+ idx +"/"+ ctent +"/"+ writer +"'/>"
        })

        $("#removeBtn").click(function(e) {
            let idx = $('.idx').data('idx');
            $.ajax({
                type: 'PATCH',
                url: '/board/inqry/delete/'+idx,
                success: function(msg) {
                    if(msg === "UPDATE_ERR") {
                        alert("답변 삭제중 오류가 발생했습니다.");
                    } else if(msg === "UPDATE_OK") {
                        alert("답변이 삭제되었습니다.");
                        location.href = "/board/inqry/list";
                    }
                },
                error: function(msg) {
                    if(msg === "UPDATE_ERR"){
                        alert("답변 삭제중 오류가 발생했습니다.");
                    }
                }
            })
        })
    })
</script>
</body>
</html>
