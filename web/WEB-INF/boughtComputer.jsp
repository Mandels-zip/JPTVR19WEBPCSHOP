<%-- 
    Document   : BoughtComputer
    Created on : Jan 17, 2021, 9:40:50 PM
    Author     : ilja2
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список проданных ПК</title>
    </head>
    <body>
        <h1>Список проданных ПК</h1>
        <ul>
        <c:forEach var="history" items="${listHistories}"> 
            <li>${history.computer.manufacturer}. ${history.computer.model}. ${history.computer.procmodel}. ${history.computer.videocard}.${history.computer.ram}.
                ${history.computer.soundboard}. ${history.computer.harddrive}. ${history.computer.ssd}. ${history.computer.power}. ${history.computer.price}.</li>
            </c:forEach>
             
    </ul>
    </body>
</html>