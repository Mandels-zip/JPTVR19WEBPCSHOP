<%-- 
    Document   : BuyComputer
    Created on : Jan 17, 2021, 9:37:26 PM
    Author     : ilja2
--%>

<%-- 
    Document   : BuyComputer
    Created on : Jan 17, 2021, 9:35:50 PM
    Author     : ilja2
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Покупка ПК</title>
    </head>
    
    <body>
        <p>${info}</p>
        <form action="buyComputer" method="POST">
        <h2>Список ПК</h2>
        <select name="computerId">
            <c:forEach var="computer" items="${listComputers}" varStatus="status"> 
            <option value="${computer.id}"> ${status.index+1}. ${computer.manufacturer} ${computer.model} ${computer.procmodel} ${computer.videocard} ${computer.ram}  ${computer.soundboard}
                     ${computer.harddrive}  ${computer.ssd}  ${computer.power}  ${computer.price}
            </option>
            </c:forEach>
        </select>
        
        <h2>Список покупателей</h2>
         <select name="customerId">
        <c:forEach var="customer" items="${listCustomers}" varStatus="status">
        <option value="${customer.id}"> ${status.index+1} ${customer.firstname} ${customer.lastname} ${customer.email} ${ustomer.phone} ${сustomer.money}
        </option>
    </c:forEach>
         </select>
    <input type="submit" value="Купить ПК">
        </form>
</body>
</html>