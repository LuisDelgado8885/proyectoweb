package com.uacm.edu.mx.TestCajaNegra;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.uacm.edu.mx.Error.ExcepcionSistema;
import com.uacm.edu.mx.beans.Alumno;

class TestAlumno {

	Alumno alumno = new Alumno();
	
	//CP1
	@Test
	void testMatriculaAlumnoFormatoValido() throws ExcepcionSistema {
		
		
		alumno.setMatricula("14-011-0577");
		
		assertEquals("14-011-0577", alumno.getMatricula());
	}
	
	//CP2
	@Test
	void testMatriculaAlumnoFormatoInvalido() {
			
			assertThrows(ExcepcionSistema.class, () -> {
				alumno.setMatricula("1-011-77");
			});
		}

	//CP3
	@Test
	void testMatriculaAlumnoFormatoInvalidoAlfanumerico() {
				
				assertThrows(ExcepcionSistema.class, () -> {
					alumno.setMatricula("1p-01m-05tq");
				});
		}
	
	//CP4
	@Test
	void testNombreAlumnoFormatoValido() throws ExcepcionSistema {
				
				alumno.setNombre("Lorena");
				
				assertEquals("Lorena", alumno.getNombre());
		}
	
	//CP5
	@Test
	void testNombreAlumnoFormatoInvalido() throws ExcepcionSistema {
				
				assertThrows(ExcepcionSistema.class, () -> {
					alumno.setNombre("luis");
				});
		}
	
	//CP6
	@Test
	void testApellidoPaternoAlumnoFormatoValido() throws ExcepcionSistema {
					
				alumno.setApPaterno("Ocampo");
					
				assertEquals("Ocampo", alumno.getApPaterno());
		}
	
	//CP7
	@Test
	void testApellidoPaternoAlumnoFormatoInvalido() {
					
				assertThrows(ExcepcionSistema.class, () -> {
					alumno.setApPaterno("delgado");
				});
			}
		
	/*
	//CP8
	@Test
	void testApellidoMaternoAlumnoFormatoValido() throws ExcepcionSistema {
				
				alumno.setApMaterno("Padilla");
						
				assertEquals("Padilla", alumno.getApMaterno());
			}
	
	//CP9
	@Test
	void testApellidoMaternoAlumnoFormatoInvalido() {
						
		
				assertThrows(ExcepcionSistema.class, () -> {
					alumno.setApMaterno("catalan");
				});
		}
	*/	

	
	//CP10
	@Test
	void testLoginCorrecto() throws ExcepcionSistema {
						
			
		ArrayList<Alumno>datos = new ArrayList<>();
		
		ArrayList<Alumno> registro = new ArrayList<>();
		
		Alumno alum = new Alumno("13-011-0091", "Lorena", "Ocampo", "Catalan", "loreOC", "L0r3n4");
		
		registro.add(alum);
			
		datos = alumno.getLogin("loreOC", "L0r3n4");
		
		assertEquals(datos.containsAll(registro), registro.containsAll(datos));
			
		}
	
	//CP11
	@Test
	void testLoginIncorrectoUserPasswordSinRegistro() throws ExcepcionSistema {
							
				
		ArrayList<Alumno>datos = new ArrayList<>();
				
		datos = alumno.getLogin("user", "pass");
		
		assertTrue(datos.isEmpty());
				
	}
	
	//CP12
	@Test
	void testLoginIncorrectoUserPasswordDiferente() throws ExcepcionSistema {
								
					
		ArrayList<Alumno>datos = new ArrayList<>();
					
		datos = alumno.getLogin("loreOC", "l4g4rt0");
			
		assertTrue(datos.isEmpty());
					
		}
	
}
