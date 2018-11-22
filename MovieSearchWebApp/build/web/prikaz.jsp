<%-- 
    Document   : prikaz
    Created on : Aug 9, 2018, 8:02:36 PM
    Author     : Dejan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">        
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        
        <!-- uzima i vadi iz sesije pravo korisnika i pita,
        ako je 1, otvori admin stranicu, ako je 2 prikazuje ulogovanog korisnika -->
        
        <%!String pravaKorisnika;%>
        <%pravaKorisnika = (String)session.getAttribute("pravaKorisnika");%>
        
        <%if(pravaKorisnika.equals("1")){%>
        
        <br>
        <a href="admin.jsp"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b> ADMIN PAGE</b></a>
       
        
        <%@include file="navigacija.jsp" %> 
         
        
                <%}%>
                
      <%if(pravaKorisnika.equals("2")){%>
                
                <br>
                <%@include file="navigacija.jsp" %>
                <%}%>
                
                <br>
             
               
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="images/slika1.jpg" alt="Chania">
      <div class="carousel-caption">
      </div>
    </div>

    <div class="item">
      <img src="images/posters.jpg" alt="Cha">
      <div class="carousel-caption">
      </div>
    </div>

    <div class="item">
      
      <img src="images/thumb-1920-671543.jpg" alt="Flower">
      <div class="carousel-caption">
      </div>
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>

               <div id="reklama">
                   <p>Ads can be a pain, but they are our only way to maintain the server.
                       Patience is highly appreciated and we hope our service can be worth it.</p>
                   
               </div>
                
    <center><div id="movies">
                  
                    <img src="images/Screenshot_2018-09-06 Alpha (2018) Watch Movie Online Free 123movies.png" alt=""/>
                    <img src="images/Screenshot_2018-09-06 Damsel (2018) Watch Movie Online Free 123movies.png" alt=""/>
                    <img src="images/Screenshot_2018-09-06 Jurassic World Fallen Kingdom (2018) Watch Movie Online Free 123movies.png" alt=""/>
                    <img src="images/Screenshot_2018-09-06 Rampage (2018) Watch Movie Online Free 123movies.png" alt=""/>
                    <img src="images/Screenshot_2018-09-06 Ready Player One (2018) Watch Movie Online Free 123movies.png" alt=""/>
                    <img src="images/Screenshot_2018-09-06 Terminal (2018) Watch Movie Online Free 123movies.png" alt=""/>
                    <img src="images/Screenshot_2018-09-06 Skyscraper (2018) Watch Movie Online Free 123movies.png" alt=""/>
                    <img src="images/Screenshot_2018-09-06 Recovery Boys (2018) Watch Movie Online Free 123movies.png" alt=""/>
                    <img src="images/Screenshot_2018-09-06 Ocean's 8 (2018) Watch Movie Online Free 123movies.png" alt=""/>
        </div></center>
        
                <div id="foo">
                   <p>Movie Search Application. Copiright @ 2018</p>
                   
               </div>
        
    </body>
</html>
