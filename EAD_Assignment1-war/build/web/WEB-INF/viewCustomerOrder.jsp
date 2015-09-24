<%-- 
    Document   : viewCustomerOrder
    Created on : Aug 19, 2015, 11:09:05 PM
    Author     : sanji
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Customer Orders</title>
    </head>
   <body>
   <center>
       <form style="background-color: lightgrey;margin-top: 10px;height:600px;width: 700px;border-style: double;border-color: black;text-align: center">
           <h1>View Customer Orders</h1>
           <center>
           <table border="1" style="background-color: blanchedalmond">
    
        <thead>
        <tr>
            <th></th>
            <th style="font: bolder">Order No</th>
            <th style="font: bolder">Customer Id</th>
            <th style="font: bolder">Customer Name</th>
            <th style="font: bolder">Amount</th>
            <th style="font: bolder">Due date </th>
            <th style="font: bolder">Comments </th>
            
        </tr>
        </thead>
        <tbody
            <c:forEach var="element" items="${orders}">
        
            <tr>
                <td>
                
                <a href="<c:url value="/editCustomerOrder">
                             <c:param name="orderNo" value="${element.id}"/>
                   </c:url>" >Update</a> </td>
                    
                <td> <a  href="<c:url value="/viewOrderLines">
                             <c:param name="orderNo" value="${element.id}"/>
                   </c:url>">${element.id}</a></td>
                <td>${element.customerid}</td>
                <td>${element.name}</td>
                <td>${element.amount}</td>
                <td>${element.duedate}</td>
                <td>${element.comment}</td>
                
        </tr> 
            </c:forEach>
        </tbody>
    
</table>
     
           </center> 
           <br>
           <br>
           <a href="addCustomerOrder" style="font-size: larger;color: brown">Add new customer order</a>
         </form>
   </center>
    </body>
</html>
