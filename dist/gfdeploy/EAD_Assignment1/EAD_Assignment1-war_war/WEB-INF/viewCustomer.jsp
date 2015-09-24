<%-- 
    Document   : viewCustomer
    Created on : Aug 19, 2015, 8:40:50 PM
    Author     : sanji
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Customer</title>
    </head>
    <body>
    <center>
         <form style="background-color: lightgrey;margin-top: 10px;height:600px;width: 700px;border-style: double;border-color: black;text-align: center">
             <center>
                 <h1>View Customer Details</h1>
       <table border="1" style="background-color: blanchedalmond">
    
        <thead>
        <tr>
            <th style="font: bolder">Customer Id</th>
            <th style="font: bolder">Name</th>
            <th style="font: bolder">Address</th>
            <th style="font: bolder">Contact No </th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody
        <c:forEach var="element" items="${customers}">
        <tr>
            <td>${element.id}</td> 
            <td>${element.name}</td> 
            <td>${element.address}</td>
            <td>${element.contactno}</td>
            <td>
                
                <a href="<c:url value="/editCustomer">
                             <c:param name="customerid" value="${element.id}"/>
                   </c:url>" >Update</a> </td>
                
                
            <td>  
                       <a href="<c:url value="/removeCustomer">
                             <c:param name="customerid" value="${element.id}"/>
                          </c:url>" onclick="return confirm('Are you sure you want to delete this?')">Remove</a> 
            </td>
                
        </tr> 
        </c:forEach>
        </tbody>
    
</table>
             </center>
         <input type="hidden" name="source "value="customerData" />
         <br>
         <br>
         <a href="addCustomer" style="font-size: larger;color: brown">Add new customer</a>
         </form>
    </center>
        
    </body>
</html>
