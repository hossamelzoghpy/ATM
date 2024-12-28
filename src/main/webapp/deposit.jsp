<%-- 
    Document   : deposit
    Created on : 9 Nov, 2022, 8:18:27 PM
    Author     : vivek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Operations-Deposit</title>
        <link rel="stylesheet" href="index.css">
    </head>
    
    <body>
         <%
            if (session.getAttribute("card_no") == null) {
            response.sendRedirect("index.jsp");
            }
        %>
        <main>
            <form action="depositValidation" class="bd-form">
                <div>   
                    <p class="card-text header-text-randpass">Enter Amount</p>
                    <input type="number" placeholder="Deposit Amount" name="deposit_amount" required/>
                    <div class="row">
                        <button>Submit</button>    
                        <a href="operactions.jsp" class="btn-text">Main Menu</a>
                    </div>
                 </div>
            </form>
        </main>
    </body>
</html>
