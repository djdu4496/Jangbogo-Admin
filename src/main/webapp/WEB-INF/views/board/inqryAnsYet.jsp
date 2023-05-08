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
    <style>
        textarea {
            overflow: auto;
            resize: none;
            width: 750px;
            height: 200px;
            box-sizing: border-box;

        }
    </style>
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

                            문의 ${mode == "update" ? "답변수정" : "답변작성"}
                        </h5>
                    </div>
                    <div class="card-body py-5 px-5" data-idx="${inqry.idx}">
                        <table class="table table-bordered py-md-3" id="dataTable" width="100%" cellspacing="0">
                            <tr>
                                <td class="col-3 light-blue" id="idx" data-idx="${inqry.idx}">상품문의번호</td>
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
                                <td class="col-3 light-blue">작성자</td>
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
                                <td class="col-3 light-blue">작성일자</td>
                                <td class="id">
                                    <fmt:formatDate value="${inqry.wrt_tm}" pattern="yyyy-MM-dd" type="date"/>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">답변 작성자</td>
                                <td class="id">
                                    <div class="input-line">
                                        <div class="input-box">
                                            <div class="input">
                                                <input
                                                        name="writer"
                                                        id="writer"
                                                        type="text"
                                                        value="${writer}"
                                                />
                                            </div>
                                            <div class="error-msg nick"></div>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">답변작성</td>
                                <td class="id">
                                    <textarea name="answer">${ctent}</textarea>
                                </td>
                            </tr>
                        </table>
                        <div class="d-flex justify-content-center mt-5">
                            <button class="btn btn-light px-md-4 py-md-2 mr-2"
                                    id="listBtn">
                                목록으로
                            </button>
                            <c:if test="${mode eq 'update'}">
                                <button class="btn btn-danger px-md-4 py-md-2 mr-2"
                                        id="updateBtn">
                                    수정
                                </button>
                            </c:if>
                            <c:if test="${mode eq ''}">
                            <button class="btn btn-danger px-md-4 py-md-2 mr-2"
                                    id="registerBtn">
                                등록
                            </button>
                            </c:if>
                            <button class="btn btn-facebook px-md-4 py-md-2 mr-2"
                                    id="removeBtn">
                                삭제
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
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>

<script>
    $(document).ready(function() {

        $("#listBtn").click(function(e) {
            location.href = "/board/inqry/list";
        })

        $('#registerBtn').click(function(e){
            let writer = $("input[name=writer]").val();
            let ctent = $("textarea[name=answer]").val();
            console.log(typeof ctent);
            console.log(typeof writer);
            let idx = $("#idx").data("idx");

            if(writer.trim() == '') {
                alert("작성자를 입력해주세요");
                return;
            }
            if(ctent.trim() == '') {
                alert("내용을 입력해주세요");
                return;
            }

            $.ajax({
                type:'POST',       // 요청 메서드
                url: '/board/inqry/register/answer',
                // headers : { "content-type": "application/json"}, // 요청 헤더
                data : {idx: idx, ctent: ctent, writer: writer},  // 서버로 전송할 데이터. stringify()로 직렬화 필요.

                success : function(){
                    alert("문의가 등록되었습니다.");
                    location.href="/board/inqry/list";
                },
                error   : function(){ alert("insert error") } // 에러가 발생했을 때, 호출될 함수
            });
        })

        $('#updateBtn').click(function(){
            let writer = $("input[name=writer]").val();
            let ctent = $("textarea[name=answer]").val();
            let idx = $("#idx").data("idx");
            console.log("writer"+writer);
            console.log("ctent" + ctent)
            console.log("idx" +idx);


            $.ajax({
                type:'PATCH',
                url:'/board/inqry/'+idx+'/'+ctent+'/'+writer,
                success : (msg) => {
                    if(msg === "UPDATE_ERR") {
                        alert("수정중 오류가 발생했습니다.")
                    } else if(msg = "UPDATE_OK") {
                        alert("수정되었습니다.")
                        location.href = "/board/inqry/list";
                    }
                },
                error : (msg) => {
                    if(msg === "EXCEPTION_ERR"){
                        alert("수정중 오류가 발생했습니다.");
                    }
                }
            })
        })

        $("#removeBtn").click(function(e) {
            let idx = $('#idx').data('idx');
            <%--console.log("idx=="+idx);--%>
            <%--let mode = "${mode}";--%>
            <%--let code = 2;--%>
            <%--if(mode == "update") {--%>
            <%--    code = 1;--%>
            <%--}--%>
            // console.log("mode"+mode);
            $.ajax({
                type: 'PATCH',
                url: '/board/inqry/delete/'+idx,
                success: function(msg) {
                    alert("success");
                    if(msg === "UPDATE_ERR") {
                        alert("답변 삭제중 오류가 발생했습니다.");
                    } else if(msg === "UPDATE_OK") {
                        alert("답변이 삭제되었습니다.");
                        location.href = "/board/inqry/list";
                    }
                },
                error: function(msg) {
                    alert("error")
                    if(msg === "UPDATE_ERR"){
                        alert("답변 삭제중 오류가 발생했습니다.")
                    }
                }
            })
        })
    })
</script>
</body>
</html>
