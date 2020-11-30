package com.uacm.edu.mx.TestCajaNegra;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.uacm.edu.mx.beans.Materia;
import com.uacm.edu.mx.beans.Preguntas;

class TestPreguntas {

	//CP16
	@Test
	void testExamenExistente() {
		
		Preguntas preguntas = new Preguntas();
		
		ArrayList<Preguntas> datos = new ArrayList<>();
		
		ArrayList<Preguntas> examen = new ArrayList<>();
		
		datos = preguntas.getExamen("1");
		
		examen = preguntas.getExamen("1");
		
		assertEquals(datos.containsAll(examen), examen.containsAll(datos));
	}
	
	//CP17
		@Test
		void testExamenNoExistente() {
			
		Preguntas preguntas = new Preguntas();
			
		ArrayList<Preguntas> datos = new ArrayList<>();
			
		datos = preguntas.getExamen("10");
			
		assertTrue(datos.isEmpty());
	}
		
	//CP18
	@Test
	void testOrdenPreguntasValido() {
					
		Preguntas preguntas = new Preguntas();
		
		ArrayList<Preguntas> datos = new ArrayList<>();
		
		datos = preguntas.getExamen("1");
		
		ArrayList<Preguntas> registro = new ArrayList<>();
		
		Preguntas pregunta = new Preguntas(1, "1", "que significan las siglas JSP", "Java Server Pages", "Java Services Pages", "Java System Personal");
		
		registro.add(pregunta);
		
		assertEquals(registro.get(0).getIdPregunta(), datos.get(0).getIdPregunta());
		assertEquals(registro.get(0).getIdExamen(), datos.get(0).getIdExamen());
		assertEquals(registro.get(0).getPregunta(), datos.get(0).getIdPregunta());
		assertEquals(registro.get(0).getRespuestaCorrecta(), datos.get(0).getRespuestaCorrecta());
		assertEquals(registro.get(0).getRespuesta1(), datos.get(0).getRespuesta1());
		assertEquals(registro.get(0).getRespuesta2(), datos.get(0).getRespuesta2());
		
	}
	
	//CP19
		@Test
		void testOrdenPreguntasInvalido() {
						
		Preguntas preguntas = new Preguntas();
			
		ArrayList<Preguntas> datos = new ArrayList<>();
			
		datos = preguntas.getExamen("1");
			
		ArrayList<Preguntas> registro = new ArrayList<>();
			
		Preguntas pregunta = new Preguntas(2, "1", "que significa las siglas mvc", "modelo vista controlador", "modulo versión control", "mapa de vistas compactadas");
			
		registro.add(pregunta);
			
		assertNotEquals(registro.get(0).getIdPregunta(), datos.get(0).getIdPregunta());
		assertEquals(registro.get(0).getIdExamen(), datos.get(0).getIdExamen());
		assertNotEquals(registro.get(0).getPregunta(), datos.get(0).getIdPregunta());
		assertNotEquals(registro.get(0).getRespuestaCorrecta(), datos.get(0).getRespuestaCorrecta());
		assertNotEquals(registro.get(0).getRespuesta1(), datos.get(0).getRespuesta1());
		assertNotEquals(registro.get(0).getRespuesta2(), datos.get(0).getRespuesta2());
			
		}

		//CP120
		@Test
		void testOrdenPreguntasInvalidoPrimerUltimo() {
								
		Preguntas preguntas = new Preguntas();
					
		ArrayList<Preguntas> datos = new ArrayList<>();
					
		datos = preguntas.getExamen("1");
					
		ArrayList<Preguntas> registro = new ArrayList<>();
					
		Preguntas pregunta = new Preguntas(1, "1", "que significan las siglas JSP", "Java Server Pages", "Java Services Pages", "Java System Personal");
					
		registro.add(pregunta);
					
		assertNotEquals(registro.get(0).getIdPregunta(), datos.get(datos.size()-1).getIdPregunta());
		assertEquals(registro.get(0).getIdExamen(), datos.get(datos.size()-1).getIdExamen());
		assertNotEquals(registro.get(0).getPregunta(), datos.get(datos.size()-1).getIdPregunta());
		assertNotEquals(registro.get(0).getRespuestaCorrecta(), datos.get(datos.size()-1).getRespuestaCorrecta());
		assertNotEquals(registro.get(0).getRespuesta1(), datos.get(datos.size()-1).getRespuesta1());
		assertNotEquals(registro.get(0).getRespuesta2(), datos.get(datos.size()-1).getRespuesta2());
					
	}

	
}
