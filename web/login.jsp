<%-- 
    Document   : login
    Created on : Apr 17, 2024, 3:37:28 PM
    Author     : Hai Pham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3 style="color: red">${requestScope.ms}</h3>
        <form action="login" method="post">
            <label for="username">Username</label>
            <input type="text" name="username"></br>
            <label for="password">Password</label>
            <input type="password" name="pass"></br>
            <input type="submit" value="Login" />
        </form>
    </body>
</html>
