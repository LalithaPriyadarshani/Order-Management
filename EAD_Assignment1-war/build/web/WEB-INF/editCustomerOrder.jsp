<%-- 
    Document   : editCustomerOrder
    Created on : Aug 20, 2015, 1:13:16 AM
    Author     : sanji
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update customer order</title>
    </head>
    <body>
    <center>
       <form method="post" method="post" style="background-color: lightgrey;margin-top: 10px;height:600px;width: 900px;border-style: double;border-color: black;text-align: center">
        <h2>Update Customer Order</h2>
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
                <td><input type="text" width="200px" name="duedate" required="true" value="${duedate}"/> 
            </td>
            </tr>
             <tr>
            <td>
                <label>Comments:</label></td>
            </tr>
            <tr>
                <td><textarea name="comments" required="true">${comments} </textarea>
            </td>
            </tr>
             
        </table>
        </center>
        <br>
        <br>
        
        <button type="submit" >Update Customer Order</button>
        </form>
    </center>
    </body>
</html>
