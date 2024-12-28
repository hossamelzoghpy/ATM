<%-- 
    Document   : ministatement
    Created on : 13 Nov, 2022, 3:13:46 PM
    Author     : vivek
--%>

<%@page import="database.db_holder"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="index.css">
        <title>Mini Statement Page</title>
    </head>
    <body>
        <%
            if (session.getAttribute("card_no") == null) {
            response.sendRedirect("index.jsp");
            }
        %>
        <%
            
            long card = (Long)session.getAttribute("card_no");
            db_holder db = new db_holder();
            ResultSet rs = db.loadMiniStatement(card);
            int count = 0;
        %>
        <div>
            
        <table>
            <tr>
                <td>Transaction Type</td>
                <td>Amount</td>
                <td>Date</td>
            </tr>
             <% while(rs.next() && count<10){ %>
            <TR>
                <TD> <%= rs.getString(1) %></td>
                <TD> <%= rs.getString(2) %></TD>
                <TD> <%= rs.getString(3) %></TD>
            </TR>
            <%count++; } %>
            <tr>
                <td colspan="3"></td>
            </tr>
        </table>
        <a href="operactions.jsp" class="btn-text">Main Menu</a>

        </div>
    </body>
</html>
