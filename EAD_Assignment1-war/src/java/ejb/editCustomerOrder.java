/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sanji
 */
@WebServlet(name = "editCustomerOrder", urlPatterns = {"/editCustomerOrder"})
public class editCustomerOrder extends HttpServlet {
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
       String orderno=request.getParameter("orderNo");
        
        CustomerOrder co = customerOrderFacade.find(orderno);
        
        
        request.setAttribute("id", co.getId());
        request.setAttribute("cid", co.getCustomerid());
        request.setAttribute("amount", co.getAmount());
        request.setAttribute("duedate", co.getDuedate());
        request.setAttribute("comments", co.getComment());
        
        request.getRequestDispatcher("/WEB-INF/editCustomerOrder.jsp").forward(request, response);
      
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
      String id=request.getParameter("orderno");
        CustomerOrder co=customerOrderFacade.find(id);
       
       String customerid=request.getParameter("customerid");
       String amount=request.getParameter("amount");
       String duedate=request.getParameter("duedate");
        String comments=request.getParameter("comments");
       
      
       
       co.setId(id);
       
       co.setCustomerid(customerid);
       co.setAmount(Double.parseDouble(amount));
       co.setDuedate(duedate);
       co.setComment(comments);
       
        
        customerOrderFacade.edit(co);
        
        List orders=customerOrderFacade.findAll();
        request.setAttribute("orders", orders);
        
        request.getRequestDispatcher("/WEB-INF/viewCustomerOrder.jsp").forward(request, response);
    
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
