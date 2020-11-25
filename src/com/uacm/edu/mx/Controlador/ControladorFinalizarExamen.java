package com.uacm.edu.mx.Controlador;

import com.uacm.edu.mx.BD.Consultas;
import com.uacm.edu.mx.beans.Alumno;
import com.uacm.edu.mx.beans.Preguntas;
import com.uacm.edu.mx.beans.Respuestas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControladorFinalizarExamen")
public class ControladorFinalizarExamen extends HttpServlet {

    Consultas consulta = new Consultas();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String idExamen = request.getParameter("idExamen");
            
            String usuario = request.getParameter("usuario");
            
            int i = 0, buenas = 0, malas = 0;
            String res = ""; 
            String pre ="";
            
            //ArrayList<Respuestas> respuestas = new ArrayList<>();
            //ArrayList<Preguntas> preguntas = new ArrayList<>();
            ArrayList<String> respuestasBuenas = new ArrayList<>();
            ArrayList<String> respuestasMalas = new ArrayList<>();
            ArrayList<Alumno> alumno = new ArrayList<>();
            
            
            try {
                //respuestas = consulta.MostrarRespuestas();
                
                //preguntas = consulta.PreguntasExamen(idExamen);
                respuestasBuenas = consulta.respuestasBuenas(idExamen);
                respuestasMalas = consulta.respuestasMalas(idExamen);
                String buena = consulta.numBuenas(idExamen);
                String mala = consulta.numMalas(idExamen);
                request.setAttribute("buena", buena);
                request.setAttribute("mala", mala);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorFinalizarExamen.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            alumno = consulta.datos(usuario);
            
            consulta.limpiarRespuestas();
            //while(i <= respuestas.size()){
                //res = respuestas.get(i).getRespuesta();
                //pre = preguntas.get(i).getRespuestaCorrecta();
               // if( == true){
                 //   buenas = buenas + 1;
                    
                   // respuestasBuenas.add(res);
               // }
               // else{
                 //   malas = malas +1;
                  //  respuestasMalas.add(pre);
                //}
              //  i++;
            //}
            
            request.getSession().setAttribute("buenas", respuestasBuenas);
            request.getSession().setAttribute("malas", respuestasMalas);
            request.getSession().setAttribute("alumno", alumno);
            
            response.sendRedirect("Resultados.jsp");
        }
    }

}
