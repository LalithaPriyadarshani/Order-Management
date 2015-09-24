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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sanji
 */
@WebServlet(name = "editOrderLine", urlPatterns = {"/editOrderLine"})
public class editOrderLine extends HttpServlet {
    @EJB
    private CustomerOrderFacade customerOrderFacade;
    @EJB
    private customerController customerController;
    @EJB
    private CustomerOrderLineFacade customerOrderLineFacade;

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
         String orderLine=request.getParameter("Lineid");
        
        CustomerOrderLine ol = customerOrderLineFacade.find(orderLine);
        
        
        request.setAttribute("lineId", ol.getLineno());
        request.setAttribute("partNo", ol.getPartno());
        request.setAttribute("amount", ol.getAmount());
        request.setAttribute("lineNo", ol.getId());
        request.setAttribute("orderNo", ol.getOrderno());
        request.getRequestDispatcher("/WEB-INF/editOrderLine.jsp").forward(request, response);
      
        
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
      String id=request.getParameter("id");
      
      CustomerOrderLine ol = customerOrderLineFacade.find(id);
      
      double previousVal=ol.getAmount();
      String lineNo=request.getParameter("lineId");
      String partNo=request.getParameter("partNo");
      String amount=request.getParameter("amount");
      String orderNo=request.getParameter("orderNo");
      
      ol.setLineno(Integer.parseInt(lineNo));
      ol.setPartno(partNo);
      ol.setAmount(Double.parseDouble(amount));
      
      double diffrence=Double.parseDouble(amount)-previousVal;
      customerOrderLineFacade.edit(ol);
      
       double orderAmount=customerController.addCustomerOrderAmount(orderNo,diffrence);
       
        CustomerOrder co= customerOrderFacade.find(orderNo);
        co.setAmount(orderAmount);
        customerOrderFacade.edit(co);
        response.sendRedirect("viewOrderLines?orderNo="+orderNo);
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
