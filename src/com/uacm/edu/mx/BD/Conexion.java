package com.uacm.edu.mx.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet; 
import java.sql.Statement; 
import java.sql.SQLException;

public class Conexion {
    
       
    private Connection cnx;
    
    public Conexion(){
        if (cnx == null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen","root","l4g4rt0");
            }catch (SQLException ex){
                System.err.println("Error" + ex);
                
            } catch (ClassNotFoundException ex) {
            System.err.println("Error" + ex);
         }
        }
    }
    public Connection getConexion(){
            
            return cnx;
        }
}
