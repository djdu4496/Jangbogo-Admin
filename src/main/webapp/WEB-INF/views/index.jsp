<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="/WEB-INF/views/include/header.jsp" %>
</head>
<body id="page-top">
<!-- Page Wrapper -->
<div id="wrapper">
    <!-- Sidebar -->
    <%@ include file="/WEB-INF/views/include/navBar.jsp" %>
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
        <!-- Main Content -->
        <div id="content">
            <%@ include file="/WEB-INF/views/include/topbar.jsp" %>
            <div class="h-auto w-auto bg-white p-lg-5">
                <div class="row">
                    <div class="col p-5">
                        <h4>오늘 처리할 일</h4>
                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">상태</th>
                                <th scope="col">건수</th>
                                <th scope="col">금액</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th scope="row">결제완료</th>
                                <td>31건</td>
                                <td>1,150,000원</td>
                            </tr>
                            <tr>
                                <th scope="row">배송준비중</th>
                                <td>7건</td>
                                <td>495,000원</td>
                            </tr>
                            <tr>
                                <th scope="row">환불요청</th>
                                <td>3건</td>
                                <td>70,000원</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="col p-5">
                        <h4>오늘 처리한 일</h4>
                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">상태</th>
                                <th scope="col">건수</th>
                                <th scope="col">금액</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th scope="row">배송준비중처리</th>
                                <td>8건</td>
                                <td>517,000원</td>
                            </tr>
                            <tr>
                                <th scope="row">배송중처리</th>
                                <td>1건</td>
                                <td>22,000원</td>
                            </tr>
                            <tr>
                                <th scope="row">환불완료</th>
                                <td>1건</td>
                                <td>24,000원</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="w-100"></div>
                    <div class="col p-5">
                        <h4>오늘 총 주문 금액</h4>
                        <input type="text" class="form-control-lg pr-1 pl-3 pt-1 pb-1 mt-4" id="floatingInputGrid" value="1,667,000원(39건)" readonly>
                        <h4 class="mt-5">재고현황</h4>
                        <table class="table mt-4">
                            <thead>
                            <tr>
                                <th scope="col">재고부족</th>
                                <th scope="col">재고부족 옵션</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>7건</td>
                                <td>0건</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="col p-5">
                        <h4>주문현황</h4>
                        <div>
                            <canvas id="myChart"></canvas>
                        </div>
                    </div>
                </div>
            </div>
            <!--오늘 처리할 일-->
            <!--오늘 처리한 일-->
            <!--재고현황-->
            <!--주문현황-->
            <!-- Footer -->
        </div>

        <!-- End of Main Content -->
        <!-- Footer -->
        <%@ include file="/WEB-INF/views/include/footer.jsp" %>
    </div>
    <!-- End of Content Wrapper -->
</div>
<!-- End of Page Wrapper -->
<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>
<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="login.html">Logout</a>
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/views/include/script.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
    let msg = "${msg}";
    if (msg == "EXCEPTION_ERR") alert("오류가 발생했습니다. 다시 시도해 주세요");

    const ctx = document.getElementById('myChart');

    new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['1월', '2월', '3월', '4월', '5월', '6월'],
            datasets: [{
                label: '주문 건수',
                data: [1240, 1510, 1820, 1700, 550, 0],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(255, 159, 64, 0.2)',
                    'rgba(255, 205, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(153, 102, 255, 0.2)',
                    'rgba(201, 203, 207, 0.2)'
                ],
                borderColor: [
                    'rgb(255, 99, 132)',
                    'rgb(255, 159, 64)',
                    'rgb(255, 205, 86)',
                    'rgb(75, 192, 192)',
                    'rgb(54, 162, 235)',
                    'rgb(153, 102, 255)',
                    'rgb(201, 203, 207)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
</script>
</body>

</html>

