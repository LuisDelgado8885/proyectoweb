package com.uacm.edu.mx.Controlador;

import com.uacm.edu.mx.beans.Preguntas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControladorInicioExamen")
public class ControladorInicioExamen extends HttpServlet {

   
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String idExamen = request.getParameter("idExamen");
            
            Preguntas pregunta = new Preguntas();
            
            ArrayList<Preguntas> datos = new ArrayList<>();
            
            datos = pregunta.getExamen(idExamen);
            
            if(datos.size() != 0){
               request.getSession().setAttribute("datos", datos);
               request.getSession().setAttribute("idExamen", idExamen);
               request.getRequestDispatcher("ContestarExamen.jsp").forward(request, response);
           }
           else{
               
               request.getRequestDispatcher("examenFaltante.jsp").forward(request, response);
           }
            
        }
    }

}
