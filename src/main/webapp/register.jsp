<%-- 
    Document   : register
    Created on : 10 Nov, 2022, 9:55:47 AM
    Author     : vivek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <link rel="stylesheet" href="index.css">
    </head>
    <body>
        <main class="register"> 
            <form action="registerValidation" method="post" class="bd-form" id="register-form">
                <div>
                    <div>
                        <p class="card-text header-text-randpass text-sm">Enter Name</p>
                        <input type="text" placeholder="Name"  name="name" required> 
                    </div>
                    
                    <div>
                        <p class="card-text header-text-randpass text-sm">Enter Mail</p>
                        <input type="email" placeholder="Mail" name="mail" required>
                    </div>
                    
                    <div>
                        <p class="card-text header-text-randpass text-sm">Enter Phone</p>
                        <input type="number" placeholder="Phone" name="phone"  pattern="^[0-9]{10}$" required>
                    </div>
                    
                    <div>
                        <p class="card-text header-text-randpass text-sm">Enter Age</p>
                        <input type="number" placeholder="Age" name="age" min="18" max="100" required>
                    </div>
                    
                    <div>
                        <p class="card-text header-text-randpass text-sm">Enter PAN</p>
                        <input type="text" placeholder="PAN" name="pan"  maxlength="10" required>
                    </div>
                    
                    <button type="submit" name="" >SUBMIT</button>
                </div>
            </form> 
        </main>
    </body>
</html>
