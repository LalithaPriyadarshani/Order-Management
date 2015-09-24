/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import controller.customerController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sanji
 */
@WebServlet(name = "addOrderLine", urlPatterns = {"/addOrderLine"})
public class addOrderLine extends HttpServlet {
    @EJB
    private customerController customerController;
    @EJB
    private CustomerOrderLineFacade customerOrderLineFacade;
    @EJB
    private CustomerOrderFacade customerOrderFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String orderno=request.getParameter("orderno");
        
        CustomerOrder co = customerOrderFacade.find(orderno);
        
        
        request.setAttribute("id", co.getId());
        request.setAttribute("cid", co.getCustomerid());
        request.setAttribute("name", co.getName());
        request.setAttribute("amount", co.getAmount());
        request.setAttribute("duedate", co.getDuedate());
        request.setAttribute("comments", co.getComment());
       
            
        request.getRequestDispatcher("/WEB-INF/addOrderLine.jsp").forward(request, response);
     
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       CustomerOrderLine line=new CustomerOrderLine();
       
       String orderno=request.getParameter("orderno");
       String lineno=request.getParameter("lineno");
       String partno=request.getParameter("partno");
       String amount=request.getParameter("amount");
       
      
       line.setOrderno(orderno);
       line.setLineno(Integer.parseInt(lineno) );
       line.setPartno(partno);
       line.setAmount(Double.parseDouble(amount));
       
       customerOrderLineFacade.create(line);
       
       
       double orderAmount=customerController.addCustomerOrderAmount(orderno,Double.parseDouble(amount));
       
        CustomerOrder co= customerOrderFacade.find(orderno);
        co.setAmount(orderAmount);
        customerOrderFacade.edit(co);
       
//       request.setAttribute("orderNo", orderno);
//       RequestDispatcher rd=request.getRequestDispatcher("viewOrderLines");
//       rd.forward(request, response);
       response.sendRedirect("viewOrderLines?orderNo="+orderno);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
