<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>This is J.A.R.V.I.S</title>
    </head>
    <body>
        <h1>Hello, this is J.A.R.V.I.S!</h1>
        <form action="MainController" method="POST">
            <input type="text" name="txtLoginName" placeholder="Login name"/>
            <font color="red">${requestScope.VALIDATE_ERROR.loginName}</font><br>
            <input type="password" name="txtPassword" placeholder="Password"/>
            <font color="red">${requestScope.VALIDATE_ERROR.password}</font><br>
            <c:if test="${requestScope.RESULT_ERROR != null}">
                <font color="red">${requestScope.RESULT_ERROR}</font><br>
            </c:if>
            <input type="submit" name="action" value="Login"/>
        </form>
    </body>
</html>
