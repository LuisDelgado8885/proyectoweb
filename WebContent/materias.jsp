<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form name="form3" action="ControladorMaterias" method="get">
         
            Ingresa el identificador de la materia:<input type="text" name="idMateria"/>
            <br>
            <br>
            Ingresa el nombre de la materia:<input type="text" name="nombre"/>
            <br>
            <br>
            <input type="submit" value="Guardar"/>
        </form>
    </body>
</html>
