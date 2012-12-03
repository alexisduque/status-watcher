/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp.presentation;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.*;
import javax.annotation.Resource;

import chatapp.components.Statuses;
/**
 *
 * @author alexis
 */

@WebServlet(urlPatterns = "/status")

public class StatusServlet extends HttpServlet {
    
  
    @EJB Statuses statuses;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("statusMap", statuses.statusMap);
        request.getServletContext().getRequestDispatcher("/WEB-INF/views/status.jsp").forward(request, response);

    }
    
    
}
