package com.uacm.edu.mx.Controlador;

import com.uacm.edu.mx.BD.Consultas;

import com.uacm.edu.mx.beans.Preguntas;
import com.uacm.edu.mx.beans.Respuestas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControladorContestarExamen")
public class ControladorContestarExamen extends HttpServlet {

    Consultas consulta = new Consultas();
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String respuesta = request.getParameter("respuesta");
            
            Respuestas respuestas = new Respuestas(respuesta);
            
            if(respuestas.getAlta() == true){
                 
               request.getRequestDispatcher("ContestarExamen.jsp").forward(request, response);
           }
           else{
               request.getRequestDispatcher("ContestarExamen.jsp").forward(request, response);
           }
            
        }
    }
       
 }

