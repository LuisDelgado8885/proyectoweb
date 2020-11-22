package com.uacm.edu.mx.beans;

import com.uacm.edu.mx.BD.Consultas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Materia {
    
    private String idMateria;
    private String nombre;

    Consultas consulta = new Consultas();
    
    public Materia(String idMateria, String nombre) {
        this.idMateria = idMateria;
        this.nombre = nombre;
    }

    public Materia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean getAlta(){
        return consulta.registrarMaterias(this.idMateria, this.nombre);
    }
    
    public static ArrayList<Materia> getLista() throws ClassNotFoundException{
    ArrayList<Materia> datos = new ArrayList<>();
    Class.forName("com.mysql.jdbc.Driver");
    try{
       Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost/examen","root","l4g4rt0");
        Statement miStatement = miConexion.createStatement();
        String consulta = "SELECT * FROM MATERIAS";
        ResultSet rs = miStatement.executeQuery(consulta);
        
        while(rs.next()){
            datos.add(new Materia(rs.getString(1), rs.getString(2)));
        }
        rs.close();
        miConexion.close();
        
    }catch(Exception e){
        System.out.println("Ha habido un error");
    }
    return datos;
  }
}
