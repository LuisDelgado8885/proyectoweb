package com.uacm.edu.mx.beans;

import com.uacm.edu.mx.BD.Consultas;
import java.util.ArrayList;


public class Alumno {
    
    private String matricula;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String usuario;
    private String password;
    
    Consultas consulta = new Consultas();

    public Alumno(String matricula, String nombre, String apPaterno, String apMaterno, String usuario, String password) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.usuario = usuario;
        this.password = password;
    }

    public Alumno() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Alumno(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean getAlta(){
        return consulta.registrar(this.matricula, this.nombre, this.apPaterno, this.apMaterno, this.usuario, this.password);
    }
            
    public ArrayList<Alumno> getLogin(String usuario, String password){
       String usu = usuario;
       String pass = password;
        return consulta.login(usu, pass);
    }
}
