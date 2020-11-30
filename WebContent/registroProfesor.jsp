<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro</h1>
        <br>
        ${mensaje}
        <br>
         <form name="form1" action="ControladorRegistro" method="get">
             
            Matricula:<input type="text" name="matricula"/>
            Nombre:<input type="text" name="nombre"/>
            Apellido paterno:<input type="text" name="apPaterno"/>
            Apellido materno:<input type="text" name="apMaterno"/>
            Usuario:<input type="text" name="usuario"/>
            Password:   <input type="text" name="password"/>
                          
            <input type="submit" value="Registrate"/>
        </form>
        
        <br>
        <br>
        <a href="profesorLogin.jsp">Regresar</a>
    </body>
</html>
