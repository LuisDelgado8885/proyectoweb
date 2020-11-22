<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*, java.sql.*, com.uacm.edu.mx.beans.ExamenMaterias" %>
<%
    
    ArrayList<ExamenMaterias> datos = ExamenMaterias.getLista();
   request.setAttribute("datos", datos);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <c:forEach var="lista" items="${datos}">
            
        <li>
            Nombre de la materia: ${lista.nombre}
            <br>
            <br>
            Identificador de examen: ${lista.idExamen}
            <br>
            <br>
           </li>
        </c:forEach>
            <br>
            <br>
        <h1>Seccion de preguntas</h1>
        <form name="form4" action="ControladorPreguntas" method="get">
         
            Ingresa el identificador del examen:<input type="text" name="idExamen"/>
            <br>
            <br>
            Ingresa el numero de pregunta:<input type="text" name="idPregunta"/>
            <br>
            <br>
            Ingresa la pregunta:<input type="text" name="pregunta"/>
            <br>
            <br>
            Ingresa la respuesta correcta:<input type="text" name="respuestaCorrecta"/>
            <br>
            <br>
            Ingresa la respuesta posible:<input type="text" name="respuesta1"/>
            <br>
            <br>
            Ingresa la respuesta posible:<input type="text" name="respuesta2"/>
            <br>
            <br>
            <input type="submit" value="Guardar"/>
        </form>
    </body>
</html>
