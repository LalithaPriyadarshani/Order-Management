<%-- 
    Document   : viewOrderLines
    Created on : Aug 20, 2015, 9:01:44 PM
    Author     : sanji
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View customer order lines</title>
    </head>
    <body>
    <center>
       <form method="post" style="background-color: lightgrey;margin-top: 10px;height:600px;width: 900px;border-style: double;border-color: black;text-align: center">
     
           <center>
        <table>
             
            <tr>
            <td>
                <label>Order No:</label></td>
            </tr>
        
            <tr>
                <td><input type="text" required="true" name="orderno" value="${id}" readonly="true"/> 
                    <input type="hidden" name="id" value="${id}"/>
                </td>
            </tr>
            
            <tr>
            <td>
                <label>Customer Id:</label></td>
            </tr>
        
            <tr>
                <td><input type="text" width="200px" name="customerid" required="true" value="${cid}" readonly="true"/> 
            </td>
            </tr>
            
            <tr>
            <td>
                <label>Customer Name:</label></td>
            </tr>
        
            <tr>
                <td><input type="text" width="200px" name="customerid" required="true" value="${name}" readonly="true"/> 
            </td>
            </tr>
            
            <tr>
            <td>
                <label>Amount:</label></td>
            </tr>
        
            <tr>
                <td><input type="text"  name="amount" required="true" value="${amount}" readonly="true"/> 
            </td>
            </tr>
            <tr>
            <td>
                <label>Due Date:</label></td>
            </tr>
            <tr>
                <td><input type="text" width="200px" name="duedate" required="true" value="${duedate}" readonly="true"/> 
            </td>
            </tr>
             <tr>
            <td>
                <label>Comments:</label></td>
            </tr>
            <tr>
                <td><textarea name="comments" required="true" readonly="true">${comments} </textarea>
            </td>
            </tr>
             
        </table>
            
        <br>
        <br>
        <hr>
        
     <table border="1" style="background-color: blanchedalmond">
    
        <thead>
        <tr>
            <th>
                
            </th>
            <th></th>
            <th style="font: bolder">Line No</th>
            <th style="font: bolder">Part No</th>
            <th style="font: bolder">Amount</th>
           
        </tr>
        </thead>
        <tbody
        <c:forEach var="element" items="${orderLines}">
        <tr>
            <td> 
                
                <a href="<c:url value="/editOrderLine">
                             <c:param name="Lineid" value="${element.id}"/>
                   </c:url>" >Update</a> </td> 
                
                
           
                
           
                
            <td>  
                 <a href="<c:url value="/removeOrderLine">
                             <c:param name="Lineid" value="${element.id}"/>
                             <c:param name="orderno" value="${id}"/>
                              <c:param name="amount" value="${element.amount}"/>
                          </c:url>" onclick="return confirm('Are you sure you want to delete this?')" >Remove</a> 
            </td>
            <td>${element.lineno}</td> 
            <td>${element.partno}</td> 
            <td>${element.amount}</td>
           
                
        </tr> 
        </c:forEach>
        </tbody>
    
</table>
           </center>
              <a  href="<c:url value="/addOrderLine">
                             <c:param name="orderno" value="${id}"/>
                          </c:url>">Add new customer order line</a>
        </form>
    </center>
    </body>
</html>
