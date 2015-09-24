<%-- 
    Document   : addCustomerOrder
    Created on : Aug 19, 2015, 11:24:22 PM
    Author     : sanji
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Customer Order</title>
    </head>
    <body>
    <center>
       <form method="post" style="background-color: lightgrey;margin-top: 10px;height:600px;width: 1200px;border-style: double;border-color: black;text-align: center">
        <h2>Add New Customer Order</h2>
        <center>
        <table>
            <tr>
            <td>
                <label>Order No:</label></td>
            </tr>
        
            <tr>
                <td><input type="text" required="true" name="orderno"/> 
            </td>
            </tr>
            
            <tr>
            <td>
                <label>Customer Id:</label></td>
            </tr>
        
            <tr>
                <td>
                    <select name="customerid">
                    <c:forEach var="element" items="${customers}">
                        <option>${element.id}</option> 
                    </c:forEach>
                        </select>
            </td>
            </tr>
            
           
            <tr>
            <td>
                <label>Due Date:</label></td>
            </tr>
            <tr>
                <td><input type="date" width="200px" name="duedate" required="true"/> 
            </td>
            </tr>
             <td>
                <label>Comments:</label></td>
            </tr>
            <tr>
                <td><textarea required="true" name="comments"></textarea>
            </td>
            </tr>
            
           
        </table>
        </center>
        <br>
        <br>
        
        <button type="submit" >Add Customer Order</button>
        </form>
    </center>
    </body>
</html>
