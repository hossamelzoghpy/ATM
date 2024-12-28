/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import database.db_holder;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author vivek
 */
public class depositValidation extends HttpServlet {

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
            out.println("<link rel=\"stylesheet\" href=\"index.css\">");
            out.println("<title>Servlet depositValidation</title>");            
            out.println("</head>");
            out.println("<body>");
            
            HttpSession session = request.getSession(false);
            if (session != null) 
            {
                //Declareation & Assignment
                long card = (long) session.getAttribute("card_no");
                int depositAmount = Integer.parseInt(request.getParameter("deposit_amount"));
                db_holder db = new db_holder();
                int balance = db.getValue("balence", card);
                balance+=depositAmount;
                int checkDepoit = db.setValue("balence", balance, card);
                //Declareation & Assignment End
                
            //Logic
                if(checkDepoit == 1)
                {
                    int checkTans=db.trans_ins("credit",depositAmount, card);
                    out.print("<script>alert('Deposit Successful')</script>");
                    out.println("<script>window.location ='deposit.jsp'</script>");
                }
                else
                {
                    out.print("<script>window.alert('Deposit Failed')</script>");
                    out.println("<script>window.location ='deposit.jsp'</script>");
                }
            }
            else{
                response.sendRedirect("index.jsp");
            }
            //Logic End
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
