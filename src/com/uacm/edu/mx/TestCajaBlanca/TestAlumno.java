package com.uacm.edu.mx.TestCajaBlanca;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.uacm.edu.mx.Error.ExcepcionSistema;
import com.uacm.edu.mx.beans.Alumno;


class TestAlumno {

	//CP1
	@Test
	void testConstructorInvalidoMatriculaInvalida() {
		
		assertThrows(ExcepcionSistema.class, () -> {
			Alumno alumno= new Alumno("1-011-77","Luis","Delgado", "Padilla", "usuario", "contrase�a");
		});
	}
	
	//CP2
	@Test
	void testConstructorInvalidoNombreInvalido() {
		
		assertThrows(ExcepcionSistema.class, () -> {
			Alumno alumno= new Alumno("14-011-7709","luis","Delgado", "Padilla", "usuario", "contrase�a");
		});
	}
	
	//CP3
	@Test
	void testConstructorInvalidoaApellidoPaternoInvalido() {
		
		assertThrows(ExcepcionSistema.class, () -> {
			Alumno alumno= new Alumno("14-011-7709","Luis","delgado", "Padilla", "usuario", "contrase�a");
		});
	}
	
	//CP4
	@Test
	void testConstructorInvalidoaApellidoMaternoInvalido() {
		
		assertThrows(ExcepcionSistema.class, () -> {
			Alumno alumno= new Alumno("14-011-7709","Luis","Delgado", "padilla", "usuario", "contrase�a");
		});
	}
	
	//CP5
		@Test
		void testConstructorInvalidoaApellidoMaterno() {
			
			assertThrows(ExcepcionSistema.class, () -> {
				Alumno alumno= new Alumno("14-011-7709","Luis","Delgado", "catalan", "usuario", "contrase�a");
			});
		}
		
}
