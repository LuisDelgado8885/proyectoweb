package com.uacm.edu.mx.TestCajaBlanca;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.uacm.edu.mx.Error.ExcepcionSistema;
import com.uacm.edu.mx.beans.Profesor;

class TestProfesor {

	//CP9
	@Test
	void testConstructorInvalidoMatriculaInvalida() {
		
		assertThrows(ExcepcionSistema.class, () -> {
		Profesor profesor= new Profesor("13-011-9890","Jorge","Ruiz", "Prado", "usuario", "contrase�a");
		});
	}
	
	//CP10
	@Test
	void testConstructorInvalidoNombreInvalido() {
		
		assertThrows(ExcepcionSistema.class, () -> {
			Profesor profesor= new Profesor("123-12-12","jorge","Ruiz", "Prado", "usuario", "contrase�a");
		});
	}
	
	//CP11
	@Test
	void testConstructorInvalidoaApellidoPaternoInvalido() {
		
		assertThrows(ExcepcionSistema.class, () -> {
			Profesor profesor= new Profesor("123-12-12","Jorge","ruiz", "Prado", "usuario", "contrase�a");
		});
	}
	
	//CP12
	@Test
	void testConstructorInvalidoaApellidoMaternoInvalido() {
		
		assertThrows(ExcepcionSistema.class, () -> {
			Profesor profesor= new Profesor("123-12-12","Jorge","Ruiz", "prado", "usuario", "contrase�a");
		});
	}

}
