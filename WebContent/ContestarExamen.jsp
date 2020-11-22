<%@page import="java.util.ArrayList, com.uacm.edu.mx.beans.CantidadPreguntas"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
         
        <c:forEach var="lista" items="${sessionScope.datos}">
            
            <br/>
            Num de pregunta: ${lista.idPregunta}
            <br/>
            Pregunta: ${lista.pregunta}
            <br/>
            respuestas:
            
            ${lista.respuestaCorrecta}
            <br/>
            ${lista.respuesta1}
            <br/>
            ${lista.respuesta2}
             <br/>
             <form name="form7" action="ControladorContestarExamen" method="get">
                 
             Ingresar respuesta: <input type="text" name="respuesta"/>
             <input type="submit" value="Guardar"/>
            </form>
            <hr/>
        </c:forEach>
            <form name="form8" action="ControladorFinalizarExamen" method="get"> 
                <p>Confirmar</p>
                 examen: <input type="text" name="idExamen"/>
                  usuario: <input type="text" name="usuario"/>
            <input type="submit" value="Terminar"/>
        </form>
          
    </body>
</html>
