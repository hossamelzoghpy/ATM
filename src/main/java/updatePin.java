/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import database.db_holder;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author vivek
 */
public class updatePin extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updatePin</title>");      
            out.println("<script src='script.js'></script>");      
            out.println("<link rel=\"stylesheet\" href=\"index.css\">");
            out.println("</head>");
            out.println("<body>");
            
            //Declareation & Assignment 
            HttpSession session = request.getSession(false);
            long card = (long) session.getAttribute("card_no");
            int oldPin = Integer.parseInt(request.getParameter("oldPin"));
            int newPin = Integer.parseInt(request.getParameter("newPin"));
            int confirmNewPin = Integer.parseInt(request.getParameter("confirmNewPin"));
            db_holder db = new db_holder();
            int dbpin = db.getValue("pin", card);
            int pinMatch = 0;
            //Declareation & Assignment Ends
            
            //Logic
            if(confirmNewPin==newPin)
            {
                int updateStatus =   db.setValue("pin", newPin, card);
                pinMatch =1;
                if(pinMatch == 1 && updateStatus==1)
                {
                    out.println("<script>msg('pin changed')</script>");     
                    out.println("<script>redirect('operactions.jsp')</script>");     
                }
            }
            else
            {
                out.println("<script>alert('Check Your Pins and try again')</script>");
                out.println("<script>window.location = ('pin.jsp')</script>");
                
            }
            //Logic Ends
            out.println("</body>");
            out.println("</html>");
        }
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
