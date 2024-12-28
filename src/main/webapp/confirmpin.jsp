<%-- 
    Document   : newpin
    Created on : 12 Nov, 2022, 5:56:51 PM
    Author     : vivek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" href="index.css">
                <title>Confirm Pin</title
        
    </head>
    
    <body>
        <form action="confirmValidation" method="post" class="bd-form">
            <div>
               <p class="card-text header-text-randpass" name="password">Enter Pin</p>
               <input type="password"  pattern="[0-9]*"  inputmode="numeric"name ="pin" title="PLease Enter Numeric values" placeholder="Enter Your PIN" min="1000" max="9999" required> 
            <button type="submit" name="" >SUBMIT</button>
            </div>
        </form> 
    </body>
</html>
