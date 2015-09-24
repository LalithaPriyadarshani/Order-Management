<%-- 
    Document   : addOrderLine
    Created on : Aug 20, 2015, 9:51:37 PM
    Author     : sanji
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Customer Order lines</title>
    </head>
    <body>
<center>
        <div style="background-color: lightgrey;margin-top: 10px;height:600px;width: 700px;border-style: double;border-color: black;text-align: center">
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
        <hr>
        <form method="post">
        <table>
            <tr>
            <td>
                <label>Line No:</label></td>
            </tr>
        
            <tr>
                <td><input type="text" required="true" name="lineno"/> 
            </td>
            </tr>
            
            <tr>
            <td>
                <label>Part No:</label></td>
            </tr>
        
            <tr>
                <td><input type="text" width="200px" name="partno" required="true"/> 
            </td>
            </tr>
             <tr>
            <td>
                <label>Amount:</label></td>
            </tr>
        
            <tr>
                <td><input type="text" width="200px" name="amount" required="true"/> 
            </td>
            </tr>
        </table>
          <button type="submit" >Add customer order line</button>   
        </form>
    </center>
        </div>
</center>
    </body>
</html>
