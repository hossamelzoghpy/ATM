<%-- 
    Document   : balance
    Created on : 13 Nov, 2022, 3:12:51 PM
    Author     : vivek
--%>

<%@page import="database.db_holder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" href="index.css">
                <title>Balance Page</title>
    </head>
    <body>  
        <form action="depositValidation" class="bd-form">
            <div>
                <h1 class="card-text">Your Balance</h1>
                <h2>
                    <%
                    out.print("₹ ");
                    if (session.getAttribute("card_no") != null) {
                        long card = (Long)session.getAttribute("card_no");
                        db_holder db = new db_holder();
                        int balance = db.getValue("balence", card);
                        out.print(balance);
                    }
                    else
                    {
                         response.sendRedirect("index.jsp");
                    }
                    %>
                </h2>
                <a href="operactions.jsp" class="btn-text">Main Menu</a>
            </div>
                </form>
    </body>
</html>
