<%-- 
    Document   : withdraw
    Created on : 9 Nov, 2022, 8:12:42 PM
    Author     : vivek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Operations Page</title>
        <link rel="stylesheet" href="index.css">
    </head>
    <body>
        <%
            if(session.getAttribute("card_no")==null)
                response.sendRedirect("index.jsp");
       %>
        <main>
            <form action="withdrawValidation" method="post" class="bd-form">
                <div>
                    <p class="card-text header-text-randpass">Enter Amount</p>
                    <input type="number" placeholder="Withdrawl Amount" name="withdraw_amount" required/>

                    <div class="row">
                    <button>Submit</button>    
                    <a href="operactions.jsp" class="btn-text">Main Menu</a>
                    </div>
                </div>
            </form>
        </main>
    </body>
</html>
