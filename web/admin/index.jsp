<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard | J.A.R.V.I.S</title>
    </head>
    <body>
        <h1>Hello, ${sessionScope.USER_INFO.madeUpName}</h1>
        <form action="MainController" method="POST">
            <input type="submit" name="action" value="Logout"/>
        </form>
    </body>
</html>
