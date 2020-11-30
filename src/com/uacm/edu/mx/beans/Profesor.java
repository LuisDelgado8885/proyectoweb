package com.uacm.edu.mx.beans;

import java.util.ArrayList;

import com.uacm.edu.mx.BD.Consultas;
import com.uacm.edu.mx.Error.ExcepcionSistema;

public class Profesor {

	private String matricula;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String usuario;
    private String password;
    
    Consultas consulta = new Consultas();

    public Profesor(String matricula, String nombre, String apPaterno, String apMaterno, String usuario, String password) throws ExcepcionSistema{
    	if(matricula.matches("[0-9]{3}-[0-9]{2}-[0-9]{2}") && nombre.matches("^([A-Z]{1}[a-z|ñ|Ñ|á|é|í|ó|ú]+[ ]?){1,4}$") && apPaterno.matches("^([A-Z]{1}[a-z]+[ ]?){1,2}$") && apMaterno.matches("^([A-Z]{1}[a-z]+[ ]?){1,2}$"))
    	{
    		this.matricula = matricula;
    		this.nombre = nombre;
    		this.apPaterno = apPaterno;
    		this.apMaterno = apMaterno;
    		this.usuario = usuario;
    		this.password = password;
    	}
    	else {
    		throw new ExcepcionSistema("No se pueden ingresar valores en ese formato");
    	}
    }

    public Profesor() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Profesor(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) throws ExcepcionSistema {
        if(matricula.matches("[0-9]{3}-[0-9]{2}-[0-9]{2}")) {
        	this.matricula = matricula;
        }
        else {
        	throw new ExcepcionSistema("No se pueden ingresar valores en ese formato");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws ExcepcionSistema {
        if(nombre.matches("^([A-Z]{1}[a-z|ñ|Ñ|á|é|í|ó|ú]+[ ]?){1,4}$")) {
    	this.nombre = nombre;
        }
        else {
        	throw new ExcepcionSistema("No se pueden ingresar valores en ese formato");
        }
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) throws ExcepcionSistema {
        if(apPaterno.matches("^([A-Z]{1}[a-z]+[ ]?){1,2}$")) {
    	
        	this.apPaterno = apPaterno;
        }
        else {
        	throw new ExcepcionSistema("No se pueden ingresar valores en ese formato");
        }
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) throws ExcepcionSistema {
        if(apPaterno.matches("^([A-Z]{1}[a-z]+[ ]?){1,2}$")) {
        	this.apMaterno = apMaterno;
        }
        else {
        	throw new ExcepcionSistema("No se pueden ingresar valores en ese formato");
        }
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
        return consulta.registrarProfesor(this.matricula, this.nombre, this.apPaterno, this.apMaterno, this.usuario, this.password);
    }
            
    public ArrayList<Profesor> getLogin(String usuario, String password){
       String usu = usuario;
       String pass = password;
        return consulta.loginProfesor(usu, pass);
    }
}
