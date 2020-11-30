<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
       
        <br>
        <br>
         <form name="form2" action="ControladorSesion" method="get">
             
            Usuario: <input type="text" name="usuario"/>
            Password:<input type="text" name="password"/>
                          
            <input type="submit" value="Iniciar sesion"/>
        </form>
        
        <br>
        <br>
        <div id="contenedorBoton">
            <input type="button" value="Registrate" onclick="window.location.href='registro.jsp'"/>
        </div>
        
            
    </body>
</html>
