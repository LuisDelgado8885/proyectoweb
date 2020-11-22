package com.uacm.edu.mx.Controlador;

import com.uacm.edu.mx.BD.Consultas;
import com.uacm.edu.mx.beans.Examenes;
import com.uacm.edu.mx.beans.Preguntas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControladorPreguntas")
public class ControladorPreguntas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    Consultas consulta = new Consultas();
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String idExamen = request.getParameter("idExamen");
            int idPregunta = Integer.parseInt(request.getParameter("idPregunta"));
            String pregunta = request.getParameter("pregunta");
             String respuestaCorrecta = request.getParameter("respuestaCorrecta");
             String respuesta1 = request.getParameter("respuesta1");
             String respuesta2 = request.getParameter("respuesta2");
             
             int numPreguntas, cantidadPreguntas,i,acum = 0;
             
             Preguntas preguntas = new Preguntas(idPregunta, idExamen, pregunta, respuestaCorrecta, respuesta1, respuesta2);
             
            // Consultas consulta = new Consultas();
             
             ArrayList<Examenes> examenSeleccionado = new ArrayList<>();
             
             ArrayList<Preguntas> listaPreguntas = new ArrayList<>();
             
             examenSeleccionado = consulta.datosExamen(idExamen);
             
             numPreguntas = examenSeleccionado.get(0).getNumPreguntas();
             
            listaPreguntas = consulta.listaPreguntas(idExamen);
             
             if(listaPreguntas.size() == 0){
                 
                 if(preguntas.getAlta() == true){
                         request.getRequestDispatcher("exitoPregunta.jsp").forward(request, response);
                        }
                        else{
                            request.getRequestDispatcher("fallaPregunta.jsp").forward(request, response);
                            }
                 
             }
           else
             {
                 
                 //tomar el ultimo elemento de la lista y tomar el id de ese elemento 
                 //para evaluarlo con el numPreguntas del examen
                 cantidadPreguntas = listaPreguntas.get(listaPreguntas.size()-1).getIdPregunta();
                 if(numPreguntas != cantidadPreguntas){
                     
                     
                     if(preguntas.getAlta() == true){
                         request.getRequestDispatcher("exitoPregunta.jsp").forward(request, response);
                        }
                        else{
                            request.getRequestDispatcher("fallaPregunta.jsp").forward(request, response);
                            }
                     }
                 else{
                     response.sendRedirect("fallaPreguntaLleno.jsp");
                 }
             }
        }
    }
}


