
package kontroler;

import entiteti.User;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Model;

/**
 *
 * @author Dejan
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
        
        /* uzima podatak iz name "korisnik", vraca korisnika, isto tako 
        i za password, pravi objekat i kreira sesiju.
        */
        
        String korisnik = request.getParameter("korisnik");
        String password = request.getParameter("password");
        User u = Model.vratiUsera(korisnik, password);
        HttpSession session = request.getSession(true);

        
        /* ako je user ne postoji, redirektuje na login stranu. */
        
        if(u==null){response.sendRedirect("login.jsp");
        }
        
        /* ako je korisnik jednako 1 tj. admin
        uzima sve korisnike i stavlja ih u sesiju. */
        
        else{
          if(u.getPravaKorisnika().equals("1")){
            List<User> korisnici = Model.vratiSveUsere();
           session.setAttribute("svi", korisnici);
        } 
        
         RequestDispatcher rd = null;
         // objekat koji redirektuje na stanicu //
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Prijavljen je: " + korisnik + "</h1>");
           
            /* stavlja u sesiju pravo korisnika i redirektuje se na prikaz */
            
                session.setAttribute("pravaKorisnika", u.getPravaKorisnika());
                rd = request.getRequestDispatcher("prikaz.jsp");
        
            rd.forward(request, response);
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
