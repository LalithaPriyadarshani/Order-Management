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
@WebServlet(name = "editCustomer", urlPatterns = {"/editCustomer"})
public class editCustomer extends HttpServlet {
    @EJB
    private CustomerEntityFacade customerEntityFacade;

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
       String customerid=request.getParameter("customerid");
        
        CustomerEntity c = customerEntityFacade.find(customerid);
        
        
        request.setAttribute("id", c.getId());
        request.setAttribute("name", c.getName());
        request.setAttribute("address", c.getAddress());
        request.setAttribute("contact", c.getContactno());
        
        request.getRequestDispatcher("/WEB-INF/editCustomer.jsp").forward(request, response);
      
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
        CustomerEntity c=customerEntityFacade.find(id);
       
       String name=request.getParameter("name");
       String address=request.getParameter("address");
       String contactNo=request.getParameter("contactNo");
       
       int contact=Integer.parseInt(contactNo);
       
       c.setId(id);
       
       c.setName(name);
       c.setAddress(address);
       c.setContactno(contactNo);
       
        
        customerEntityFacade.edit(c);
        
        List customers=customerEntityFacade.findAll();
        request.setAttribute("customers", customers);
        
        request.getRequestDispatcher("/WEB-INF/viewCustomer.jsp").forward(request, response);
        
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
