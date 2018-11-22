/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Base64;
import javassist.bytecode.ByteArray;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import jdk.internal.util.xml.impl.Input;

/**
 *
 * @author Dejan
 */
@WebServlet(name = "UploadServlet", urlPatterns = {"/UploadServlet"})
@MultipartConfig()
public class UploadServlet extends HttpServlet {

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

        // uzima fajl sliku, pretvara u bajt i prebacuje na zeljeno mesto. //
        
        Part ocekivaniFajl = request.getPart("slika");
        String slika = ocekivaniFajl.getSubmittedFileName();
        InputStream slikaStream = ocekivaniFajl.getInputStream();
        String path = "C:\\Users\\Grupa8\\Documents\\NetBeansProjects\\MovieSearchApp\\web\\images\\";
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int bajt;
        while ((bajt = slikaStream.read()) != -1) {
            bos.write(bajt);
        }

        try (OutputStream outputStream = new FileOutputStream(path + slika)) {
                    System.out.println("Krece unos slike....");

            bos.writeTo(outputStream);
             outputStream.close();
        }
       
        System.out.println("Uneli sliku....");

        String slikaB64 = Base64.getEncoder().encodeToString(bos.toByteArray());

        RequestDispatcher rd = null;

        request.setAttribute("slika", slikaB64);
        rd = request.getRequestDispatcher("images/");

        rd.forward(request, response);

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UploadServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UploadServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
