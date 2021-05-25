<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <h2>Список ПК</h2>
        <p>${info}</p>
        <form action="buyComputer" method="POST">
            
              <%-- <select name="comuterId" class="form-select" aria-label="Default select example">
           <option selected>Меню выбора</option>
           <c:forEach var="computer" items="${listComputers}" varStatus="status">
           <option value="${computer.id}">${status.index+1} ${computer.manufacturer} ${computer.model}, Цена: ${computer.price}, Количество: ${computer.quantity} </option>
            </c:forEach>
         </select>  
    --%>
        <select name="computerId">
            <c:forEach var="computer" items="${listComputers}" varStatus="status"> 
            <option value="${computer.id}"> ${status.index+1}. ${computer.manufacturer} ${computer.model} ${computer.procmodel} ${computer.videocard} ${computer.ram}  ${computer.soundboard}
                     ${computer.harddrive}  ${computer.ssd}  ${computer.power}  ${computer.price} ${computer.quantity}
            </option>
            </c:forEach>
        </select>
   
         <%-- <h2>Список покупателей</h2>
         <select name="customerId">
        <c:forEach var="customer" items="${listCustomers}" varStatus="status">
        <option value="${customer.id}"> ${status.index+1} ${customer.firstname} ${customer.lastname} ${customer.email} ${ustomer.phone} ${сustomer.money}
        </option>
    </c:forEach>
         </select>
         --%>
         <input class="btn btn-dark" type="submit" value="Купить ПК"></input>
        </form>
         
