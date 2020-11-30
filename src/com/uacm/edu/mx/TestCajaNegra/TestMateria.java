package com.uacm.edu.mx.TestCajaNegra;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.uacm.edu.mx.beans.Materia;

class TestMateria {

	//CP13
	@Test
	void testOrdenDeMateriasCorrecto() throws ClassNotFoundException {
		
		ArrayList<Materia> datos = Materia.getLista();
		
		ArrayList<Materia> registro = new ArrayList<>();
		
		Materia materia = new Materia("1", "programacion web");
		Materia materiaultima = new Materia("5T", "redes");
		registro.add(materia);
		registro.add(materiaultima);
		
		assertEquals(registro.get(0).getIdMateria(), datos.get(0).getIdMateria());
		assertEquals(registro.get(0).getNombre(), datos.get(0).getNombre());
		
		assertEquals(registro.get(1).getIdMateria(), datos.get(datos.size()-1).getIdMateria());
		assertEquals(registro.get(1).getNombre(), datos.get(datos.size()-1).getNombre());
		
	}

	//CP14
	@Test
	void testOrdenDeMateriasIncorrecto() throws ClassNotFoundException {
			
		ArrayList<Materia> datos = Materia.getLista();
		
		ArrayList<Materia> registro = new ArrayList<>();
		
		
		Materia materiaultima = new Materia("5T", "redes");
		
		registro.add(materiaultima);
	
		assertNotEquals(registro.get(0).getIdMateria(), datos.get(0).getIdMateria());
		assertNotEquals(registro.get(0).getNombre(), datos.get(0).getNombre());
		
		}
	
	//CP15
	@Test
	void testOrdenDeMateriasIncorrectoUltimoAPrimero() throws ClassNotFoundException {
				
		ArrayList<Materia> datos = Materia.getLista();
			
		ArrayList<Materia> registro = new ArrayList<>();
			
			
		Materia materiaultima = new Materia("1", "programacion web");
			
		registro.add(materiaultima);
		
		assertNotEquals(registro.get(0).getIdMateria(), datos.get(datos.size()-1).getIdMateria());
		assertNotEquals(registro.get(0).getNombre(), datos.get(datos.size()-1).getNombre());
			
	}
	
	
}
