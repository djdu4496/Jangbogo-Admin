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
                            회원 상세
                        </h5>
                    </div>
                    <div class="card-body py-5 px-5">
                        <table class="table table-bordered py-md-3" id="dataTable" width="100%" cellspacing="0">
                            <tr>
                                <td class="col-3 light-blue">번호(idx)</td>
                                <td>${user.idx}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">등급</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${user.rnk_idx == 1}">
                                            일반
                                        </c:when>
                                        <c:when test="${user.rnk_idx == 2}">
                                            단골
                                        </c:when>
                                        <c:when test="${user.rnk_idx == 3}">
                                            vip
                                        </c:when>
                                    </c:choose>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">이메일</td>
                                <td class="id">${user.email}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">닉네임</td>
                                <td class="id">${user.nick_nm}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">휴대전화번호</td>
                                <td class="id">${user.mpno}</td>
                            </tr>
                            <%-- 생일 값이 있을 때만--%>
                            <c:if test="${not empty user.brdy}">
                                <tr>
                                    <td class="col-3 light-blue">생일</td>
                                    <td class="id">${user.brdy}</td>
                                </tr>
                            </c:if>
                            <tr>
                                <td class="col-3 light-blue">마케팅수신동의여부</td>
                                <td class="id">${user.markt_agre_yn}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">로그인(가입) 유형</td>
                                <td class="id">
                                    <c:choose>
                                        <c:when test="${user.login_tp_cd == 1}">일반</c:when>
                                        <c:when test="${user.login_tp_cd == 2}">소셜(카카오)</c:when>
                                        <c:when test="${user.login_tp_cd == 3}">소셜(네이버)</c:when>
                                    </c:choose>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">소셜연동여부</td>
                                <td class="id">${user.social_yn}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">상태코드</td>
                                <td class="id">
                                    <c:choose>
                                        <c:when test="${user.state_cd == 1}">승인(정상)</c:when>
                                        <c:when test="${user.state_cd == 2}">신고</c:when>
                                        <c:when test="${user.state_cd == 3}">탈퇴</c:when>
                                        <c:when test="${user.state_cd == 4}">휴면</c:when>
                                        <c:when test="${user.state_cd == 99}">대기</c:when>
                                    </c:choose>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">비밀번호 변경일자</td>
                                <td class="id">${user.pwd_upt_tm}</td>
                            </tr>
                            <%-- 마지막 로그인날짜가 null이 아닐 때만--%>
                            <c:if test="${not empty user.chg_tm}">
                                <tr>
                                    <td class="col-3 light-blue">최종 로그인일자</td>
                                    <td class="id">${user.last_login_tm}</td>
                                </tr>
                            </c:if>
                            <tr>
                                <td class="col-3 light-blue">신고당한 횟수</td>
                                <td class="id">${user.decl_cnt}</td>
                            </tr>

                            <tr>
                                <td class="col-3 light-blue">가입일자</td>
                                <td class="id">${user.reg_tm}</td>
                            </tr>
                            <%-- 수정날짜가 Null이 아닐 때만 보인다 --%>
                            <c:if test="${not empty user.chg_tm}">
                                <tr>
                                    <td class="col-3 light-blue">수정일자</td>
                                    <td class="id">${user.chg_tm}</td>
                                </tr>
                            </c:if>
                        </table>
                        <div class="col-3 ml-auto">
<%--                            <button class="btn btn-primary px-md-4 py-md-2 mr-2 <c:if test='${seller.state_cd == 99}'>hidden</c:if>"--%>
<%--                                    id="approve_btn"--%>
<%--                            >--%>
<%--                                승인하기--%>
<%--                            </button>--%>
                            <button class="btn btn-danger px-md-4 py-md-2" id="report_btn">신고하기</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@ include file="/WEB-INF/views/include/footer.jsp" %>
    </div>
</div>
<%@ include file="/WEB-INF/views/include/script.jsp" %>
<script>
    $(document).ready(function () {
        $("#list_btn").click(function () {
            window.location.href = "/";  //경로 이전페이지로 가기
        });

        $("#report_btn").click(function (e) {
            e.preventDefault();

            if (confirm("해당 회원을 신고하시겠습니까?")) {

                //ajax로 회원신고하고 성공 시 유저리스트 페이지로 이동
            }

        })
    });
</script>
</body>
</html>
