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
public class Examenes {
    
    private String idExamen;
    private String idMateria;
    private int numPreguntas;
    
    Consultas consulta = new Consultas();

    public Examenes(String idExamen, String idMateria, int numPreguntas) {
        this.idExamen = idExamen;
        this.idMateria = idMateria;
        this.numPreguntas = numPreguntas;
    }

    public Examenes() {
        
            }

    public String getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(String idExamen) {
        this.idExamen = idExamen;
    }

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    public int getNumPreguntas() {
        return numPreguntas;
    }

    public void setNumPreguntas(int numPreguntas) {
        this.numPreguntas = numPreguntas;
    }
    
    public boolean getAlta(){
        return consulta.registrarExamen(this.idExamen, this.idMateria, this.numPreguntas);
    }
    
   
}
