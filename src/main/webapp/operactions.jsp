<%-- 
    Document   : operactions
    Created on : 9 Nov, 2022, 7:17:27 PM
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
            <div action="" method="post" class="model">
                <button class="btn btn-withdraw"><a href="withdraw.jsp">Withdraw</a></button>
                <button class="btn btn-deposit"><a href="deposit.jsp">Deposit</a></button>
                <button class="btn btn-balance"><a href="balance.jsp">Balance Inquiry</a></button>
                <button class="btn btn-mininstatement"><a href="ministatement.jsp">Mini Statement</a></button>
                <button class="btn btn-pin"><a href="pin.jsp">Pin Change</a></button>
            </div>
        </main>
    </body>
</html>
