<%-- 
    Document   : editOrderLine
    Created on : Aug 20, 2015, 11:42:37 PM
    Author     : sanji
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Customer Order Line</title>
    </head>
    <body>
          <center>
      
  
        <form method="post" style="background-color: lightgrey;margin-top: 10px;height:600px;width: 700px;border-style: double;border-color: black;text-align: center">
  <h1>Update Order Line</h1>
            <center>
          <table>
             <tr>
            <td>
                <label>Order no:</label></td>
            </tr>
        
            <tr>
                <td><input type="text"  name="orderNo" value="${orderNo}"  readonly="true"/> 
                   
                </td>
            </tr>
            <tr>
            <td>
                <label>Line no:</label></td>
            </tr>
        
            <tr>
                <td><input type="text"  name="lineId" value="${lineId}" ]/> 
                    <input type="hidden" name="id" value="${lineNo}"/>
                </td>
            </tr>
            
            <tr>
            <td>
                <label>Part No:</label></td>
            </tr>
        
            <tr>
                <td><input type="text" width="200px" name="partNo"  value="${partNo}"/> 
            </td>
            </tr>
            
            <tr>
            <td>
                <label>Amount:</label></td>
            </tr>
        
            <tr>
                <td><input type="text"  name="amount" value="${amount}"/> 
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
