<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*, java.sql.*, com.uacm.edu.mx.beans.ExamenMaterias" %>
<%
    
    ArrayList<ExamenMaterias> datos = ExamenMaterias.getLista();
   request.setAttribute("datos1", datos);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login con exito</h1>
        <c:forEach var="lista" items="${sessionScope.datos}">
            Bienvenido
            <br/>
            usuario: ${lista.usuario}
            <br/>
            Nombre: ${lista.nombre}
           
        </c:forEach>
            
            <p>Selecciona el examen a presentar</p>
            <br>
            
            <c:forEach var="lista2" items="${datos1}">
            
        <li>
            Nombre de la materia: ${lista2.nombre}
            <br>
            <br>
            Identificador de examen: ${lista2.idExamen}
            <br>
            
           </li>
        </c:forEach>
           
          <form name="form5" action="ControladorInicioExamen" method="get">
             
            Ingresar el identificador del examen: <input type="text" name="idExamen"/>
                          
            <input type="submit" value="Iniciar examen"/>
        </form> 
            
    </body>
</html>