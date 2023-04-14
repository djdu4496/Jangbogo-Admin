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
</head>
<body id="page-top">
<div id="wrapper">
    <%@ include file="/WEB-INF/views/include/navBar.jsp" %>
    <div id="content-wrapper" class="d-flex flex-column">
        <!-- Main Content -->
        <div id="content">
            <%@ include file="/WEB-INF/views/include/topbar.jsp" %>

            <div class="container-md">
                <div class="card shadow mb-4">
                    <div class="card-header py-md-4">
                        <h5 class="m-0 font-weight-bold text-primary">
                            판매자 상세
                        </h5>
                    </div>
                    <div class="card-body py-5 px-5">
                        <table class="table table-bordered py-md-3" id="dataTable" width="100%" cellspacing="0">
                            <tr>
                                <td class="col-3 light-blue">번호(idx)</td>
                                <td>${seller.idx}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">이메일</td>
                                <td class="id">${seller.email}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">브랜드 이름</td>
                                <td class="id">${seller.cpnm}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">브랜드 대표이름</td>
                                <td class="id">${seller.cpnm}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">휴대전화</td>
                                <td class="id">${seller.mpno}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">브랜드 대표연락처</td>
                                <td class="id">${seller.repr_telno}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">사업 유형</td>
                                <td class="id">${seller.biz_type}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">사업자 번호</td>
                                <td class="id">${seller.sle_biz_no}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">통신판매업 신고번호</td>
                                <td class="id">${seller.sle_biz_no}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">사업장 우편번호</td>
                                <td class="id">${seller.bsplc_zpcd}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">사업장 기본주소</td>
                                <td class="id">${seller.bsplc_base}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">사업장 상세주소</td>
                                <td class="id">${seller.bsplc_dtl}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">브랜드 내용</td>
                                <td class="id">${seller.brnd_cn}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">브랜드 배너</td>
                                <td class="id">
                                    <img src="display?fileName=${seller.brnd_bnr_upload_path}">
                                </td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">브랜드 프로필</td>
                                <td class="id">
                                    <img src="display?fileName=${seller.brnd_upload_path}">
                                </td>
                                ${pageContext.request.requestURI}
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">팔로워수</td>
                                <td class="id">${seller.subs_cnt}</td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">상태코드</td>
                                <td class="id">
                                    <c:choose>
                                        <c:when test="${seller.state_cd == 1}">승인(정상)</c:when>
                                        <c:when test="${seller.state_cd == 2}">신고</c:when>
                                        <c:when test="${seller.state_cd == 3}">탈퇴</c:when>
                                        <c:when test="${seller.state_cd == 4}">휴면</c:when>
                                        <c:when test="${seller.state_cd == 99}">대기</c:when>
                                    </c:choose>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-3 light-blue">비밀번호 변경일자</td>
                                <td class="id">${seller.pwd_upt_tm}</td>
                            </tr>
                            <c:if test="${not empty seller.last_login_tm}">
                                <tr>
                                    <td class="col-3 light-blue">최종 로그인일시</td>
                                    <td class="id">${seller.last_login_tm}</td>
                                </tr>
                            </c:if>
                            <tr>
                                <td class="col-3 light-blue">등록일자</td>
                                <td class="id">${seller.reg_tm}</td>
                            </tr>
                            <c:if test="${seller.state_cd == 1}">
                                <tr>
                                    <td class="col-3 light-blue">승인일자</td>
                                    <td class="id">${seller.aprv_tm}</td>
                                </tr>
                            </c:if>
                            <c:if test="${not empty seller.chg_tm}">
                                <tr>
                                    <td class="col-3 light-blue">수정일자</td>
                                    <td class="id">${seller.chg_tm}</td>
                                </tr>
                            </c:if>
                        </table>
                        <div class="col-3 ml-auto">
                            <c:if test="${seller.state_cd == 99}">
                                <button class="btn btn-primary px-md-4 py-md-2 mr-2">승인하기</button>
                            </c:if>
                            <button class="btn btn-danger px-md-4 py-md-2">신고하기</button>
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
    $().click(function () {

    });

    $().click(function () {

    })

</script>
</body>
</html>
