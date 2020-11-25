package com.uacm.edu.mx.beans;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
	
public class ExamenMaterias {
    private String idExamen;
    private String nombre;

    public ExamenMaterias(String nombre, String idExamen) {
        this.idExamen = idExamen;
        this.nombre = nombre;
    }
    
    public static ArrayList<ExamenMaterias> getLista() throws ClassNotFoundException{
    ArrayList<ExamenMaterias> datos = new ArrayList<>();
    Class.forName("com.mysql.jdbc.Driver");
    try{
       Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost/examen","root","l4g4rt0");
        Statement miStatement = miConexion.createStatement();
        String consulta = "select nombre, idExamen from materias join examenes on examenes.idMateria = materias.idMateria";
        ResultSet rs = miStatement.executeQuery(consulta);
        
        while(rs.next()){
            datos.add(new ExamenMaterias(rs.getString(1), rs.getString(2)));
        }
        rs.close();
        miConexion.close();
        
    }catch(Exception e){
        System.out.println("Ha habido un error");
    }
    return datos;
  }

    public String getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(String idExamen) {
        this.idExamen = idExamen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
