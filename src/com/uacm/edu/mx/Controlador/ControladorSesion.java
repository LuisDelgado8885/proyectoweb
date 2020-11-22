package com.uacm.edu.mx.Controlador;

import com.uacm.edu.mx.beans.Alumno;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControladorSesion")
public class ControladorSesion extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           String usuario = request.getParameter("usuario");
           String password = request.getParameter("password");
           
           Alumno alumnoLogin = new Alumno();
           
           ArrayList<Alumno>datos = new ArrayList<>();
           
           datos = alumnoLogin.getLogin(usuario,password);
          if(datos.size() != 0){
               request.getSession().setAttribute("datos", datos);
               request.getRequestDispatcher("exitoLogin.jsp").forward(request, response);
           }
           else{
               request.getSession().setAttribute("mensaje", "Usuario y/o contraseña incorrectos");
               request.getRequestDispatcher("fallaLogin.jsp").forward(request, response);
           }
        }
    }
}
