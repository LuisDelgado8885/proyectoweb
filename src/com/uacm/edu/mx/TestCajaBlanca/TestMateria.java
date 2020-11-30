package com.uacm.edu.mx.TestCajaBlanca;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.uacm.edu.mx.beans.Materia;

class TestMateria {

	//CP7
	@Test
	void test() {
		
		Materia materia = new Materia("5T","redes");
		
		assertTrue(materia.getAlta());
	}

}
