package com.uacm.edu.mx.Controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uacm.edu.mx.Error.ExcepcionSistema;
import com.uacm.edu.mx.beans.Alumno;
import com.uacm.edu.mx.beans.Profesor;

@WebServlet("/ControladorRegistro")
public class ControladorRegistro extends HttpServlet {

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           String matricula = request.getParameter("matricula");
           String nombre = request.getParameter("nombre");
           String apPaterno = request.getParameter("apPaterno");
           String apMaterno = request.getParameter("apMaterno");
           String usuario = request.getParameter("usuario");
           String password = request.getParameter("password");
           
           Profesor profesorNuevo = new Profesor(matricula,nombre,apPaterno,apMaterno,usuario,password);
           
           if(profesorNuevo.getAlta() == true){
               request.getRequestDispatcher("exito.jsp").forward(request, response);
           }
           else{
               request.getRequestDispatcher("Falla.jsp").forward(request, response);
           }
        } catch (ExcepcionSistema e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
