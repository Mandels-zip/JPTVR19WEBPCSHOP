<%-- 
    Document   : listCustomers
    Created on : Jan 17, 2021, 9:14:39 PM
    Author     : ilja2
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список покупателей</title>
    </head>
    <body>
        <h1>Список покупателей</h1>
    <ul>
        <c:forEach var="сustomer" items="${listCustomers}"> 
            <li>${сustomer.firstname}. ${сustomer.lastname}. ${сustomer.email}. ${сustomer.phone}. ${сustomer.money}</li>
            </c:forEach>

    </ul>
    </body>
</html>
