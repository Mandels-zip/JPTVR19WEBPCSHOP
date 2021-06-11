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
        <table class="table table-striped">
    <thead>
    <tr>
      
      <th scope="col">Имя</th>
      <th scope="col">фамилия</th>
      <th scope="col">Э-майл</th>
      <th scope="col">Телефон</th>
      <th scope="col">Счет</th>
    </tr>
     <c:forEach var="сustomer" items="${listCustomers}" varStatus="status">
       <tbody>
    <tr>
      
      <td>${сustomer.firstname}</td>
      <td>${сustomer.lastname}</td>
      <td>${сustomer.email}</td>
      <td>${сustomer.phone}</td>
      <td>${сustomer.money}</td>
      
       </c:forEach>
    </tr>
  </thead>
</table>
    </body>
</html>
