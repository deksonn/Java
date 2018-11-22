/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import entiteti.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Model;
import model.Util;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;

/**
 *
 * @author Dejan
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // uzima podatke iz parametara//
        
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String passwordCheck = request.getParameter("password2");

        //System.out.println(password);
        //User novi = new User(name, password);
        
        //proverava passw1 i passw2 da li su isti, ako jesu pravi objekat i cuva usera, 
          //  ako nije ispisuje gresku//
        
        if(password.equals(passwordCheck)){
        User noviUser = new User();
        noviUser.setName(name);
        noviUser.setPassword(password); 
        noviUser.setPravaKorisnika("2"); 
        Model.saveUser(noviUser);
        
        
                try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div style=\"background-color:royalblue; color:white; height: 100px; \">");
            out.println("<h1>&nbsp; Registrovan korisnik!</h1>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +name +"&nbsp;  "+password+ "<br><br>");
            out.println("</div><br><br>");
            out.println("<a href=\"login.jsp\">&nbsp;<h4><BACK TO LOG IN</h4></a>");
            out.println("<a href=\"UgasiServlet\">&nbsp;<h4><LOG OUT</h4></a>");
            out.println("<img src=\"images/pregled.jpg\">");
            out.println("<div style=\"background-color:royalblue; color:white; height: 100px; \">");
            out.println("<center><p>Movie Search App!</p></center>");
            out.println("<center><p>Thanks for stopping by! We hope to see you again soon.</p></center>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            
        }
                
                
        }
        
            
        
        /*Session sesija = Util.getSession().openSession();
        sesija.beginTransaction();
        sesija.save(novi);
        
        sesija.getTransaction().commit();
        if(sesija.isOpen()){
            sesija.close();
        }*/
        else{
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div style=\"background-color:royalblue; color:white; height: 100px; \">");
            out.println("<h1>&nbsp; Password is not entered correctly! </h1>");
            out.println("<a style=\"font-size:20px; color:white; \" href=\"register.jsp\">&nbsp; Try again!</a>");
            out.println("</div>");
            out.println("<img src=\"images/pregled.jpg\">");
            out.println("<div style=\"background-color:royalblue; color:white; height: 100px; \">");
            out.println("<center><h3>Movie Search App!</h3></center>");
            out.println("<center><h3>Thanks for stopping by! We hope to see you again soon.</h3></center>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            
        }
        
        
    }
    }
       

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
