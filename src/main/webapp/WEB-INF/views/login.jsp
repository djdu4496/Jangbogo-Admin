<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="include/header.jsp"/>
    <link rel="stylesheet" href="/css/login.css"/>
</head>
<body class="bg-gradient-primary">
<div class="row justify-content-center">
    <div class="col-md-4">
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <div class="col-lg login-align">
                    <div class="p-5">
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
                        </div>
                        <form class="user" action="/login" method="post" id="login_form">
                            <div class="form-group">
                                <input
                                        type="email"
                                        name="email"
                                        class="form-control form-control-user"
                                        placeholder="Enter Email Address..."
                                />
                            </div>
                            <div class="form-group">
                                <input
                                        type="password"
                                        name="pwd"
                                        class="form-control form-control-user"
                                        id="exampleInputPassword"
                                        placeholder="Password"
                                />
                            </div>
                            <div class="form-group">
                                <div class="custom-control custom-checkbox small">
                                    <input
                                            type="checkbox"
                                            class="custom-control-input"
                                            id="customCheck"
                                    />
                                    <label class="custom-control-label" for="customCheck">
                                        Remember Me
                                    </label>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary btn-user btn-block" id="login">
                                Login
                            </button>
                            <hr/>
                        </form>
                        <div class="text-center">
                            <a class="small" href="/">Forgot Password?</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="include/script.jsp"/>
<script>
    let msg = "${msg}";
    if (msg == "ADMIN_NOT_FOUND") alert("정보가 일치하지 않습니다");
    if (msg == "EXCEPTION_ERR") alert("오류가 발생했습니다. 다시 시도해 주세요");

    $(document).ready(function () {
        let email = $("input[name=email]");
        let pwd = $("input[name=pwd]");

        $("#login").click(function (e) {
            e.preventDefault();

            if (email.val().trim() == "") {
                alert("이메일을 입력해 주세요");
                email.focus();
                return false;
            }

            if (pwd.val().trim() == "") {
                alert("비밀번호를 입력해 주세요");
                pwd.focus();
                return false;
            }
            $("#login_form").submit();
        });
    });
</script>
</body>
</html>