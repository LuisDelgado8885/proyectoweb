package com.uacm.edu.mx.beans;

import com.uacm.edu.mx.BD.Consultas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author SAMS
 */
public class Preguntas {
    
    private int idPregunta;
    private String idExamen;
    private String pregunta;
    private String respuestaCorrecta;
    private String respuesta1;
    private String respuesta2;

    Consultas consulta = new Consultas();
    
    public Preguntas(int idPregunta, String idExamen, String pregunta, String respuestaCorrecta, String respuesta1, String respuesta2) {
        this.idPregunta = idPregunta;
        this.idExamen = idExamen;
        this.pregunta = pregunta;
        this.respuestaCorrecta = respuestaCorrecta;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
    }

    public Preguntas(int idPregunta, String pregunta, String respuestaCorrecta, String respuesta1, String respuesta2) {
        this.idPregunta = idPregunta;
        this.pregunta = pregunta;
        this.respuestaCorrecta = respuestaCorrecta;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
    }

    public Preguntas() {
      
    }


    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(String idExamen) {
        this.idExamen = idExamen;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }
    
    public boolean getAlta(){
        return consulta.registrarPreguntas(this.idPregunta, this.idExamen, this.pregunta, this.respuestaCorrecta, this.respuesta1, this.respuesta2);
    }
    
     public ArrayList<Preguntas> getExamen(String idExamen){
       String exam = idExamen;
       
        return consulta.PreguntasExamen(exam);
    }
    
     public static ArrayList<Preguntas> getLista() throws ClassNotFoundException{
    ArrayList<Preguntas> datos = new ArrayList<>();
    Class.forName("com.mysql.jdbc.Driver");
    try{
       Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost/examen","root","l4g4rt0");
        Statement miStatement = miConexion.createStatement();
        String consulta = "SELECT * FROM preguntas";
        ResultSet rs = miStatement.executeQuery(consulta);
        
        while(rs.next()){
            datos.add(new Preguntas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
        }
        rs.close();
        miConexion.close();
        
    }catch(Exception e){
        System.out.println("Ha habido un error");
    }
    return datos;
  }
}
