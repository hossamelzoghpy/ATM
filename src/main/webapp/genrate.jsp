<%-- 
    Document   : genrate
    Created on : 12 Nov, 2022, 12:02:49 AM
    Author     : vivek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="index.css">
        <title>Generate Password </title>
    </head>
    <%--
        long card = Long.parseLong(request.getParameter("card"));
        out.print(card);
    --%>

    <body>
        <form action="genrateValidation" method="post" class="bd-form">
            <div class="col">    
                <div>
                   <p class="card-text header-text-randpass" name="password">Enter New Pin</p>
                   <input type="password"  pattern="[0-9]*"  inputmode="numeric" name="pin" placeholder="PIN" min="1000" max="9999"> 
                </div>
                
                <div>
                   <p class="card-text header-text-randpass" name="confrim_password">Confirm New Pin</p>
                   <input type="password"  pattern="[0-9]*"  inputmode="numeric" name="cpin" placeholder="PIN" min="1000" max="9999"> 
                </div>
                
                <button type="submit" name="" >SUBMIT</button>
            </div>
        </form> 
    </body>
</html>
