<%--
  Created by IntelliJ IDEA.
  User: jiwoo
  Date: 2023/05/02
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>관리자 | 운송장번호 입력</title>
        <%@ include file="/WEB-INF/views/include/header.jsp" %>
        <style>
            .input-label label {
                line-height: 1.7;
            }
            .input-line {
                display: flex;
            }
            .input-box {
                margin-left: 50px;
            }
            .input > input {
                width: 500px;
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
                                    운송장번호 입력 - 주문번호 : <span id="orderIdx">${idx}</span>
                                </h5>
                            </div>
                            <div class="card-body py-5 px-5">
                                <div class="input-line">
                                    <div class="input-label">
                                        <label for="waybill">운송장번호<span>*</span></label>
                                    </div>
                                    <div class="input-box">
                                        <div class="input">
                                            <input
                                                name="waybill"
                                                id="waybill"
                                                type="text"
                                                placeholder="운송장번호를 입력해주세요"
                                            />
                                        </div>
                                        <div class="error-msg nick"></div>
                                    </div>
                                </div>
                                <div class="d-flex justify-content-center mt-5">
                                    <button class="btn btn-danger px-md-4 py-md-2 mr-2" id="waybillSave_btn">저장</button>
                                    <button class="btn btn-light px-md-4 py-md-2 mr-2"
                                            id="list_btn">
                                        목록으로
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
                let order_idx = "${idx}";
                let redirect_url = "<c:url value='/order/list/deliveryPreparing'/>"
                $("#waybillSave_btn").click((e) => {
                    // 1. 입력한 '운송장번호' '배송'테이블 데이터에 update
                    // 2. 목록으로 이동
                    let waybill_number = $("input[name=waybill]").val();                                                // 변수명 : waybill_number - 저장값 : input에 입력한 '운송장번호' 값
                    $.ajax({
                        type:'PATCH',                                                                                   // 요청 메서드
                        url:'/order/deliveryForm/' + waybill_number + "/" + order_idx,                                  // 요청 URI, 주문번호(order_idx), 운송장번호(waybill_number)를 파라미터에 담아 요청
                        success : (result) => {                                                                         // 서버로부터 성공 응답이 도착하면 호출될 함수
                            location.href = redirect_url;
                        },

                        error : () => {                                                                                 // 서버로부터 실패 응답이 도착하면 호출될 함수
                            alert("error");
                        }
                    })
                });

                $("#list_btn").click(function (e) {
                    location.href = redirect_url;
                });

            });
        </script>
    </body>
</html>
