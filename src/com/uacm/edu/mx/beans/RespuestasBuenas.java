package com.uacm.edu.mx.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author SAMS
 */
public class RespuestasBuenas {
    
    private String respuestas;

    public RespuestasBuenas(String respuestas) {
        this.respuestas = respuestas;
    }

    public String getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(String respuestas) {
        this.respuestas = respuestas;
    }
    
   
}
