<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error | J.A.R.V.I.S</title>
    </head>
    <body>
        <h1>Something went wrong</h1>
        <font color="red">
            ${requestScope.ERROR}
        </font>
        <br>
        <a href="index.jsp">Back to home page</a>
    </body>
</html>
