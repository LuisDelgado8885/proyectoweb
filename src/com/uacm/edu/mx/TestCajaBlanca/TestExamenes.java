package com.uacm.edu.mx.TestCajaBlanca;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.uacm.edu.mx.beans.Examenes;


class TestExamenes {

	//CP6
	@Test
	void testExamenRegistro() {
		
		Examenes examen = new Examenes("5","2",5);
		
		assertTrue(examen.getAlta());
		
	}

}
