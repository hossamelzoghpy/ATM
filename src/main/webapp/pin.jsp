<%-- 
    Document   : pin
    Created on : 9 Nov, 2022, 8:22:27 PM
    Author     : vivek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Pin</title>
        <link rel="stylesheet" href="index.css">
    </head>
            <%
                   if(session.getAttribute("card_no")==null)
                   response.sendRedirect("index.jsp");
           %>
    <body>
        <main>
            <form action="updatePin" method="post" class="bd-form" id="pin">
                <div class="col">   
                    <div class>
                        <p class="card-text header-text-randpass text-md">Enter Old Pin</p>
                        <input type="password"  pattern="[0-9]*"  inputmode="numeric" placeholder="Enter Old Pin" name="oldPin"required/>
                    </div>

                    <div>
                        <p class="card-text header-text-randpass text-md">Enter New Pin</p>
                        <input type="password"  pattern="[0-9]*"  inputmode="numeric" placeholder="New Pin" name="newPin" required/>
                    </div>

                    <div>
                        <p class="card-text header-text-randpass text-md">Confirm New Pin</p>
                        <input type="password"  pattern="[0-9]*"  inputmode="numeric" placeholder="New Pin" name="confirmNewPin" required/>
                    </div>

                    <div class="row">
                        <button>Submit</button>    
                        <a href="operactions.jsp" class="btn-text">Main Menu</a>
                    </div>
                </div>
            </form>
        </main>
    </body>
</html>
