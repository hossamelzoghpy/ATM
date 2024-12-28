/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import database.db_holder;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author vivek
 */
public class registerValidation extends HttpServlet {

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
            
//            out.print("ok");
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.print("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.10.1/html2pdf.bundle.min.js\" integrity=\"sha512-GsLlZN/3F2ErC5ifS5QtgpiJtWd43JWSuIgh7mbzZ8zBps+dvLusV+eNQATqgA/HdeKFVgA5v3S/cIrLF7QnIg==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\"></script>");
            out.println("<link rel=\"stylesheet\" href=\"index.css\">");
            out.println("<script src='script.js'></script>");
            out.println("<title>Servlet registerValidation</title>");            
            out.println("</head>");
            //Added Class for Styleing
            out.println("<body class= 'register' >");
            
            //Declareation & Assignment 
            String name = request.getParameter("name");
            String mail = request.getParameter("mail");
            String pan = request.getParameter("pan");
            int age = Integer.parseInt(request.getParameter("age"));
            long phone =  Long.parseLong(request.getParameter("phone"));
            
            db_holder db = new db_holder();
            long card = db.card_no();
            out.print(card);
            long k = db.ins(name, mail, phone, age, pan, card);
            //Declareation & Assignment Ends
            
            //Logic
            if(k==1)
            {
                out.print("<main class='model align-left'>");
                    out.print("<h1>Your Details</h1>");
                    out.print("<p class='card-text text-sm'>Username : " +name+"</p>");
                    out.print("<p class='card-text text-sm'>Mail : " +mail+"</p>");
                    out.print("<p class='card-text text-sm'>Phone : " +phone+"</p>");
                    out.print("<p class='card-text text-sm'>Age : " +age+"</p>");
                    out.print("<p class='card-text text-sm'>Pan : " +pan+"</p>");
                    out.print("<p class='card-text text-sm'>Balance : " +5000+"</p>");
                    out.print("<p class='card-text text-sm header-text-randpass' >Your Card Number 👇</p>");
                    out.print("<h2>"+card+"</h2>");
                out.print("</main>");
                
                int getMail = db.getValue("mail", card);
                int getPan = db.getValue("pan", card);
                int getPhone = db.getValue("phone", card);
                
                if(getMail != 0 || getPan !=0 || getPhone !=0)
                {
                    if(getMail!=0)
                    {
                        out.println("<script>alert('Mail Already Exists')</script>"); 
                    }
                    if(getPan!=1)
                    {
                        out.println("<script>generatePDF('Pan Already Exists')</script>"); 
                    }
                    if(phone!=1)
                    {
                        out.println("<script>generatePDF('Phone Already Exists')</script>"); 
                    }
                    out.println("<script>redirect('register.jsp')</script>"); 

                }
                else{
                    out.println("<script>generatePDF()</script>"); 
                    out.println("<script>redirect('index')</script>"); 
                }
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
