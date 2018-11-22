<%-- 
    Document   : register
    Created on : Aug 15, 2018, 7:23:28 PM
    Author     : Dejan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
         <link href="css/style.css" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <!-- forma koja se obraca Register Servletu-->
        
        <div id="regg">
        <h1>Register!</h1>
        <form name="forma" action="RegisterServlet" method="POST">
           &nbsp;&nbsp; Enter your name: <input type="text" name="name" value="" />&nbsp;
           &nbsp; Enter Password: <input type="password" name="password" value="" />&nbsp;
           &nbsp; Confirm Password: <input type="password" name="password2" value="" />
            &nbsp;<input type="submit" value="Register" />
            </form>
            
            </div>
        <br><br>
            &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
            &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<img src="images/pregled.jpg" alt=""/>
            
            <div id="fot">
            <center><p>Movie Search App!</p></center>
           <center> <p>Thanks for stopping by! We hope to see you again soon.</p></center>
        
    </body>
</html>
