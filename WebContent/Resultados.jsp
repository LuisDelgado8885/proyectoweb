<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import = "java.util.*, java.sql.*,com.uacm.edu.mx.BD.Consultas" %>
<%@page contentType="application/vnd.ms-excel" %>
<%
    String nombreArchivo = "reporte2.xslx";
    
    response.setHeader("Content-Disposition", "inline; filename=" + nombreArchivo);
    
 %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Reporte de Excel</h1>
        
        Buenas ${buena}
        
        <br>
        malas ${mala}
        <table border="1">
            <tr>
                <th>Respuestas correctas</th>
                <th>Respuestas incorrectas</th>
            </tr>
            <tr>
                <td>
                    <c:forEach var="lista" items="${sessionScope.buenas}">
        
                        ${lista}
                        <br/>

                    </c:forEach>
                </td>
                <td>
                    <c:forEach var="lista" items="${sessionScope.malas}">
                        
                        ${lista}
                        <br>
                    </c:forEach>
                </td>
            </tr>

        </table>
      
        
        <table border="1">
            <tr>
                <th>Matricula</th>
                <th>Nombre Alumno</th>
                <th>Apellido paterno</th>
                <th>Apellido materno</th>
            </tr>
            <tr>
                <c:forEach var="lista" items="${sessionScope.alumno}">
            
                <td>
                    ${lista.matricula}
                </td>
                <td>
                    ${lista.nombre}
                </td>
                <td>
                   ${lista.apPaterno} 
                </td>
                <td>
                    ${lista.apMaterno}
                </td>
                 </c:forEach>
            </tr>
       
    </body>
</html>
