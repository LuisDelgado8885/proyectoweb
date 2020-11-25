package com.uacm.edu.mx.beans;

import com.uacm.edu.mx.BD.Consultas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Respuestas {
    
    private String respuesta;
    
    Consultas consulta = new Consultas();

    public Respuestas(String respuesta) {
        this.respuesta = respuesta;
    }

    public Respuestas() {
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
    public boolean getAlta(){
        return consulta.GuardarRespuesta(this.respuesta);
    }

    
}
