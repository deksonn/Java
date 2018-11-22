<%-- 
    Document   : login
    Created on : Aug 9, 2018, 5:06:31 PM
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
        
        <div id="log">
            <h1 id="cent"> Log in!</h1>
        
        <!-- forma koja se obraca login servletu -->
        
        
        <form name="forma" action="LoginServlet" method="POST">
           &nbsp; &nbsp; &nbsp; Enter your name: <input type="text" name="korisnik" value="" />
           &nbsp; Enter password: <input type="password" name="password" value="" />
           &nbsp;&nbsp;<input type="submit" value="Log in" />
        </form>
        </div>
        <br><br>
        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
        &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<img src="images/pregled.jpg" alt=""/>
        
        <div id="fot">
            <center><p>Movie Search App!</p></center>
            <center><p>Thanks for stopping by! We hope to see you again soon.</p></center>
        
    </body>
</html>
