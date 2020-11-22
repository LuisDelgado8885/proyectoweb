<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*, java.sql.*, com.uacm.edu.mx.beans.Materia" %>
<%
    
    ArrayList<Materia> datos = Materia.getLista();
   request.setAttribute("datos", datos);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Añadir nuevo examen</h1>
        <p>Materias</p>
        <c:forEach var="lista" items="${datos}">
            
        <li>
            Identificador de materia: ${lista.idMateria}
            
            Nombre de la materia: ${lista.nombre}
           </li>
        </c:forEach>
            <br>
            <br>
        <form name="form3" action="ControladorExamen" method="get">
             
            Ingresa el identificador del examen: <input type="text" name="idExamen"/>
            <br>
            <br>
            Ingresa el identificador de la materia:<input type="text" name="idMateria"/>
            <br>
            <br>
            Ingresa el numero de preguntas:<input type="text" name="numPreguntas"/>
            <br>
            <br>
            <input type="submit" value="Guardar"/>
        </form>
        
    </body>
</html>
