package com.uacm.edu.mx.Controlador;

import com.uacm.edu.mx.beans.Materia;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControladorMaterias")
public class ControladorMaterias extends HttpServlet {

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
            String idMateria = request.getParameter("idMateria");
            String nombre = request.getParameter("nombre");
             
             Materia materia = new Materia(idMateria,nombre);
             
             if(materia.getAlta() == true){
               request.getRequestDispatcher("exitoMateriaRegistro.jsp").forward(request, response);
           }
           else{
               request.getRequestDispatcher("fallaMateriaRegistro.jsp").forward(request, response);
           }
        }
    }

}
