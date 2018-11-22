<%-- 
    Document   : admin
    Created on : Aug 9, 2018, 10:57:48 PM
    Author     : Dejan
--%>

<%@page import="entiteti.User"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>&nbsp; Admin Page</h1>
        
        <!-- uzima sve korisnike preko atributa 'svi'
        i ispisuje tabelu korisnika -->
        
        <%!List<User> korisnici;%>
        <%korisnici = (List<User>) session.getAttribute("svi");%>
        
        <div id="admintab">
        <table border="1">
            <th>Ime<td>Prava</td></th>
            <%for(User u:korisnici){%>
        <tr><td><%=u.getName()%></td><td><%=u.getPravaKorisnika()%></td></tr>
        <%}%>
        </table>
        </div>
        <br>
        
        <!-- forma za brisanje korisnika-->
        
        <form name="forma" action="ObrisiServlet" method="POST">
             Enter "NAME" of user you want to delete: <input type="text" name="korisnikBrisi" value="" /><br><br>
            <input type="submit" value="Obrisi" />
        </form><br><br><br>
        
        <!-- froma za upload slike na zeljeno mesto -->
        
        <h3> Enter movie and picture for movie:</h3>
        <form action="UploadServlet" method="POST" enctype="multipart/form-data">
            <input type="file" name="slika" value="" /><br><br>
            <input type="submit" value="Upload" />
        </form><br><br>
        
        <a href="UgasiServlet">&nbsp;Log Out></a>
        
    </body>
</html>
