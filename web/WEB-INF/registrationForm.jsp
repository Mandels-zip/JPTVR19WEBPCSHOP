<%-- 
    Document   : registrationform
    Created on : Feb 12, 2021, 1:33:04 PM
    Author     : pupil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <h1>Добавить читателя</h1>
    <p>${info}</p>
    <br>
    <a href="index.jsp">Главная страница</a>
    <form action="createUser" method="POST">
      Имя читателя <input type="text" name="firstname"><br>
      Фамилия читателя <input type="text" name="lastname"><br>
      Телефон <input type="text" name="phone"><br>
      Эмайл <input type="text" name="email"><br>
      Логин <input type="text" name="login"><br>
      Пароль <input type="text" name="password"><br>
      <input class="btn btn-dark" type="submit" name="submit" value="Добавить">
    </form>
    </body>
</html>
