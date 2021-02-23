<%-- 
    Document   : listComputers
    Created on : Jan 17, 2021, 9:15:50 PM
    Author     : ilja2
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список ПК</title>
    </head>
    <body>
        <h1>Список ПК</h1>
    </body>
    <ul>
        <c:forEach var="сomputer" items="${listComputers}"> 
            <li>${сomputer.manufacturer}. ${сomputer.model}. ${сomputer.procmodel}. ${сomputer.videocard}.${сomputer.ram}. ${сomputer.soundboard}. 
                ${сomputer.harddrive}. ${сomputer.ssd}. ${сomputer.power}. ${сomputer.price}. </li>
            </c:forEach>

    </ul>

</html>
