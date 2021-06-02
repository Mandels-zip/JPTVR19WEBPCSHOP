<%-- 
    Document   : addCustomerForm
    Created on : Jan 17, 2021, 8:29:28 PM
    Author     : ilja2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Добавить покупателя</title>
  </head>
  <body>
    <h1>Добавление нового покупателя</h1>
    <p>${info}</p>
    <br>
    <a href="index.jsp">Главная страница</a>
    <form action="createCustomer" method="POST">
      Имя <input type="text" name="firstname"><br>
      Фамилия <input type="text" name="lastname"><br>
      Номер <input type="text" name="phone"><br>
      Электронная почта <input type="text" name="email"><br>
      Деньги<input type="text" name="money"><br>
      <input type="submit" name="submit" value="Добавить">
    </form>
  </body>
</html>