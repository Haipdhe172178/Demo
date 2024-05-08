<%-- 
    Document   : list
    Created on : Apr 17, 2024, 3:37:57 PM
    Author     : Hai Pham
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${not empty sessionScope.account}">
            <p>Hello ${sessionScope.account.username}</p>
            <table border="1">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Gender</th>
                        <th>Dob</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="employee" items="${requestScope.listE}" >
                        <tr>
                            <td>${employee.id}</td>
                            <td>${employee.name}</td>
                            <td>${employee.gender ? 'male' : 'female'}</td>
                            <td>${employee.dob}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </body>
</html>
