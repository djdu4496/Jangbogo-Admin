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
                            <tr>
                                <td class="col-3 light-blue">생일</td>
                                <td class="id">${user.brdy}</td>
                            </tr>
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
                                <td class="id">
                                    <fmt:formatDate value="${user.pwd_upt_tm}" pattern="yyyy-MM-dd" type="date"/>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">최종 로그인일자</td>
                                <td class="id">
                                    <fmt:formatDate value="${user.last_login_tm}" pattern="yyyy-MM-dd" type="date"/>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">신고당한 횟수</td>
                                <td class="id">${user.decl_cnt}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">가입일자</td>
                                <td class="id">
                                    <fmt:formatDate value="${user.reg_tm}" pattern="yyyy-MM-dd" type="date"/>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">수정일자</td>
                                <td class="id">
                                    <fmt:formatDate value="${user.chg_tm}" pattern="yyyy-MM-dd" type="date"/>
                                </td>
                            </tr>
                        </table>
                        <div class="font-weight-bold text-primary py-4">배송지 리스트</div>
                        <table class="table table-bordered py-md-3" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th>번호(idx)</th>
                                <th>우편번호</th>
                                <th>기본주소</th>
                                <th>상세주소</th>
                                <th>수령자 이름</th>
                                <th>수령인 전화번호</th>
                                <th>기본배송지 여부</th>
                                <th>배송지 등록일자</th>
                                <th>배송지 수정일자</th>
                            </tr>
                            </thead>
                            <tbody>

                            <c:forEach var="addr" items="${addrList}">
                                <tr>
                                    <td>${addr.idx}</td>
                                    <td>${addr.zpcd}</td>
                                    <td class="id">${addr.addr_base}</td>
                                    <td class="id">${addr.addr_dtl}</td>
                                    <td class="id">${addr.rcpr_nm}</td>
                                    <td class="id">${addr.rcpr_mobl_no}</td>
                                    <td class="id">${addr.is_default_yn}</td>
                                    <td class="id">
                                        <fmt:formatDate value="${addr.reg_tm}" pattern="yyyy-MM-dd" type="date"/>
                                    </td>
                                    <td class="id">
                                        <fmt:formatDate value="${addr.chg_tm}" pattern="yyyy-MM-dd" type="date"/>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <c:if test="${empty addrList}">
                            <div class="pb-5 text-center">배송지 정보가 없습니다</div>
                        </c:if>
                        <div class="d-flex justify-content-center mt-5">
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
