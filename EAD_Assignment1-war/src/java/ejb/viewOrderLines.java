/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
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
@WebServlet(name = "viewOrderLines", urlPatterns = {"/viewOrderLines"})
public class viewOrderLines extends HttpServlet {
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
        String orderno=request.getParameter("orderNo");
        
        CustomerOrder co = customerOrderFacade.find(orderno);
        
        
        request.setAttribute("id", co.getId());
        request.setAttribute("cid", co.getCustomerid());
        request.setAttribute("name", co.getName());
        request.setAttribute("amount", co.getAmount());
        request.setAttribute("duedate", co.getDuedate());
        request.setAttribute("comments", co.getComment());
        
        String id=co.getId();
        List<CustomerOrderLine> orderLine=customerOrderLineFacade.findAll();
        
        List<CustomerOrderLine> selectedOrderLines=new ArrayList<CustomerOrderLine>();
        for (Iterator it = orderLine.iterator(); it.hasNext();) {
                 CustomerOrderLine elem = (CustomerOrderLine) it.next();
                 if(id.equals(elem.getOrderno())){
                      selectedOrderLines.add(elem);  
                 }
                 
                }
        
        request.setAttribute("orderLines", selectedOrderLines);
       
        
        request.getRequestDispatcher("/WEB-INF/viewOrderLines.jsp").forward(request, response);
      
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
        processRequest(request, response);
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
