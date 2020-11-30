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
		Profesor profesor= new Profesor("13-011-9890","Jorge","Ruiz", "Prado", "usuario", "contraseña");
		});
	}
	
	//CP10
	@Test
	void testConstructorInvalidoNombreInvalido() {
		
		assertThrows(ExcepcionSistema.class, () -> {
			Profesor profesor= new Profesor("123-12-12","jorge","Ruiz", "Prado", "usuario", "contraseña");
		});
	}
	
	//CP11
	@Test
	void testConstructorInvalidoaApellidoPaternoInvalido() {
		
		assertThrows(ExcepcionSistema.class, () -> {
			Profesor profesor= new Profesor("123-12-12","Jorge","ruiz", "Prado", "usuario", "contraseña");
		});
	}
	
	//CP12
	@Test
	void testConstructorInvalidoaApellidoMaternoInvalido() {
		
		assertThrows(ExcepcionSistema.class, () -> {
			Profesor profesor= new Profesor("123-12-12","Jorge","Ruiz", "prado", "usuario", "contraseña");
		});
	}

}
