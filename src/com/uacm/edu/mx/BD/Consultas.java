package com.uacm.edu.mx.BD;

import com.uacm.edu.mx.beans.Alumno;
import com.uacm.edu.mx.beans.Examenes;
import com.uacm.edu.mx.beans.Materia;
import com.uacm.edu.mx.beans.Preguntas;
import com.uacm.edu.mx.beans.Profesor;
import com.uacm.edu.mx.beans.Respuestas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Consultas extends Conexion {
    
    public boolean registrar(String matricula, String nombre, String apPaterno, String apMaterno, String usuario, String password){
        
        PreparedStatement pst = null;
        try{
            
            String consulta = "insert into alumno (matricula,nombre,apPaterno, apMaterno, usuario, password) values(?,?,?,?,?,?) ";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, matricula);
            pst.setString(2, nombre);
            pst.setString(3, apPaterno);
            pst.setString(4, apMaterno);
            pst.setString(5, usuario);
            pst.setString(6, password);
            
            
            if(pst.executeUpdate() == 1){
                return true;
            }
            if(getConexion() != null) getConexion().close();
               if(pst != null) pst.close();
        }catch(Exception e){
            System.err.println("Error " + e);
        }
        return false;
    }
    
    public ArrayList<Alumno> login(String usuario, String password){
        
         ArrayList<Alumno> datos = new ArrayList<>();
         String consultaSql = "SELECT * FROM ALUMNO WHERE usuario = ? AND password = ?";
         try{
             PreparedStatement pst = null;
                
                pst = getConexion().prepareStatement(consultaSql);
                
                pst.setString(1, usuario);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    datos.add(new Alumno(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6)));
                }
                rs.close();
                }catch(Exception e){
           e.printStackTrace();
         }
                return datos;
    }
    
    public ArrayList<Materia>MostrarMaterias(){
        ArrayList<Materia> datos = new ArrayList<>();
        String sql = "select * from materias";
        try{
            
            Statement miStatement = null;
            
            miStatement = getConexion().createStatement();
            
            ResultSet rs = miStatement.executeQuery(sql);
            
            while(rs.next()){
                datos.add(new Materia(rs.getString(1), rs.getString(2)));
            }
            rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return datos;
    }
    
    public boolean registrarExamen(String idExamen, String idMateria, int numPreguntas){
        
        PreparedStatement pst = null;
        try{
            
            String consulta = "insert into examenes (idExamen,idMateria,numPreguntas) values(?,?,?) ";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, idExamen);
            pst.setString(2, idMateria);
            pst.setInt(3, numPreguntas);
            
            
            
            if(pst.executeUpdate() == 1){
                return true;
            }
            if(getConexion() != null) getConexion().close();
               if(pst != null) pst.close();
        }catch(Exception e){
            System.err.println("Error " + e);
        }
        return false;
    }
    
    public boolean registrarMaterias(String idMateria, String nombre){
        
        PreparedStatement pst = null;
        try{
            
            String consulta = "insert into materias (idMateria,nombre) values(?,?) ";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, idMateria);
            pst.setString(2, nombre);

            if(pst.executeUpdate() == 1){
                return true;
            }
            if(getConexion() != null) getConexion().close();
               if(pst != null) pst.close();
        }catch(Exception e){
            System.err.println("Error " + e);
        }
        return false;
    }
    
    public boolean registrarPreguntas(int idPregunta, String idExamen, String pregunta, String respuestaCorrecta, String respuesta1, String respuesta2){
        
        PreparedStatement pst = null;
        try{
            
            String consulta = "insert into preguntas (idPregunta,idExamen, pregunta, respuestaCorrecta, respuesta1, respuesta2) values(?,?,?,?,?,?) ";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, idPregunta);
            pst.setString(2, idExamen);
            pst.setString(3, pregunta);
            pst.setString(4, respuestaCorrecta);
            pst.setString(5, respuesta1);
            pst.setString(6, respuesta2);

            if(pst.executeUpdate() == 1){
                return true;
            }
            if(getConexion() != null) getConexion().close();
               if(pst != null) pst.close();
        }catch(Exception e){
            System.err.println("Error " + e);
        }
        return false;
    }
    
    public ArrayList<Examenes> datosExamen(String idExamen){
        
         ArrayList<Examenes> datos = new ArrayList<>();
         String consultaSql = "SELECT * FROM EXAMENES WHERE idExamen = ?";
         try{
             PreparedStatement pst = null;
                
                pst = getConexion().prepareStatement(consultaSql);
                
                pst.setString(1, idExamen);
               
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    datos.add(new Examenes(rs.getString(1), rs.getString(2), rs.getInt(3)));
                }
                rs.close();
                }catch(Exception e){
           e.printStackTrace();
         }
                return datos;
    }
    
    
    public ArrayList<Preguntas> listaPreguntas(String idExamen){
        
         ArrayList<Preguntas> datos = new ArrayList<>();
         String consultaSql = "SELECT * FROM PREGUNTAS WHERE idExamen = ?";
         try{
             PreparedStatement pst = null;
                
                pst = getConexion().prepareStatement(consultaSql);
                
                pst.setString(1, idExamen);
               
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    datos.add(new Preguntas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
                }
                rs.close();
                }catch(Exception e){
           e.printStackTrace();
         }
                return datos;
    }
    
    public ArrayList<Preguntas> PreguntasExamen(String idExamen){
        
         ArrayList<Preguntas> datos = new ArrayList<>();
         String consultaSql = "select idPregunta, idExamen, pregunta, respuestaCorrecta, respuesta1, respuesta2 from preguntas where idExamen = ?";
         try{
             PreparedStatement pst = null;
                
                pst = getConexion().prepareStatement(consultaSql);
                
                pst.setString(1, idExamen);
                
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    datos.add(new Preguntas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
                }
                //rs.close();
                }catch(Exception e){
           e.printStackTrace();
         }
                return datos;
    }
    
    public ArrayList<Preguntas>MostrarPreguntas(){
        ArrayList<Preguntas> datos = new ArrayList<>();
        String sql = "select * from pregutas";
        try{
            
            Statement miStatement = null;
            
            miStatement = getConexion().createStatement();
            
            ResultSet rs = miStatement.executeQuery(sql);
            
            while(rs.next()){
                datos.add(new Preguntas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
            rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return datos;
    }
    
    public boolean GuardarRespuesta(String respuesta){
        
        PreparedStatement pst = null;
        try{
            
            String consulta = "insert into respuestas (respuesta) values(?) ";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, respuesta);
           
            if(pst.executeUpdate() == 1){
                return true;
            }
            if(getConexion() != null) getConexion().close();
               if(pst != null) pst.close();
        }catch(Exception e){
            System.err.println("Error " + e);
        }
        return false;
    }
    
    public  ArrayList<Respuestas>MostrarRespuestas(){
        ArrayList<Respuestas> datos = new ArrayList<>();
        String sql = "select * from respuestas";
        try{
            
            Statement miStatement = null;
            
            miStatement = getConexion().createStatement();
            
            ResultSet rs = miStatement.executeQuery(sql);
            
            while(rs.next()){
                datos.add(new Respuestas(rs.getString(1)));
            }
            rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return datos;
    }
    
    public  ArrayList<String> respuestasBuenas(String idExamen) throws ClassNotFoundException{
    ArrayList<String> datos = new ArrayList<>();
    ArrayList<Preguntas> preguntas = new ArrayList<>();
    ArrayList<Respuestas> respuestas = new ArrayList<>();
    int i, j;
    Class.forName("com.mysql.jdbc.Driver");
    try{
       Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen","root","l4g4rt0");
        Statement miStatement = miConexion.createStatement();
        
        String consulta = "SELECT * FROM respuestas";
        String sql = "SELECT * FROM PREGUNTAS WHERE idExamen = ?";
        
                PreparedStatement pst = miConexion.prepareStatement(sql);
                pst.setString(1, idExamen);
                
        String pre = "";
        String res = "";
        ResultSet rs = miStatement.executeQuery(consulta);
        ResultSet miResulSet = pst.executeQuery();
        
        while(rs.next()){
            respuestas.add(new Respuestas(rs.getString(1)));
        }
        while(miResulSet.next()){
            preguntas.add(new Preguntas(miResulSet.getInt(1),miResulSet.getString(2), miResulSet.getString(3), miResulSet.getString(4), miResulSet.getString(5), miResulSet.getString(6)));
        }
        
        for(i=0; i <= preguntas.size(); i++){
                pre = preguntas.get(i).getRespuestaCorrecta();
                res = respuestas.get(i).getRespuesta();
                  if(pre.equals(res) == true){
                      datos.add(res);
                  }
                
            }
        
    }catch(Exception e){
        System.out.println("Ha habido un error");
    }
    return datos;
  }
    
 
  public ArrayList<Alumno> datos(String usuario){
        
         ArrayList<Alumno> datos = new ArrayList<>();
         String consultaSql = "SELECT * FROM ALUMNO WHERE usuario = ? ";
         try{
             PreparedStatement pst = null;
                
                pst = getConexion().prepareStatement(consultaSql);
                
                pst.setString(1, usuario);
                
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    datos.add(new Alumno(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6)));
                }
                rs.close();
                }catch(Exception e){
           e.printStackTrace();
         }
                return datos;
    }
  
  public  ArrayList<String> respuestasMalas(String idExamen) throws ClassNotFoundException{
    ArrayList<String> datos = new ArrayList<>();
    ArrayList<Preguntas> preguntas = new ArrayList<>();
    ArrayList<Respuestas> respuestas = new ArrayList<>();
    int i, j;
    Class.forName("com.mysql.jdbc.Driver");
    try{
       Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen","root","l4g4rt0");
        Statement miStatement = miConexion.createStatement();
        
        String consulta = "SELECT * FROM respuestas";
        String sql = "SELECT * FROM PREGUNTAS WHERE idExamen = ?";
        
                PreparedStatement pst = miConexion.prepareStatement(sql);
                pst.setString(1, idExamen);
                
        String pre = "";
        String res = "";
        ResultSet rs = miStatement.executeQuery(consulta);
        ResultSet miResulSet = pst.executeQuery();
        
        while(rs.next()){
            respuestas.add(new Respuestas(rs.getString(1)));
        }
        while(miResulSet.next()){
            preguntas.add(new Preguntas(miResulSet.getInt(1),miResulSet.getString(2), miResulSet.getString(3), miResulSet.getString(4), miResulSet.getString(5), miResulSet.getString(6)));
        }
        
        for(i=0; i <= preguntas.size(); i++){
                pre = preguntas.get(i).getRespuestaCorrecta();
                res = respuestas.get(i).getRespuesta();
                  if(pre.equals(res) != true){
                      datos.add(res);
                  }
                
            }
        
    }catch(Exception e){
        System.out.println("Ha habido un error");
    }
    return datos;
  }
  
  public  String numMalas(String idExamen) throws ClassNotFoundException{
    
    ArrayList<Preguntas> preguntas = new ArrayList<>();
    ArrayList<Respuestas> respuestas = new ArrayList<>();
    int i, j, malas = 0;
    String mala = "";
    Class.forName("com.mysql.jdbc.Driver");
    try{
       Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen","root","l4g4rt0");
        Statement miStatement = miConexion.createStatement();
        
        String consulta = "SELECT * FROM respuestas";
        String sql = "SELECT * FROM PREGUNTAS WHERE idExamen = ?";
        
                PreparedStatement pst = miConexion.prepareStatement(sql);
                pst.setString(1, idExamen);
                
        String pre = "";
        String res = "";
        ResultSet rs = miStatement.executeQuery(consulta);
        ResultSet miResulSet = pst.executeQuery();
        
        while(rs.next()){
            respuestas.add(new Respuestas(rs.getString(1)));
        }
        while(miResulSet.next()){
            preguntas.add(new Preguntas(miResulSet.getInt(1),miResulSet.getString(2), miResulSet.getString(3), miResulSet.getString(4), miResulSet.getString(5), miResulSet.getString(6)));
        }
        
        for(i=0; i <= preguntas.size(); i++){
                pre = preguntas.get(i).getRespuestaCorrecta();
                res = respuestas.get(i).getRespuesta();
                  if(pre.equals(res) != true){
                      malas = malas + 1;
                  }
                
            }
        
    }catch(Exception e){
        System.out.println("Ha habido un error");
    }
    
    mala = Integer.toString(malas);
    return mala;
  }
  
  public  String numBuenas(String idExamen) throws ClassNotFoundException{
    
    ArrayList<Preguntas> preguntas = new ArrayList<>();
    ArrayList<Respuestas> respuestas = new ArrayList<>();
    int i, j, buenas = 0;
    String buena = "";
    Class.forName("com.mysql.jdbc.Driver");
    try{
       Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen","root","l4g4rt0");
        Statement miStatement = miConexion.createStatement();
        
        String consulta = "SELECT * FROM respuestas";
        String sql = "SELECT * FROM PREGUNTAS WHERE idExamen = ?";
        
                PreparedStatement pst = miConexion.prepareStatement(sql);
                pst.setString(1, idExamen);
                
        String pre = "";
        String res = "";
        ResultSet rs = miStatement.executeQuery(consulta);
        ResultSet miResulSet = pst.executeQuery();
        
        while(rs.next()){
            respuestas.add(new Respuestas(rs.getString(1)));
        }
        while(miResulSet.next()){
            preguntas.add(new Preguntas(miResulSet.getInt(1),miResulSet.getString(2), miResulSet.getString(3), miResulSet.getString(4), miResulSet.getString(5), miResulSet.getString(6)));
        }
        
        for(i=0; i <= preguntas.size(); i++){
                pre = preguntas.get(i).getRespuestaCorrecta();
                res = respuestas.get(i).getRespuesta();
                  if(pre.equals(res) == true){
                      buenas = buenas + 1;
                  }
                
            }
        
    }catch(Exception e){
        System.out.println("Ha habido un error");
    }
    
    buena = Integer.toString(buenas);
    return buena;
  }
  
  public void limpiarRespuestas(){
      
        String sql = "delete from respuestas";
        try{
            
            Statement miStatement = null;
            
            miStatement = getConexion().createStatement();
            
            miStatement.executeUpdate(sql);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
  }
  
  public ArrayList<Profesor> loginProfesor(String usuario, String password){
      
      ArrayList<Profesor> datos = new ArrayList<>();
      String consultaSql = "SELECT * FROM PROFESOR WHERE usuario = ? AND password = ?";
      try{
          PreparedStatement pst = null;
             
             pst = getConexion().prepareStatement(consultaSql);
             
             pst.setString(1, usuario);
             pst.setString(2, password);
             ResultSet rs = pst.executeQuery();
             while(rs.next()){
                 datos.add(new Profesor(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6)));
             }
             rs.close();
             }catch(Exception e){
        e.printStackTrace();
      }
             return datos;
 }
  
  public boolean registrarProfesor(String matricula, String nombre, String apPaterno, String apMaterno, String usuario, String password){
      
      PreparedStatement pst = null;
      try{
          
          String consulta = "insert into profesor (matricula,nombre,apPaterno, apMaterno, usuario, password) values(?,?,?,?,?,?) ";
          pst = getConexion().prepareStatement(consulta);
          pst.setString(1, matricula);
          pst.setString(2, nombre);
          pst.setString(3, apPaterno);
          pst.setString(4, apMaterno);
          pst.setString(5, usuario);
          pst.setString(6, password);
          
          
          if(pst.executeUpdate() == 1){
              return true;
          }
          if(getConexion() != null) getConexion().close();
             if(pst != null) pst.close();
      }catch(Exception e){
          System.err.println("Error " + e);
      }
      return false;
  }
}
