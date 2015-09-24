/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import ejb.CustomerOrder;
import ejb.CustomerOrderFacade;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author sanji
 */
@Singleton
@LocalBean
@WebListener
public class customerController implements HttpSessionListener{
    @EJB
    private CustomerOrderFacade customerOrderFacade;

    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     public double addCustomerOrderAmount(String orderNo,double orderlineAmount) {
        
        CustomerOrder co=customerOrderFacade.find(orderNo);
        double amount = 0;
        amount=orderlineAmount+co.getAmount();
        return amount;
    }
    
     public double reduceCustomerOrderAmount(String orderNo,double orderlineAmount) {
        
        CustomerOrder co=customerOrderFacade.find(orderNo);
        double amount = 0;
        amount=co.getAmount()-orderlineAmount;
        return amount;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
