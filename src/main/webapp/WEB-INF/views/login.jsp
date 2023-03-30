<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<style>
    p {
        color: red;
    }
</style>
<body>
<h1>LOGIN 커스텀</h1>
<form action="/login_check" method="post">
<%--    <c:if test="${param.ng!=null}">--%>
<%--        <p> error : <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/> </p>--%>
<%--    </c:if>--%>
    <c:if test="${LoginFailMessage!=null}">
        <p> Error : <c:out value="${LoginFailMessage}"/> </p>
    </c:if>
    USER : <input type="text" name="user_id"><br>
    PASSWORD : <input type="password" name="user_pw"><br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Login">
</form>
</body>
</html>