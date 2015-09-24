<%-- 
    Document   : editCustomer
    Created on : Aug 19, 2015, 10:15:34 PM
    Author     : sanji
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Customer</title>
    </head>
    <body>
    <center>
       <form method="post" style="background-color: lightgrey;margin-top: 10px;height:600px;width: 700px;border-style: double;border-color: black;text-align: center">
        <h2>Update Customer</h2>
        <center>
        <table>
             
            <tr>
            <td>
                <label>Customer Id:</label></td>
            </tr>
        
            <tr>
                <td><input type="text" required="true" name="customerid" value="${id}" readonly="true"/> 
                    <input type="hidden" name="id" value="${id}"/>
                </td>
            </tr>
            
            <tr>
            <td>
                <label>Name:</label></td>
            </tr>
        
            <tr>
                <td><input type="text" width="200px" name="name" required="true" value="${name}"/> 
            </td>
            </tr>
            
            <tr>
            <td>
                <label>Address:</label></td>
            </tr>
        
            <tr>
                <td><textarea name="address">${address}</textarea>          </td>
            </tr>
            <tr>
            <td>
                <label>Contact No:</label></td>
            </tr>
            <tr>
                <td><input type="text" width="200px" name="contactNo" required="true" value="${contact}"/> 
            </td>
            </tr>
            
             
        </table>
        </center>
        <br>
        <br>
        
        <button type="submit" >Update Customer</button>
        </form>
    </center>
    </body>
</html>
