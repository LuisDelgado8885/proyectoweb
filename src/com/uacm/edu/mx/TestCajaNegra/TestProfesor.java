package com.uacm.edu.mx.TestCajaNegra;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.uacm.edu.mx.Error.ExcepcionSistema;
import com.uacm.edu.mx.beans.Profesor;

class TestProfesor {

Profesor profesor = new Profesor();
	
	//CP21
	@Test
	void testMatriculaProfesorFormatoValido() throws ExcepcionSistema {
		
		
		profesor.setMatricula("123-45-67");
		
		assertEquals("123-45-67", profesor.getMatricula());
	}
	
	//CP22
	@Test
	void testMatriculaProfesorFormatoInvalido() {
			
			assertThrows(ExcepcionSistema.class, () -> {
				profesor.setMatricula("13-011-9890");
			});
		}

	//CP23
	@Test
	void testMatriculaProfesorFormatoInvalidoAlfanumerico() {
				
				assertThrows(ExcepcionSistema.class, () -> {
					profesor.setMatricula("24p-2r-5f");
				});
		}
	
	//CP24
	@Test
	void testNombreProfesorFormatoValido() throws ExcepcionSistema {
				
		profesor.setNombre("Jorge");
				
				assertEquals("Jorge", profesor.getNombre());
		}
	
	//CP25
	@Test
	void testNombreProfesorFormatoInvalido() throws ExcepcionSistema {
				
				assertThrows(ExcepcionSistema.class, () -> {
					profesor.setNombre("jorge");
				});
		}
	
	//CP26
	@Test
	void testApellidoPaternoProfesorFormatoValido() throws ExcepcionSistema {
					
		profesor.setApPaterno("Ruiz");
					
				assertEquals("Ruiz",profesor.getApPaterno());
		}
	
	//CP27
	@Test
	void testApellidoPaternoProfesorFormatoInvalido() {
					
				assertThrows(ExcepcionSistema.class, () -> {
					profesor.setApPaterno("ruiz");
				});
			}
		
	/*
	//CP28
	@Test
	void testApellidoMaternoProfesorFormatoValido() throws ExcepcionSistema {
				
				profesor.setApMaterno("Prado");
						
				assertEquals("Prado", profesor.getApMaterno());
			}
	
	//CP29
	@Test
	void testApellidoMaternoProfesorFormatoInvalido() {
						
		
				assertThrows(ExcepcionSistema.class, () -> {
					profesor.setApMaterno("prado");
				});
		}
		*/
	
	//CP30
	@Test
	void testLoginCorrecto() throws ExcepcionSistema {
						
			
		ArrayList<Profesor>datos = new ArrayList<>();
		
		ArrayList<Profesor> registro = new ArrayList<>();
		
		Profesor prof = new Profesor("123-12-12", "Jorge", "Ruiz", "Prado", "jorge", "pass");
		
		registro.add(prof);
			
		datos = profesor.getLogin("jorge", "pass");
		
		assertEquals(datos.containsAll(registro), registro.containsAll(datos));
			
		}
	
	//CP31
	@Test
	void testLoginIncorrectoUserPasswordSinRegistro() throws ExcepcionSistema {
							
				
		ArrayList<Profesor>datos = new ArrayList<>();
				
		datos = profesor.getLogin("profe", "profe");
		
		assertTrue(datos.isEmpty());
				
	}
	
	//CP32
	@Test
	void testLoginIncorrectoUserPasswordDiferente() throws ExcepcionSistema {
								
					
		ArrayList<Profesor>datos = new ArrayList<>();
					
		datos = profesor.getLogin("jorge", "password");
			
		assertTrue(datos.isEmpty());
					
		}

}
