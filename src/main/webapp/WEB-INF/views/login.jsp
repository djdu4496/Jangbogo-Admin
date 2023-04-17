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
                        <form class="user" action="/login" method="post">
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
                            <%--                            <a--%>
                            <%--                                    href="index.html"--%>
                            <%--                                    class="btn btn-primary btn-user btn-block"--%>
                            <%--                            >--%>
                            <%--                                Login--%>
                            <%--                            </a>--%>
                            <button type="submit" class="btn btn-primary btn-user btn-block">
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
</body>
</html>