<%-- 
    Document   : newjsp
    Created on : 9 Nov, 2022, 6:56:05 PM
    Author     : vivek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ATM PAGE</title>
        <link rel="stylesheet" href="index.css">
        <script src="script.js"></script>
    </head>
    <body>
        <main>  
            <form action="indexValidation" method="post" class="bd-form">
                <div>
                    <div>
                        <p class="card-text">Enter</p>
                        <p class="card-text header-text-randpass ">Card Number</p>
                    </div>

                    <input type="number" maxlength="16" placeholder="Card Number" name="card_number"> 
                    <button type="submit" name="" >SUBMIT</button>
                </div>
            </form> 
        </main>
        <a href="register.jsp" class="link-page">Don't have card! Get new one </a>
    </body>
</html>
