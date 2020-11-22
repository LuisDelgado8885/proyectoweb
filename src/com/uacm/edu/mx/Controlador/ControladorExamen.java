package com.uacm.edu.mx.Controlador;

import com.uacm.edu.mx.beans.Examenes;
import com.uacm.edu.mx.beans.Materia;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControladorExamen")
public class ControladorExamen extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             String idExamen = request.getParameter("idExamen");
             String idMateria = request.getParameter("idMateria");
             int numPreguntas = Integer.parseInt(request.getParameter("numPreguntas"));
             
             Examenes examen = new Examenes(idExamen, idMateria, numPreguntas);
             
             
             
             if(examen.getAlta() == true){
                 
               request.getRequestDispatcher("exitoExamenRegistro.jsp").forward(request, response);
           }
           else{
               request.getRequestDispatcher("fallaExamenRegistro.jsp").forward(request, response);
           }
          
        }
    }

}
